public class testMain
{
    public static void main(String[] args)
    {
        shoppingList = new GroceryList();

        for(int i = 0; i < 10; i++)
        {
            shoppingList.add(new GroceryItemOrder("SpringOnions", 10));
        }

        shoppingList.printTotalPrice();
    }
}
