package Preparation.Chat1;

public class Exerc3 {
    //printf() is used to format strings, numbers, etc.
    //It allows you to specify the format of the output.
    //For example, %.5f means a floating-point number with 5 digits after the decimal point.
    //The %f is a format specifier for floating-point numbers.
    //The .5 means that 5 digits should be displayed after the decimal point.
    //The printf() method does not add a newline character at the end of the output.
    //The println() method adds a newline character at the end of the output.
    public static void main(String[] args) {
        double pi = 3.1415926535;
//        System.out.printf("%.5f\n", pi);
//        System.out.printf("%.2f\n", pi);
//        sum ();
        System.out.println(9.0 / 8.0);
        sum2();
    }

    public static void sum() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
            System.out.println("Sum: " + sum);
        }
    }

    public static void sum2() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001) {
            t = (9.0 / t) / 2.0;
        }
        System.out.printf("%.5f\n", t);
    }
}
