package com.javarush.task.task30.task3008.client;

/**
 * Created by DIMA on 10.11.2017.
 */
public class ClientGuiController extends Client {

    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

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
        return view.getServerAddress();
        //return super.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
        //return super.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
        //return super.getUserName();
    }

    public ClientGuiModel getModel() {
        return model;
    }

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

    public class GuiSocketThread extends SocketThread{
        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
            super.processIncomingMessage(message);
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
            super.informAboutAddingNewUser(userName);
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
            super.informAboutDeletingNewUser(userName);
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
            super.notifyConnectionStatusChanged(clientConnected);
        }
    }

}
