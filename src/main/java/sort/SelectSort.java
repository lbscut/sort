package sort;

import swap.SwapUtils;

public class SelectSort implements Sort {

	public int[] sort(int[] nums) {
		//遍历n次，每次寻找应在第n位的值
		for(int i=0;i<nums.length;i++){
			int minIndex = i;
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]<nums[minIndex]){
					minIndex = j;
				}
			}
			if(i!=minIndex){
				SwapUtils.swap(nums, i, minIndex);
			}
		}
		//平均、最优、最差都需要进行(n-1)+(n-2)+...+1=n(n-1)/2次比较，时间复杂度是O(n^2),空间复杂度为O(1)
		//适用于较小的数组
		return nums;
	}

}
