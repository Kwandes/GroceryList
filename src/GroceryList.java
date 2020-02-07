import java.util.ArrayList;
import java.util.Arrays;

public class GroceryList {

    // Fields
    private ArrayList<GroceryItemOrder> list = new ArrayList<GroceryItemOrder>();
    //private GroceryItemOrder[]  list = new GroceryItemOrder[10];

    public GroceryList () {}

    public void add ( GroceryItemOrder item ) {
        if (list.size() < 10) {
            list.add (item);
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

    public void setList(ArrayList<GroceryItemOrder> list) {
        this.list = list;
    }

    public ArrayList<GroceryItemOrder> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Grocery Item Order : " + list.toString();
    }
}
