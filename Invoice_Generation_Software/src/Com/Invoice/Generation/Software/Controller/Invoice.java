package Com.Invoice.Generation.Software.Controller;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	private List<Product> products;
    public Invoice() {
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void generateInvoice() {
        System.out.println("-----------------------------");
       
        System.out.print("Product"+"         "+ "Price"+"       "+"Tax");
        System.out.println();
        System.out.println("-----------------------------");
        double totalPrice = 0;
        double totalTax = 0;
        double finalres=0;
        for (Product product : products) {
            double price = product.getPrice();
            double tax = product.getTaxGroup().calculateTotalTax(price);
            
          
            System.out.print(product.getName()+"          "+price+"          "+tax);
            System.out.println();
            
            totalPrice = totalPrice+ price;
            totalTax = totalTax+ tax;
        }
      
        System.out.println();
        System.out.print("Total"+"          "+ totalPrice+"          "+totalTax);
        System.out.println();
        finalres = totalPrice+totalTax;
        System.out.print("Grand Total: "+finalres);
        System.out.println();
        System.out.println("-----------------------------");
    }
}
