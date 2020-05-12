package Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {
        try
        {
            LocateRegistry.createRegistry(1099);
            RemoteServer server = new RemoteServerImplementation();
            Naming.rebind("burger", server);
            System.out.println("Starting server...");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
