package Basic;

public class breckeltRemove {
    public static void main(String[] args) {
        String ss =  "[[1,2,4]]";
        StringBuilder sb = new StringBuilder();
        for (char s:ss.toCharArray()){
            if (s == '[') {
                sb.append('{');
            }else if (s == ']') {
                sb.append('}');
            }else {
                sb.append(s);
            }
        }
        System.out.println(sb);
    }
}
