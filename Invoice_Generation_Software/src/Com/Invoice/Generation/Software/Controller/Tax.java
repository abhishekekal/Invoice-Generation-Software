package Com.Invoice.Generation.Software.Controller;

public class Tax {
	private String name;
    private double percentage;
    public Tax(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }
    public String getName() {
        return name;
    }
    public double getPercentage() {
        return percentage;
    }

}
