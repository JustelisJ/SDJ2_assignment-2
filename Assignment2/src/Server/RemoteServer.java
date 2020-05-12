package Server;

import model.Burger;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {

    public void madeABurger(Burger burger) throws RemoteException;  //uploads a burger to server from producer

    public Burger getBurger() throws RemoteException; //Sends a burger to the consumer

}
