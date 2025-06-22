package LC_Questions.Array.ArrayGeneral.Others.DivdeAStringIntoGroupSizeK_2138;

public class TEST {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int size = 0, left = 0;
        if (len % k > 0) {
            size = len / k + 1;
            left = len % k;
        } else {
            size = len / k;
        }
        String [] res = new String [size];
        int index = 0, temp = 0,tempindex = 0;
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < len; i++) {
            temp++;
            tempString.append(s.charAt(i));
            if (temp >= k) {
                res[index++] = tempString.toString();
                tempString = new StringBuilder();
                temp = 0;
            }
            tempindex++;
        }
        if (left > 0) {
            while (tempindex < len) {
                tempString.append(tempindex++);
            }
            while (left < k) {
                tempString.append(fill);
                left++;
            }
            res[index++] = tempString.toString();
        }
        return res;
    }
}
