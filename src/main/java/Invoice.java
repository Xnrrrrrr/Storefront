public class Invoice {
    private Customer customer;
    private double total;

    public Invoice(Customer customer, double total) {
        this.customer = customer;
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }
}
