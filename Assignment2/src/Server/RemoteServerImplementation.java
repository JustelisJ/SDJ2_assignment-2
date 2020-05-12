package Server;

import Server.utility.BlockingQueue;
import Server.utility.BlockingQueueInterface;
import model.Burger;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServerImplementation implements RemoteServer{

    private BlockingQueueInterface burgers;

    public RemoteServerImplementation() throws RemoteException {
        burgers = new BlockingQueue();
        UnicastRemoteObject.exportObject(this, 1099);
    }

    @Override
    public void madeABurger(Burger burger) throws RemoteException {
        burgers.enqueue(burger);
        System.out.println("Burger added to the queue: " + burger + ". Queue size: " + burgers.size());
    }

    @Override
    public Burger getBurger() throws RemoteException{
        System.out.println("Burger removed from the queue. Queue size: " + (burgers.size() - 1));
        return (Burger) burgers.dequeue();
    }

}
