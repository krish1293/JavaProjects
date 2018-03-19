public class ThreeStringComparisons {
    public static void main(String[] args) {
        
        //1, using explicit new operator,
        //you get two separate String objects
        String s1a = new String("Hello");
        String s1b = new String("Hello");
        if (s1a == s1b) {
            System.out.println("1. same object");
        } else {
            System.out.println("1. different objects");
        }
            
        //2, using "special support for Strings in Java"
        //you get one String object
        String s2a = "wonderful";
        String s2b = "wonderful";
        if (s2a == s2b)
            System.out.println("2. same object");
        else
            System.out.println("2. different objects");

        //3, two String literals with the same text
        //in the same scope, you get one String object
        if ("x" == "x") 
            System.out.println("3. \"x\"==\"x\" is true");
    }
}
/*
1. different objects
2. same object
3. "x"=="x" is true
*/
