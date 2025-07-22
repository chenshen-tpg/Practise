<<<<<<<< HEAD:src/CodingQuestions/Random/Func.java
package CodingQuestions.Random;
========
package RandomTesting;
>>>>>>>> origin/master:src/RandomTesting/Func.java

public class Func {
    public static void main(String[] args) {
        ProductDigit(90);
    }

    public static int ProductDigit(int num) {
        int res = 0;
        while (num > 0) {
            num /= 9;
            res++;
        }
        return res;
    }
}
