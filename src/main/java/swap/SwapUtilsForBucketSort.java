package swap;

public class SwapUtilsForBucketSort {
	public static void swap(Integer[] nums,int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
