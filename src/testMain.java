import java.util.Scanner;

public class testMain
{
    public static void main(String[] args) throws InterruptedException
    {
        try
        {
            Musik music = new Musik("musik");
            music.play();
        } catch (Exception e) {System.out.println(e);}

        GroceryList shoppingList = new GroceryList();

        for(int i = 0; i < 10; i++)
        {
            shoppingList.add(new GroceryItemOrder("SpringOnions", 10, 1));
        }

        System.out.println(shoppingList.getTotalCost());

        Scanner console = new Scanner(System.in);

        console.nextLine();
    }
}
