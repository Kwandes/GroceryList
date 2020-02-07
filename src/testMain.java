import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class testMain
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File products = new File("C:\\Users\\crist\\OneDrive\\Documents\\KEA Semester II\\Programming\\Projects\\Grocery List\\Products");
        Scanner in = new Scanner ( products );
        Random rand = new Random ();

        GroceryList shoppingList = new GroceryList();

        /*  OLD WAY
        shoppingList.add(new GroceryItemOrder("SpringOnions", 10, 3));
        shoppingList.add(new GroceryItemOrder("Carrots", 13, 5));
        shoppingList.add(new GroceryItemOrder("Tomatoes", 7, 7));
        shoppingList.add(new GroceryItemOrder("Potatoes", 5, 21));
        shoppingList.add(new GroceryItemOrder("Lettuce", 21, 2));
        */
        while ( in.hasNext() ) {
            boolean buy = rand.nextBoolean();
            String itemName = in.next();
            if ( buy ) {
                shoppingList.add(new GroceryItemOrder(itemName, rand.nextInt(299)+100, rand.nextInt(9)+1));
            }
        }

        System.out.println(shoppingList.toString());

        shoppingList.getTotalCost();
    }
}
