package Customer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.TimeUnit;

public class StartCustomer {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Customer customer = new Customer();
        try {
            while (true)
            {
                customer.getBurger();
                TimeUnit.SECONDS.sleep(customer.randomSleep(1, 9));
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
