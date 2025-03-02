package LC_Questions.Stack.Others;

import java.util.ArrayList;
import java.util.List;

public class BuildanArrayWithStackOperations_1441 {

    public static void main(String[] args) {
        int[] target = {1,3};
        int n = 3;
        BuildanArrayWithStackOperations_1441 b = new BuildanArrayWithStackOperations_1441();
        System.out.println(b.buildArray(target, n));
    }
    public List<String> buildArray(int[] target, int n) {
        List<String> li = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < n; i++){
            if (i > target.length - 1){
                break;
            }
            while (index < target[i] - 1){
                li.add("Push");
                li.add("Pop");
                index++;
            }
            li.add("Push");
            index++;
        }
        return li;
    }
}
