package Customer;

import Server.RemoteServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;

public class Customer
{
    private RemoteServer rml;

    public Customer() throws RemoteException, NotBoundException, MalformedURLException {
        rml = (RemoteServer) Naming.lookup("rmi://localhost:1099/burger");
    }

    public void getBurger() throws RemoteException {
        System.out.println("Burger got: " + rml.getBurger());
    }

    public int randomSleep(int min, int max) {
        Random random = new Random();
        int randomId = random.nextInt(max) + min;
        return randomId;
    }
}