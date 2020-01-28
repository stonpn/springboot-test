package my.test;

public class Test {

    static boolean a;


    public static void main(String[] s) {
        a = true;
        if (a) System.out.println("Hello, Java!");
        if (a == true) System.out.println("Hello, JVM!");
    }
}
