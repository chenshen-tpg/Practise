package CodingQuestions.Algorithms.Array.BinarySearch;

/***
 *
 * not sure why we could skip this problem
 *
 * original pivot
 * i,j pivot
 * while(i<=j){
 *     int mid = i + (j-i)/2;
 *     if(pivot == target) return true;
 *     else if(pivot < target) i = mid+1;
 *     else j = mid-1;
 * }
 */

public class Searcha2DMatrix_74 {


    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = row*col-1;
        while (i<=j) {
            int mid = i + (j-i)/2;
            int pivot = matrix[mid/col][mid%col];
            if (pivot == target) return true;
            else if (pivot < target) i = mid+1;
            else j = mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;  //start from last row and first column
        int col = 0;
        while(col<matrix[0].length && row>=0) {
            if(matrix[row][col]> target) row--;
            else if(matrix[row][col]<target) col++;
            else return true;
        }
        return false;
    }
}
