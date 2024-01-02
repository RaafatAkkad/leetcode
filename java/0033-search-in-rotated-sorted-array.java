class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while(l<=r){

            // mid is calculated this way to prevent integer overflow.
            // See: https://blog.research.google/2006/06/extra-extra-read-all-about-it-nearly.html
            int mid = l + (r - l) / 2;

            if(nums[mid] == target){
                return mid;
            }
            //left sorted
            if(nums[l]<=nums[mid]){
                if(target > nums[mid] || target < nums[l]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{//right sorted
                if(target < nums[mid] || target > nums [r]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }

        }

        return -1;
    }
}
