package CodingQuestions.Stack.StackGeneral.Others.RemoveAllOccurrencesofaSubstring_1910;


import java.util.Stack;

public class TwoStackReverse {
    public static void main(String[] args) {
        TwoStackReverse solution = new TwoStackReverse();
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(solution.removeOccurrences(s, part));
    }

    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < s.length(); index++) {
            stack.push(s.charAt(index));
            if (stack.size() >= part.length() && checkMatch(stack, part)) {
                for (int j = 0; j < part.length(); j++) stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.pop());
        res.reverse();
        return res.toString();
    }

    private boolean checkMatch(Stack<Character> stk, String part) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stk);
        for (int partIndex = part.length() - 1; partIndex >= 0; partIndex--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(partIndex)) return false;
            temp.pop();
        }
        return true;
    }
}
