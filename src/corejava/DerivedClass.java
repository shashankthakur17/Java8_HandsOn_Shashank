package corejava;

public class DerivedClass extends BaseClass {

    public int a = 10 ;

    public int getA(){

        System.out.println("DerivedClass getA()");
        return this.a;
    }

    public void showDerived(){
        System.out.println("In ShowDerived methode of Derived class.");
    }

    public void newMethod(){
        System.out.println("Derived specific method");
    }

}
