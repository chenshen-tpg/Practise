package LC_Questions.CollectionAll.TwoPointers.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSUM_18 {
    public static void main(String[] args) {
        FourSUM_18 fs = new FourSUM_18();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fs.fourSum1(nums, 0));
    }

    private List<List<Integer>> fourSum(int[] nums, int i) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int j = 0; j < nums.length - 3; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) continue;
            for (int k = j + 1; k < nums.length - 2; k++) {
                if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                int l = k + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[j] + nums[k] + nums[l] + nums[r];
                    if (sum == i) {
                        res.add(Arrays.asList(nums[j], nums[k], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum < i) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
    private List<List<Integer>> fourSum1(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int j = 0; j < nums.length - 3; j++) {
                if (j > 0 && nums[j] == nums[j - 1]) continue;
                for (int k = j + 1; k < nums.length - 2; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    int l = k + 1, r = nums.length - 1;
                    while (l < r) {
                        int sum = nums[j] + nums[k] + nums[l] + nums[r];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[j], nums[k], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) l++;
                            while (l < r && nums[r] == nums[r - 1]) r--;
                            l++;
                            r--;
                        } else if (sum < target) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
            return res;

    }
}
