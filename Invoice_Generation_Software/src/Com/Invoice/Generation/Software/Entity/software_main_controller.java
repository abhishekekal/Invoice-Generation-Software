package Com.Invoice.Generation.Software.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Com.Invoice.Generation.Software.Controller.Invoice;
import Com.Invoice.Generation.Software.Controller.Product;
import Com.Invoice.Generation.Software.Controller.Tax;
import Com.Invoice.Generation.Software.Controller.TaxGroup;

public class software_main_controller {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
    Map<String, Tax> taxMap = new HashMap<>();
    
   
    Tax t1=new Tax("VAT", 5.0);
    Tax t2=  new Tax("SGST", 9.0);
    Tax t3=new Tax("CGST", 9.0);
    // add taxes
    taxMap.put("VAT", t1);
    taxMap.put("SGST", t2);
    taxMap.put("CGST", t3);
    
    // Creating tax groups
    TaxGroup noTaxGroup = new TaxGroup("No Tax");
    TaxGroup petrolTaxGroup = new TaxGroup("Petrol Tax");
   
    petrolTaxGroup.addTax(taxMap.get("VAT"));
    TaxGroup soapTaxGroup = new TaxGroup("Soap Tax");
    soapTaxGroup.addTax(taxMap.get("SGST"));
    soapTaxGroup.addTax(taxMap.get("CGST"));
    List<Product> products = new ArrayList<>();
    products.add(new Product("Rice", 5.0,noTaxGroup));
    products.add(new Product("Petrol", 65.0, petrolTaxGroup));
    products.add(new Product("Soap", 15.0, soapTaxGroup));
    // Creating invoice
    Invoice invoice = new Invoice();
   System.out.println("(type 'exit' to finish)");
    System.out.print("Enter the product names to add to the invoice :- ");
    while (true) {
        String productName = scanner.nextLine();
        if (productName.equalsIgnoreCase("exit")) {
            break;
        }
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                invoice.addProduct(product);
                System.out.println(productName + " added to the invoice.");
                System.out.print("Enter the product names to add to the invoice :- ");
            }
        }
    }
    // Generating the invoice
    invoice.generateInvoice();

	
}
}
