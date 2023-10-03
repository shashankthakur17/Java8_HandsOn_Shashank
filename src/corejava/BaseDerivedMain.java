package corejava;

public class BaseDerivedMain {

    public static void main(String[] args) {

        DerivedClass baseRef = new DerivedClass();

        System.out.println("value of a = " + baseRef.a);
        System.out.println("value of a = " + baseRef.a);
        System.out.println("\n");

        System.out.println("Value of A = " + baseRef.getA());
        System.out.println("Value of A = " + ((BaseClass)baseRef).getA());
        System.out.println("\n");

        baseRef.showBase();
        baseRef.newMethod();
        baseRef.showDerived();

    }

}