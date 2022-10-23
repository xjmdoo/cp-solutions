class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        int current = 1;
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                res[0] = nums[i];
                continue;
            }

            set.add(nums[i]);

            if (nums[i] == current) {
                current++;
            } else {
                res[1] = current;
            }

        }

        if (res[1] == 0) res[1] = current;

        return res;
    }
}

