import org.w3c.dom.ls.LSOutput;

import javax.sql.rowset.FilteredRowSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Products
{
    private File productsFile;
    private Scanner productsScanner;
    private ArrayList<GroceryItemOrder> productsList;

    // Constructor and main work horse
    public Products()
    {
        try
        {
            this.productsFile = new File("./files/products.txt");
            this.productsScanner = new Scanner(this.productsFile);
        } catch (FileNotFoundException e ) {
            System.out.println("!!!Error - " + e);
        } catch (Exception e){
            System.out.println("!!!Error - " + e);
        }

        this.productsList = new ArrayList<GroceryItemOrder>();
        String line;

        try
        {
            while (this.productsScanner.hasNextLine())
            {
                try
                {
                    line = this.productsScanner.nextLine();
                    this.productsList.add(new GroceryItemOrder(line.split(",")[0], Integer.parseInt(line.split(",")[1].strip()), 1));
                } catch (Exception e)
                {
                    System.out.println("!!!Error - " + e);
                }
            }
        } catch (Exception e)
        {
            System.out.println("!!!Error - " + e);
        }
    }

    public String toString()
    {
        String productsString = "";
        for(int i = 0; i < productsList.size(); i++)
        {
            productsString += "Item: " + productsList.get(i).getName() + ", Price: " + productsList.get(i).getPrice() + "\n";
        }

        return productsString;
    }
}
