package CodingQuestions.Algorithms.Array.ArrayGeneral.ThreeConsecutive_1550;

public class Sample {
    public static void main(String[] args) {

    }
    public boolean threeConsecutiveOdds(int[] arr) {
        boolean isTrue=false;
        for(int i=0;i<arr.length-2;i++)

        {
            int f=arr[i];
            int s=arr[i+1];
            int t=arr[i+2];
            if(f%2==1 &&s%2==1 && t%2==1)
            {
                isTrue=true;
            }
        }
        return isTrue;
    }
}
