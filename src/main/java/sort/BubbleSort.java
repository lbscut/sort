package sort;

import swap.SwapUtils;

public class BubbleSort implements Sort {

	public int[] sort(int[] nums){
		if(nums == null){
			return null;
		}
		
		//nums的长度为n
		//需要遍历n-1次，每次遍历把最大的值沉到最底下
		for(int i=0;i<nums.length-1;i++){
			//优化：如果一次遍历过程中，未有任何交换，则证明是正序，无需再比较
			boolean flag = true;
			for(int j=1;j<nums.length-i;j++){
				//相邻的值比较，比到已经有序的位置则不再进行比较
				if(nums[j-1]>nums[j]){
					//如果顺序不符合，则交换元素
					SwapUtils.swap(nums, j-1, j);
					flag = false;
				}
			}
			if(flag){
				break;
			}
		}
		//最坏需要进行(n-1)+(n-2)+...+1=n(n-1)/2次比较和交换，平均需要n(n-1)/4，时间复杂度是O(n^2)
		//经过优化后，冒泡排序的最优情况时间复杂度为O(n),此时数组为正序。
		//空间复杂度为O(1)
		return nums;
	}
	
}
