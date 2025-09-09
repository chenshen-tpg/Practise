package CodingQuestions.Algorithms.OOP.DesignANumberContainerSystem_2349;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class test {
    public static void main(String[] args) {
        test numberContainers = new test();
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
        System.out.println(numberContainers.find(20));
        System.out.println(numberContainers.find(30));
    }


    private Map<Integer, TreeSet<Integer>> numberToIndices = new HashMap<>();
    private Map<Integer, Integer> indexToNumbers  = new HashMap<>();

    // Constructor
    public test() {
    }

    public void change(int index, int number) {
        if (indexToNumbers.containsKey(index)) {
            int previousNumber = indexToNumbers.get(index);
            numberToIndices.get(previousNumber).remove(index);
            if (numberToIndices.get(previousNumber).isEmpty()) {
                numberToIndices.remove(previousNumber);
            }
        }
        indexToNumbers.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        if (numberToIndices.containsKey(number)) {
            return numberToIndices.get(number).first();
        }
        return -1;
    }
}


