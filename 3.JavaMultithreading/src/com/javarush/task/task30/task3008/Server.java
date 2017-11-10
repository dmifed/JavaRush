package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by DIMA on 03.11.2017.
 */
public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    // запуск Handler
    public static void main(String[] args) throws IOException{
        int adress = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(adress)){
            ConsoleHelper.writeMessage("Server start!");
            while (true){
                    Handler handler = new Handler(serverSocket.accept());
                    handler.start();
            }
        }catch (IOException e){
            ConsoleHelper.writeMessage("Exception of create serverSocket" + e);
        }
    }

    // Рассылка сообщений
    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
            try {
                entry.getValue().send(message);
            }catch (IOException e){
                ConsoleHelper.writeMessage("Can't send message. Couse is" + e);
            }

        }
    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        // Запрос и валидация юзера
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if(message.getType().equals(MessageType.USER_NAME)){
                    String user = message.getData();
                    if (!user.isEmpty() && !connectionMap.containsKey(user)){
                        connectionMap.put(user, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return user;
                    }
                }
            }
        }

        // Рассылка о добавлении юзера
        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String, Connection> entry : connectionMap.entrySet() ){
                String user = entry.getKey();
                if (!user.equals(userName)){
                    Message message = new Message(MessageType.USER_ADDED, user);
                    connection.send(message);
                }
            }
        }

        //получение сообщения и рассылка его с помощью sendBroadcastMessage
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    Message mesageToSend = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(mesageToSend);
                }else {
                    ConsoleHelper.writeMessage("It's not a TEXT!");
                }
            }
        }

        // запуск всех методов Handler. Создание и удаление юзера
        public void run(){
            String newUser = "";
            ConsoleHelper.writeMessage("Connection done with adress " + socket.getRemoteSocketAddress());
            try(Connection connection = new Connection(socket);){
                newUser = serverHandshake(connection); //ClassNotFoundException
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUser));
                sendListOfUsers(connection, newUser);
                serverMainLoop(connection, newUser);
            }catch (IOException e){
                ConsoleHelper.writeMessage("IOException has occured in Helper.run(). Cause is " + e);

            }catch (ClassNotFoundException e){
                ConsoleHelper.writeMessage("ClassNotFoundException has occured in Helper.run(). Cause is " + e);
            }
            connectionMap.remove(newUser);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUser));
            ConsoleHelper.writeMessage("Connection closed!");

        }

    }
}
