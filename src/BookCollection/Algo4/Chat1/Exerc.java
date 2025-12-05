package BookCollection.Algo4.Chat1;

import java.util.Scanner;

public class Exerc {
    /***
     In Java, a floating-point literal like 4.0 is considered a double by default, not a float.
     To explicitly declare a floating-point literal as a float, you must append an f or F to the number. For example, 4.0f or 4.0F would be interpreted as a float.
     This is because double offers higher precision and a wider range of values than float, and Java prioritizes this higher precision for decimal literals unless explicitly instructed otherwise.
     */
    public static void main(String[] args) {
        System.out.println((15) / 2);
        System.out.println(true);
        System.out.println("----------------------------");
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0D);
        System.out.println(1 + 2 + 3 + 4.0F);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + 3);

    }

}
