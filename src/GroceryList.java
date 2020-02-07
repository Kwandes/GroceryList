import java.util.Arrays;

public class GroceryList {

    private GroceryItemOrder[]  list = new GroceryItemOrder[10];
    private int counter;

    public GroceryList () {
        this.counter = 0;
    }

    public void add ( GroceryItemOrder item ) {
        if (counter < 10) {
            list[counter++] = item;
        }
    }

    public int  getTotalCost () {
        int totalCost = 0;
        for ( int i = 0; i < counter; i ++ ) {
            totalCost += list[i].getPrice() * list[i].getQuantity();
        }
        System.out.println("Total Cost of the Grocery List : " + totalCost + "DKK.");
        return totalCost;
    }

    public void setList(GroceryItemOrder[] list) {
        this.list = list;
    }

    public GroceryItemOrder[] getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Grocery Item Order : " + Arrays.toString(list);
    }
}
