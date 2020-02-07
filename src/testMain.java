public class testMain
{
    public static void main(String[] args)
    {
        shoppingList = new GroceryList();

        for(int i = 0; i < 10; i++)
        {
            shoppingList.add(new GroceryItemOrder("SpringOnions", 10));
        }

        System.out.println(shoppingList.getTotalCost());

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
