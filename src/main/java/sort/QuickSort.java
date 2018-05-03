package sort;

import swap.SwapUtils;

public class QuickSort implements Sort{

	public int[] sort(int[] nums) {
		quickSort(nums, 0, nums.length);
		return nums;
	}
	
	public void quickSort(int[] nums, int start, int end){
		if(start>=end){
			return;
		}
		//选择pivot，尽量避免分割不平均
		//方法1：随机选取
		//方法2：三数中值分割法，选取左边/右边/中间的中值（中间的数）
		int pivot = (start+end)/2;
		int value = nums[pivot];
		SwapUtils.swap(nums, pivot, end-1);//交换到最后
		int left = start, right = end - 1;
		while(left<=right){
			if(nums[left] < value){
				left++;
			}else if(nums[right] >= value){
				right--;
			}else if(nums[left] >= value && nums[right] < value){
				SwapUtils.swap(nums, left, right);
				left++;
				right--;
			}
		}
		SwapUtils.swap(nums, left, end -1);//将值交换回来
		
		//对于小数组（N<=20），快排不如插入排序
		//所以，当节点数小于10的时候用插入排序,减少快排的递归
		if(left-start>10){
			quickSort(nums, start, left);
		}else{
			insertSortForQuickSort(nums, start, left);
		}
		if(end-left-1>10){
			quickSort(nums, left+1, end);
		}else{
			insertSortForQuickSort(nums, left+1, end);
		}
		
		
		//平均/最优情况，每次分割点分割在中间，则需要快速排序logN次，每次的排序时间是O(N),总的复杂度是O(NlogN)
		//最差情况，每次分割点都在最左或最右，则需要快速排序N次，每次的排序时间是O(N)，总的复杂度是O(N^2)
		//表现不稳定，取决与pivot的分割情况
		//空间复杂度是O(logN)，因为平均递归logN次，最差的时候要递归n次，O(n)
		//大多数情况比较合适的排序算法
		
	}
	
	public int[] insertSortForQuickSort(int[] nums,int start, int end) {
		//使前i个元素有序 
		for(int i=start+1;i<end;i++){
			int temp = nums[i];
			//将第i个元素插到合适的位置
			int j=i-1;
			while(j>=start){
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
		return nums;
	}

}
