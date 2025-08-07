package CodingQuestions.Array.ArrayGeneral.ConfusingNumber_1056;

import java.util.HashMap;
import java.util.Map;

public class MapSolution {
    public static void main(String[] args) {

    }
    public boolean confusingNumber(int n) {
        Map<Character, Character> hm = new HashMap() {
            {put('0', '0');put('1', '1');put('6', '9');put('8', '8');put('9', '6');}
        };
        StringBuilder sb = new StringBuilder();
        for (char ch : String.valueOf(n).toCharArray()) {
            if (!hm.containsKey(ch)) return false;
            sb.append(hm.get(ch));
        }
        return Integer.parseInt(sb.reverse().toString()) != n;
    }
}
