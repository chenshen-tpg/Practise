package Preparation.General.RealQuestions.Review;

public class sizeOnDisk {
    /***
     * you may have noticed that files have two sizes
     * A disk has a cluster size of 512 bytes
     * a file ahs a size of 1500 bytes
     * 2 clusters (1024 bytes) wouldn't be enough to store this file.
     * 4 clusters (2048 bytes) would be too much, one of the cluster would be empty
     * so three clusters to hold.
     *
     */
    public static void main(String[] args) {
        int file = 1500;
        int disk = 512;
        System.out.println((file / disk) + 1);
    }
}
