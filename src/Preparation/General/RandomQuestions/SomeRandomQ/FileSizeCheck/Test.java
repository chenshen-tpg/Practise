package Preparation.General.RandomQuestions.SomeRandomQ.FileSizeCheck;

public class Test {
    /*** The file size and the size on disk
     Clusters
     Size on disk corresponds to the total size of all the clusters
     A disk has a cluster size of 512 bytes.
     A file has a size of 1500 bytes.
     2 clusters wouldn't be enough to store this file.
     4 cluster would be too much, one of the cluster would be empty.
     The total size of these clusters is 1536
     ***/
    public static void main(String[] args) {
        int size = 1500;
        int ans = 0;
        if (size % 512 > 0) {
            ans = size / 512 + 1;
        }
        System.out.println(ans);
    }
}
