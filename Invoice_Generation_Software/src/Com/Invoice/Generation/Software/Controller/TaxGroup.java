package Com.Invoice.Generation.Software.Controller;

import java.util.ArrayList;
import java.util.List;

public class TaxGroup {
	private String groupName;
    private List<Tax> taxes;
    public TaxGroup(String groupName) {
        this.groupName = groupName;
        this.taxes = new ArrayList<>();
    }
    public void addTax(Tax tax) {
        taxes.add(tax);
    }
    public List<Tax> getTaxes() {
        return taxes;
    }
    public String getGroupName() {
        return groupName;
    }
    public double calculateTotalTax(double price) {
        double totalTax = 0;
        for (Tax tax : taxes) {
            totalTax =totalTax+ price * tax.getPercentage() / 100;
        }
        return totalTax;
    }

}
