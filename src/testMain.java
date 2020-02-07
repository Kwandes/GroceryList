import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;


public class testMain
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File products = new File("Products");
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
            String itemName = in.nextLine();
            if ( buy ) {
                shoppingList.add(new GroceryItemOrder(itemName, rand.nextInt(299)+100, rand.nextInt(9)+1));
            }
        }

        System.out.println(shoppingList.toString());

        shoppingList.getTotalCost();

        // You-can-ignore-this-bits
        try
        {
            Musik music = new Musik("musik");
            music.play();
        } catch (Exception e) {System.out.println(e);}

        Scanner console = new Scanner(System.in);
        console.nextLine();

        // Fuck you Cris read the error messages instead of randomly merging shit what are you alex 2.0?
    }
}
