package Producer.producer;

import Producer.mediator.RecipeCacheProxy;
import Producer.mediator.RecipeProvider;
import Server.RemoteServer;
import model.Burger;
import model.Recipe;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProducerClient implements InterfaceProduceClient {

    private RemoteServer rml;
    private RecipeProvider rel;

    public ProducerClient(RecipeProvider provide) throws RemoteException, NotBoundException, MalformedURLException {
        rml = (RemoteServer) Naming.lookup("rmi://localhost:1099/burger");
        rel = provide;
    }

    public void addBurgerToBar() throws Exception {
        int id = randomIdGenerator(1, 3);
        Recipe recipe = rel.getRecipeById(String.valueOf(id));
        Burger burger = recipe.createBurger();
        rml.madeABurger(burger);
        System.out.println("Burger added to the queue: " + burger);
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        RecipeProvider re1= new RecipeCacheProxy("src/Producer/recipes.txt");
        InterfaceProduceClient client1=new ProducerClient(re1);

        try {
            while (true)
            {
                client1.addBurgerToBar();
                TimeUnit.SECONDS.sleep(randomSleep(1, 9));
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static int randomIdGenerator(int min, int max) {
        Random random = new Random();
        int randomId = random.nextInt(max) + min;
        return randomId;
    }

    private static int randomSleep(int min, int max) {
        Random random = new Random();
        int randomId = random.nextInt(max) + min;
        return randomId;
    }
}
