import java.util.ArrayList;

public class GroceryList {
    ArrayList<ItemOrder> list = new ArrayList<ItemOrder>();

    public void addItemOrder(ItemOrder itemOrder){
        list.add(itemOrder);
    }
    public void printList(){
        System.out.println("the List contains:");
        for (int i = 0; i < list.size(); i++ ){
            System.out.println(list.get(i));
        }
    }
}
