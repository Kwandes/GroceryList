import java.util.ArrayList;
import java.util.Arrays;

public class GroceryList {

    //region Fields/Attributes
    private ArrayList<GroceryItemOrder> list = new ArrayList<GroceryItemOrder>();
    //private GroceryItemOrder[]  list = new GroceryItemOrder[10];
    //endregion

    //region Constructors
    public GroceryList () {}
    //endregion

    //region Methods
    public void add ( GroceryItemOrder item ) {
        if (list.size() < 10) {
            list.add (item);
        }
    }

    public void remove ( String name ) {
        int index = searchList(name);

        if ( index < 0 || index >= list.size() ) {
            System.out.println("Item not currently in the Basket.");
        }
        else {
            list.remove(index);
        }
    }

    public int searchList ( String name ) {
        for ( int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void checkBasket () {
        System.out.println("The Basket currently contains : ");
        for ( int i = 0; i < list.size(); i++ ) {
            System.out.println("\t" + (i+1) + ". " + list.get(i).toString() + ";");
        }
    }

    public int  getTotalCost () {
        int totalCost = 0;
        for ( int i = 0; i < list.size(); i ++ ) {
            totalCost += list.get(i).getPrice() * list.get(i).getQuantity();
        }
        System.out.println("Total Cost of the Grocery List : " + totalCost + "DKK.");
        return totalCost;
    }
    //endregion

    //region Setters
    public void setList(ArrayList<GroceryItemOrder> list) {
        this.list = list;
    }
    //endregion

    //region Getters
    public ArrayList<GroceryItemOrder> getList() {
        return list;
    }
    //endregion

    //region toString
    @Override
    public String toString() {
        return "The List Contains : " + list.toString();
    }
    //endregion
}
