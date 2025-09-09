package CodingQuestions.Algorithms.OOP.DesignCompressedStringIterator_604;

import java.util.ArrayList;
import java.util.List;

public class OOP {
    int index = 0;
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        OOP stringIterator = new OOP();
        List<Object> results = new ArrayList<>();

        // Input operations
        String[] operations = {"StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"};
        Object[][] inputs = {{"L10e2t1C1o1d1e11"}, {}, {}, {}, {}, {}, {}, {}, {}, {}};

        // Execute operations
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "StringIterator":
                    stringIterator.StringIterator((String) inputs[i][0]);
                    results.add(null); // No return value for constructor
                    break;
                case "next":
                    results.add(stringIterator.next());
                    break;
                case "hasNext":
                    results.add(stringIterator.hasNext());
                    break;
            }
        }
        System.out.println(results);
    }
    public void StringIterator(String str) {
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (Character.isDigit(currentChar)) {
                continue;
            }
            int count = 1;
            StringBuilder numStrBuilder = new StringBuilder();
            int j = i + 1;
            while (j < str.length() && Character.isDigit(str.charAt(j))) {
                numStrBuilder.append(str.charAt(j));
                j++;
            }
            if (numStrBuilder.length() > 0) {
                count = Integer.parseInt(numStrBuilder.toString());
                i = j - 1;
            }
            for (int k = 0; k < count; k++) {
                sb.append(currentChar);
            }
        }
    }

    public char next() {
        index++;
        return sb.charAt(index);
    }

    public boolean hasNext() {
        return index > sb.length() - 1;
    }
}
