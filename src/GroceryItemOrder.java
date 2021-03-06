public class GroceryItemOrder {

    private String name;
    private int price;
    private int quantity;

    public GroceryItemOrder(String name, int price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return  "Name : " + name + ", Price : " + price + ", Quantity : " + quantity + ", Price : " + price*quantity;
    }
}
