public class CustomerTest {

    public static void main(String[] args) {
    
        Customer c = null;
        c = new Customer ();
        
        c.setName("Teresa");
        c.setCreditLimit(100.00);
        
        String name = c.getName();
        double creditLimit = c.getCreditLimit();
        
        System.out.println(
            "name=" + name + 
            ", creditLimit=" + creditLimit);
    }
}
