class Grandparent extends Object {
    private int g;
    public Grandparent (int g) {
        this.g = g;
        System.out.println("g has " + g); 
    }
}
class Parent extends Grandparent {
    private int p;
    public Parent (int g, int p) {
        super (g);
        this.p = p;
        System.out.println("p has " + p); 
    }
}
class Child extends Parent {
    private int c;
    public Child (int g, int p, int c) {
        super (g, p);
        this.c = c;
        System.out.println("c has " + c ); 
    }
}
public class CallStackOfConstructors {
    public static void main (String[] args) {
        Child c = new Child(1, 2, 3);
    }
}
