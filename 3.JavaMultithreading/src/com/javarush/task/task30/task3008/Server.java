package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by DIMA on 03.11.2017.
 */
public class Server {
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

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }


    }
}
