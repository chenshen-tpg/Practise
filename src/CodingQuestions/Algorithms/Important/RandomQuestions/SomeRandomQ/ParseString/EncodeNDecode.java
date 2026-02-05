package CodingQuestions.Algorithms.Important.RandomQuestions.SomeRandomQ.ParseString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncodeNDecode {


    public static void main(String[] args) {
        EncodeNDecode codec = new EncodeNDecode();

        List<List<String>> testCases = Arrays.asList(
                Arrays.asList("Hello", "World", "Test"),
                Arrays.asList("", "abc", ""),
                Arrays.asList("123#456", "foo#bar"),
                Arrays.asList("a", "b", "c"),
                Collections.singletonList(""),
                Arrays.asList("Special chars: !@#$%^&*()", "New\nLine", "Tab\tChar"),
                Collections.singletonList(""),
                Collections.singletonList("comma,separated,values")
        );

        for (List<String> test : testCases) {
            String encoded = codec.encode(test);
            List<String> decoded = codec.decode(encoded);
            System.out.println("Original: " + test);
            System.out.println("Encoded: " + encoded);
            System.out.println("Decoded: " + decoded);
            System.out.println("Match: " + test.equals(decoded));
            System.out.println("-----");
        }
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            String str = s.substring(j + 1, j + length + 1);
            result.add(str);
            i = j + length + 1;
        }
        return result;
    }

    public String encodeV2(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decodeV2(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            i = j + 1;
            j = length + i;
            res.add(s.substring(i, j));
            i = j;
        }

        return res;
    }

}
