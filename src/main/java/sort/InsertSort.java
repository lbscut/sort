package sort;

public class InsertSort implements Sort {

	public int[] sort(int[] nums) {
		//使前i个元素有序 
		for(int i=1;i<nums.length;i++){
			int temp = nums[i];
			//将第i个元素插到合适的位置
			int j=i-1;
			while(j>=0){
				//寻找第一个比i小的坐标j，则i应该在j+1处
				if(temp>=nums[j]){
					break;
				}else{
					//该元素不符合，后移一个
					nums[j+1] = nums[j]; 
				}
				j--;
			}
			nums[j+1] = temp;
		}
		//最差需要进行1+2+...+(n-1)=n(n-1)/2次比较
		//平均需要进行(1+2+...+(n-1))/2=n(n-1)/4次比较
		//最差、平均时间复杂度是O(n^2)
		//最优的时候是正序，每次都不需要移动，只比较一次即可，则时间复杂度是O(n)
		//空间复杂度为O(1)
		//使用与较小的数组，且大部分有序
		return nums;
	}
}
