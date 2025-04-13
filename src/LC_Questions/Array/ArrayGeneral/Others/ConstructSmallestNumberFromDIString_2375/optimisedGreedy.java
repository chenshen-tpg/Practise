package LC_Questions.Array.ArrayGeneral.Others.ConstructSmallestNumberFromDIString_2375;

public class optimisedGreedy {
    public static void main(String[] args) {
        String pattern = "IIIDIDDDI";
        optimisedGreedy solution = new optimisedGreedy();
        solution.smallestNumber(pattern);
    }
    public String smallestNumber(String pattern) {
        int maxSoFar = 0, currMax = 0, temp;
        int[] arrD = new int[ pattern.length() + 2];
        for (int i =  pattern.length(); i >= 0; i--) {
            if (i <  pattern.length() && pattern.charAt(i) == 'D') arrD[i] = arrD[i + 1] + 1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <=  pattern.length(); i++) {
            if (i <  pattern.length() && pattern.charAt(i) == 'I') {
                maxSoFar++;
                result.append(maxSoFar);
                maxSoFar = Math.max(maxSoFar, currMax);
                currMax = 0;
            } else {
                temp = 1 + maxSoFar + arrD[i];
                result.append(temp);
                currMax = Math.max(currMax, temp);
            }
        }
        return result.toString();
    }
}
