package LC_Questions.WholePackage.Stack.LC75.AsteriodCollision_735;

import java.util.Stack;

public class MyVersion {
    public static void main(String[] args) {
        int [] asteroidsCombine1 = {5, 10, -5};
        int [] asteroidsCombine2 = {8, -8};
        int [] asteroidsCombine3 = {10, 2, -5};
        int [] asteroidsCombine4 = {-10, 2, -5};
        int [] something = refineVersion(asteroidsCombine3);
        for (int i = 0; i < something.length; i++) {
            System.out.println(something[i] + " ");
        }
    }

    public static int [] helper (int [] arr) {
        int [] res = new int [arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                stack.add(arr[i]);
            } else if (arr[i] < 0) {
                while (!stack.isEmpty() && (stack.peek() <= Math.abs(arr[i]))  ) {
                    stack.pop();
                }
            }
        }
        int index = 0;
        while(!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }

    public static int [] refineVersion (int [] arr) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                stack.add(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && (stack.peek() < Math.abs(arr[i]))  ) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == Math.abs(arr[i])) {
                    stack.pop();
                }
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.add(arr[i]);
                }
            }
        }
        int [] ans = new int[stack.size()];
        for (int j : stack) {
            ans[count++] = j;
        }
        return ans;
    }
}
