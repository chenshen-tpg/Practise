package CodingQuestions.Stack.StackGeneral.LC150.SimplifyPath;

import java.util.ArrayDeque;

public class Deque {
    public static void main(String[] args) {
        Deque sp = new Deque();
        String path = "/.../a/../b/c/../d/./";
        System.out.println(sp.simplifyPath(path));
    }
    public String simplifyPath(String path) {
        ArrayDeque<String> dirOrFiles = new ArrayDeque<>();
        for (String dirOrFile : path.split("/")) {
            if (!dirOrFiles.isEmpty() && dirOrFile.equals("..")) {
                dirOrFiles.removeLast();
            } else if (!dirOrFile.equals(".") && !dirOrFile.equals("") && !dirOrFile.equals("..")) {
                dirOrFiles.addLast(dirOrFile);
            }
        }
        StringBuilder simplified_path = new StringBuilder();
        for (String dirOrFile : dirOrFiles) {
            simplified_path.append("/").append(dirOrFile);
        }
        return simplified_path.length() == 0 ? "/" : simplified_path.toString();
    }
}
