package BasicLambda;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world! This is Lambdas!");
        Human victor = new Human();
        walk(victor);

        Robot walle = new Robot();
        walk(walle);

        // normal way
//        walk(new Walkable() {
//            @Override
//            public void walker() {
//                System.out.println("Custom object is walking");
//            }
//        });

        // lambda way

        // one line it's not needed to use {}
        //walk(() -> System.out.println("Custom object is walking"));

        // multiple lines it's needed to use {}
//        walk(() -> {
//            System.out.println("Custom object is walking");
//        });

        // is using the LambdaInter interface with just 1 method, no need to specify the method
        LambdaInter lambdaInter = () -> {
            System.out.println("Custom object is walking");
        };
        lambdaInter.test();

        // lambda expression simple using the interface LambdaInter with void method
        LambdaInter var1 = ()->{System.out.println("Hello");};

        // lambda expression using the interface Calculate with 2 parameters
        Calculate var2 = (a,b) -> a + b;
        System.out.println(var2.compute(10,5));

        Calculate var3 = (a,b) -> {
            if (a<=0) {
                return 0;
            }
            return a / b;
        };
        System.out.println(var3.compute(10,5));
        System.out.println(var3.compute(-5,5));

//        Rever cadena = (a) -> {
//                String res="";
//                for (int i = a.length()-1; i>=0; i--){
//                    res += a.charAt(i);
//                }
//                return res;
//            };
//        System.out.println(cadena.reversa("Enrique"));

        GenericInter<String> cadena = (a) -> {
            String res="";
            for (int i = a.length()-1; i>=0; i--){
                res += a.charAt(i);
            }
            return res;
        };
        System.out.println(cadena.generic("Enrique with generic"));

        Factorial fact = (a) -> {
            int res = 1;
            for (int i = 1; i<=a; i++){
                res *= i;
            }
            return res;
        };
        System.out.println(fact.fact(5));

    }

    public static void walk(Walkable walkEntity){
        walkEntity.walker();
    }

    // normal method
    public void welcome(){
        System.out.println("Hello");
    }

    // normal method with parameters
    public int sum(int x, int y){
        return x + y;
    }

    // normal method with parameters and return value with more than 1 line
    public int divZero(int x, int y){
        if (x<=0){
            return 0;
        }
        return x / y;
    }

    // return a string
    public String reverse(String cad){
        //return new StringBuilder(cad).reverse().toString();
        String res="";
        for (int i = cad.length()-1; i>=0; i--){
            res += cad.charAt(i);
        }
        return res;
    }

    // return factorial
    public int factorial(int n){
        int res = 1;
        for (int i = 1; i<=n; i++){
            res *= i;
        }
        return res;
    }

}

////////////////    INTERFACES    //////////////////////
// interface for a lambda expression with 2 parameters
interface Calculate {
    public int compute (int a, int b);
}

interface Rever {
    public String reversa(String a);
}

interface Factorial {
    public int fact(int a);
}

// interface for a lambda expression with no parameters and different types of return
interface GenericInter<T> {
    public T generic(T t);
}
