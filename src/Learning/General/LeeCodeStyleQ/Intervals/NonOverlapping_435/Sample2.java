package Learning.General.LeeCodeStyleQ.Intervals.NonOverlapping_435;

import java.util.Arrays;

public class Sample2 {
    public static void main(String[] args) {

    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[1]-b[1]);
        int ans=0;
        int last=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<last){
                ans++;
            }
            else{
                last=intervals[i][1];
            }
        }
        return ans;
    }
}
