package CodingQuestions.Algorithms.Stack.ExclusiveTime_636;

import CodingQuestions.Lib.Pair;

import java.util.List;
import java.util.Stack;

public class TEST {
    public static void main(String[] args) {

    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] res = new int [n];
        Stack<Pair<Integer,Integer>> stack = new Stack();
        int index = 0;
        for (String log : logs) {
            String [] temp = log.split(":");
            if ("start".equals(temp[1])) stack.add(new Pair<Integer, Integer>(Integer.parseInt(temp[0]),Integer.parseInt(temp[2])));
            else if ("end".equals(temp[1])) {
                Pair<Integer, Integer> current = stack.pop();
                res[index++] = (Integer.parseInt(temp[2]) + current.getValue());
            }
            if (!stack.isEmpty() && Integer.parseInt(temp[0]) != stack.peek().getKey()){
                Pair<Integer, Integer> current = stack.pop();
                stack.push( new Pair<Integer, Integer>(current.getValue(), current.getValue() + Integer.parseInt(temp[2])));
            }
        }
        return res;
    }
}
