<<<<<<<< HEAD:src/Preparation/Specific/Altlassian/Programming/Programming/TextJustification_68/ModelAns.java
package Preparation.Specific.Altlassian.Programming.Programming.TextJustification_68;
========
package Learning.Specific.T.Programming.Programming.TextJustification_68;
>>>>>>>> origin/master:src/Learning/Specific/T/Programming/Programming/TextJustification_68/ModelAns.java

import java.util.ArrayList;
import java.util.List;

public class ModelAns {

    public static void main(String[] args) {
        ModelAns t = new ModelAns();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> ans = t.fullJustify(words, maxWidth);
        for (String s : ans) {
            System.out.println(s);
        }
    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            List<String> currentLine = getWords(i, words, maxWidth);
            i += currentLine.size();
            ans.add(createLine(currentLine, i, words, maxWidth));
        }

        return ans;
    }

    private List<String> getWords(int i, String[] words, int maxWidth) {
        List<String> currentLine = new ArrayList<>();
        int currLength = 0;

        while (i < words.length && currLength + words[i].length() <= maxWidth) {
            currentLine.add(words[i]);
            currLength += words[i].length() + 1;
            i++;
        }

        return currentLine;
    }

    private String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int baseLength = -1;
        for (String word : line) {
            baseLength += word.length() + 1;
        }

        int extraSpaces = maxWidth - baseLength;

        if (line.size() == 1 || i == words.length) {
//            return String.join(" ", line) + " ".repeat(extraSpaces);
            StringBuilder spacesBuilder = new StringBuilder();
            for (int k = 0; k < extraSpaces; k++) spacesBuilder.append(" ");
            return spacesBuilder.toString();
        }

        int wordCount = line.size() - 1;
        int spacesPerWord = extraSpaces / wordCount;
        int needsExtraSpace = extraSpaces % wordCount;
        for (int j = 0; j < needsExtraSpace; j++) line.set(j, line.get(j) + " ");


        for (int j = 0; j < wordCount; j++) {
//            line.set(j, line.get(j) + " ".repeat(spacesPerWord));
            StringBuilder spacesBuilder = new StringBuilder();
            for (int k = 0; k < spacesPerWord; k++) spacesBuilder.append(" ");
            String extraSpacesString = spacesBuilder.toString();
            line.set(j, line.get(j) + extraSpacesString);
        }

        return String.join(" ", line);
    }
}
