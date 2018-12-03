package com.javarush.task.task32.task3207;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
К серверу по RMI
*/
public class Solution {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;


    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //final DoubleStringImpl d = new DoubleStringImpl();

            try{
                //final Registry registry = LocateRegistry.createRegistry(2099);
                final DoubleString string = (DoubleString) registry.lookup(UNIC_BINDING_NAME);
                System.out.println(string.doubleString("AAA"));
                Thread.sleep(2);




            }catch (NotBoundException e){
                System.out.println(e.getMessage());
            }catch (RemoteException e1) {
                System.out.println(e1.getMessage());
            }catch (InterruptedException ee){}
            //напишите тут ваш код
        }
    });

    public static void main(String[] args) {
        //pretend we start rmi server as main thread
        Remote stub = null;
        final DoubleStringImpl service = new DoubleStringImpl();
        try {
            registry = LocateRegistry.createRegistry(2099);

            stub = UnicastRemoteObject.exportObject(service, 0);
            registry.bind(UNIC_BINDING_NAME, stub);
            Thread.sleep(1000);
            UnicastRemoteObject.unexportObject(service , false);
        }catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }catch (InterruptedException ee){}

        //start client
        CLIENT_THREAD.start();
    }
}