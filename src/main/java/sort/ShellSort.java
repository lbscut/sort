package sort;

public class ShellSort implements Sort {

	public int[] sort(int[] nums) {
		//间隔逐渐缩小至1
		int interval = nums.length/2;
		while(interval >= 1){
			for(int i=0;i<interval;i++){
				//每次以插入排序使其局部有序
				insertSortForShell(nums, i, interval);
			}
			interval /= 2;
		}
		//最终区间为1，插入排序使所有有序
		
		//空间复杂度为O(1)
		//最坏情况时间复杂度为O(n^2),当数列形如1,9,2,10....8,16,前面若干趟并未影响数组，最后一趟排序需要N^2的时间复杂度
		//interval = N/2;interval=interval/2;这是一个流行但并不好的做法
		//使用hibbard增量,interval=2^i-1，最坏时间复杂度为N^(3/2)
		//表现不稳定，取决于interval的取值
		return nums;
	}
	
	public void insertSortForShell(int[] nums,int start, int interval){
		for(int i=start+interval;i<nums.length;i+=interval){
			int temp = nums[i];
			int j=i-interval;
			while(j>=0){
				//寻找第一个比i小的坐标j，则i应该在j+interval处
				if(temp>=nums[j]){
					break;
				}else{
					//该元素不符合，后移一个
					nums[j+interval] = nums[j]; 
				}
				j-=interval;
			}
			nums[j+interval] = temp;
		}
	}
	
}
