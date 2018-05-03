package sort;

public class MergeSort implements Sort {

	public int[] sort(int[] nums) {
		mergeSort(nums, 0, nums.length);
		return nums;
	}
	
	public void mergeSort(int[] nums, int start, int end){
		if(start+1==end){
			return;
		}
		int mid = (start+end)/2;
		mergeSort(nums, start, mid);
		mergeSort(nums, mid, end);
		merge(nums, start, mid, end);
		//需要递归logn次，每次的合并花费n，所以平均时间复杂度是O(nlogn)，最差的时候，同样要递归logn次和合并比较n次，时间复杂度一样
		//空间复杂度，需要一个额外的n大小的数组，递归用到logn的栈空间，所以空间复杂度是O(n)
	}
	
	public void merge(int[] nums, int start, int mid, int end){
		int[] result = new int[end-start];
		int i=start,j=mid;
		int current = 0;
		while(i<mid || j<end){
			if(j>=end ||( i<mid && nums[i]<nums[j])){
				result[current] = nums[i];
				i++;
			}else{
				result[current] = nums[j];
				j++;
			}
			current++;
		}
		//拷贝回原数组
		while(--current>=0){
			nums[--end]=result[current];
		}
	}

}
