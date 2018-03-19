public class Customer {

    private String name;
    private double creditLimit;

    public Customer() {
        super();
    }
    public Customer(String name, double creditLimit) {
        super();
        setName (name);
        setCreditLimit (creditLimit);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
