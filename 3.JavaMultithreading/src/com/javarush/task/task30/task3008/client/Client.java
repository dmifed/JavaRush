package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by DIMA on 08.11.2017.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    //input adress Server (string)
    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Please input adress Server");
        return ConsoleHelper.readString();
    }

    //input port (int)
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Please input port");
        return ConsoleHelper.readInt();
    }

    //input userName (string)
    protected String getUserName(){
        ConsoleHelper.writeMessage("Please input userName");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    //отправка сообщения
    protected void sendTextMessage(String text){
        try{
            connection.send(new Message(MessageType.TEXT, text));
        }catch (IOException e){
            ConsoleHelper.writeMessage("IOExeption has occured in Client.sendTextMessage(" + text + ") " + e);
            clientConnected = false;

        }

    }

    //Запуск потока для чтения и отправки сообщений юзера
    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this){
            try {
                wait();
            }catch (InterruptedException e){
                ConsoleHelper.writeMessage("sockerThread InterrupredException " + e);
            }
            if (clientConnected){
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
            }else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
            while (clientConnected){
                String str = ConsoleHelper.readString();
                if(str.equals("exit")){
                    break;
                }
                if(shouldSendTextFromConsole()){
                    sendTextMessage(str);
                }

            }

        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    // Отвечает за поток устанавливающий сокетное соединение и читает сообщения сервера
    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + "Add to chat");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + "Removed from chat");
        }

        //уведомление о изменении статуса соединения
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }

        }

        //Представляет клиента серверу
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.NAME_REQUEST){
                    String userName = getUserName();
                    Message message1 = new Message(MessageType.USER_NAME, userName);
                    connection.send(message1);
                }else if(message.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                }else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        //Обработка сообщений сервера
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    processIncomingMessage(message.getData());
                }else if(message.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(message.getData());
                }else if(message.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(message.getData());
                }else {
                    throw new IOException("Unexpected MessageType");
                }
            }


        }

        public void run(){
            String serverAdress = getServerAddress();
            int serverPort = getServerPort();
            try{
                Socket socket = new Socket(serverAdress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            }catch (IOException e){
                notifyConnectionStatusChanged(false);
            }catch (ClassNotFoundException e){
                notifyConnectionStatusChanged(false);
            }

        }

    }
}
