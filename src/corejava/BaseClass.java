package corejava;

public class BaseClass {

    public int a = 5 ;

    public int getA(){

        System.out.println("BaseClass getA()");
        return this.a;
    }

    public void showBase(){
        System.out.println("In ShowBase methode of base class.");
    }

}