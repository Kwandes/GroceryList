import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;


public class testMain
{
    private static void fooBar(boolean doItOrNot)
    {        try
            {
                Musik music = new Musik("musik");
                if (doItOrNot) music.play();
            } catch (Exception e) {System.out.println(e);}
    }

    public static void main(String[] args)
    {
        //region Important Bits

        // Env variables
        GroceryList shoppingList = new GroceryList();
        Wallet wallet = new Wallet(420, "Rupie");
        Products products = new Products();
        UserInterface ui = new UserInterface(shoppingList, wallet, products);

        // Not very important thing, set to False if you are around people
        fooBar(false);

        ui.display();

        //endregion

        //region Old, Primitive Way
        /*  OLD WAY
        shoppingList.add(new GroceryItemOrder("SpringOnions", 10, 3));
        shoppingList.add(new GroceryItemOrder("Carrots", 13, 5));
        shoppingList.add(new GroceryItemOrder("Tomatoes", 7, 7));
        shoppingList.add(new GroceryItemOrder("Potatoes", 5, 21));
        shoppingList.add(new GroceryItemOrder("Lettuce", 21, 2));
        */
        /*while ( in.hasNext() ) {
            boolean buy = rand.nextBoolean();
            String itemName = in.nextLine();
            if ( buy ) {
                shoppingList.add(new GroceryItemOrder(itemName, rand.nextInt(299)+100, rand.nextInt(9)+1));
            }
        }*/

        //shoppingList.checkBasket();

        //shoppingList.getTotalCost();

        //String itemName = input.nextLine();
        //shoppingList.remove(itemName);

        //shoppingList.checkBasket();
        //endregion
    }
}
