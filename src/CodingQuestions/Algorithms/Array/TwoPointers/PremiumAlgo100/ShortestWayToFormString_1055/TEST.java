package CodingQuestions.Algorithms.Array.TwoPointers.PremiumAlgo100.ShortestWayToFormString_1055;

public class TEST {
    public static void main(String[] args) {
        shortestWay("xyz", "xzyxz");
    }

    public static int shortestWay(String source, String target) {
        int index = 0, res = 0;
        while (index < target.length()) {
            int temp = index;
            for (int i = 0; i < source.length();  i++) {
                if (index < target.length() && source.charAt(i) == target.charAt(index)) index++;
            }
            if (index == temp) return -1;
            res++;
        }
        return res;
    }
}
