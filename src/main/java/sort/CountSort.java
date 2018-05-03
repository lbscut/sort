package sort;

/**
 * 计数排序
 * @author lb
 *
 */
public class CountSort implements Sort {

	//只能排一定范围的数，此处是0~1023
	public int[] sort(int[] nums) {
		int[] times = new int[1024];
		for(int i=0;i<nums.length;i++){
			times[nums[i]]++;
		}
		int current = 0;
		for(int i=0;i<times.length;i++){
			while(times[i]>0){
				nums[current++]=i;
				times[i]--;
			}
		}
		return nums;
		//此排序限制较多，必须为正数，且需要知道数的范围
		//需要额外的空间，额外的空间为O(max)
		//时间复杂度为O(max)
	}

}
