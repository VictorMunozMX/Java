package MethodApp;

public class Methods {
    public static void main(String[] args) {
        System.out.println("MethodApp.Methods");
        MyUtils.printSomething("Victor");
        System.out.println(MyUtils.printSomething("Victor"));
        MyUtils.printSomething(10);
        MyUtils.sum2num(10,15);

        int var = MyUtils.addten(100) * 5;
        System.out.println(var);
    }

}
