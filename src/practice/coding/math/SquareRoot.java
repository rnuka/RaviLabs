package practice.coding.math;

/**
 * Created by rnuka on 10/19/15.
 */
public class SquareRoot {

    /*static double square_root(double a, double epsilon) {

        //exception case
        if (Math.abs(a) < epsilon)
            return 0;

        double x = 1.5;

        while (true) {
            if (Math.abs(x*x - a) < epsilon)
                return x;
           // double y = a/x;
            x=a/x;
            //x = (x+y)/2;
           // x = (x+y)/2;
        }

    }*/


    public static double sqrt(double number) {
        double t;

        double squareRoot = number / 2;

        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        } while ((t - squareRoot) != 0);

        return squareRoot;
    }

    //test
    public static void main(String[] args) {
        System.out.println("start");
        //System.out.println("method1: "+square_root(5, 1e-6));
        System.out.println("method2: "+sqrt(2));
        System.out.println("end");

    }

}