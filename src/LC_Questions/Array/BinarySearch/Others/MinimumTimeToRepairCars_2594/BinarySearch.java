package LC_Questions.Array.BinarySearch.Others.MinimumTimeToRepairCars_2594;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        solution.helper(new int [] {4,2,3,1},10);
    }
    public long helper(int [] ranks, int cars) {
        int minRank = ranks[0], maxRank = ranks[0];
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
            maxRank = Math.max(maxRank, rank);
        }
        // each rank matches one in freq Map
        int[] freq = new int[maxRank + 1];
        for (int rank : ranks) freq[rank]++;
        long low = 1, high = 1L * minRank * cars * cars;
        while (low < high) {
            long mid = (low + high) / 2;
            long carsRepaired = 0;
            for (int rank = 1; rank <= maxRank; rank++) carsRepaired += freq[rank] * (long) Math.sqrt(mid / (long) rank);
            if (carsRepaired >= cars) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
