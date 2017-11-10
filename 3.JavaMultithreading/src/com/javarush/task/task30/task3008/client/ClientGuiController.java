package com.javarush.task.task30.task3008.client;

/**
 * Created by DIMA on 10.11.2017.
 */
public class ClientGuiController extends Client {
    private ClientGuiModel clientGuiModel = new ClientGuiModel();
    private ClientGuiView clientGuiView = new ClientGuiView(this);

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
        //return super.getSocketThread();
    }

    @Override
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
        //super.run();
    }

    @Override
    protected String getServerAddress() {
        return clientGuiView.getServerAddress();
        //return super.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return clientGuiView.getServerPort();
        //return super.getServerPort();
    }

    @Override
    protected String getUserName() {
        return clientGuiView.getUserName();
        //return super.getUserName();
    }

    public ClientGuiModel getModel() {
        return clientGuiModel;
    }

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

    public class GuiSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) {
            clientGuiModel.setNewMessage(message);
            clientGuiView.refreshMessages();
            //super.processIncomingMessage(message);
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            clientGuiModel.addUser(userName);
            clientGuiView.refreshUsers();
            //super.informAboutAddingNewUser(userName);
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            clientGuiModel.deleteUser(userName);
            clientGuiView.refreshUsers();
            //super.informAboutDeletingNewUser(userName);
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            clientGuiView.notifyConnectionStatusChanged(clientConnected);
            //super.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
