public class GroceryList {

    private GroceryItemOrder[]  list = new GroceryItemOrder[10];

    public GroceryList () {}

    public add ( GroceryItemOrder item ) {
        if (list.length < 10) {
            list[list.length-1] = item;
        }
    }

}
