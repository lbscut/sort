package sort;

import swap.SwapUtils;

public class HeapSort implements Sort {

	public int[] sort(int[] nums) {
		buildHeap(nums);
		for (int i = 0; i < nums.length; i++) {
			pop(nums, nums.length-i);
		}
		return nums;
	}
	
	//构建最大堆
	//从最后一个节点开始，检查最后一个节点与其父节点是否符合，不符合则交换，交换后需要往下递归验证
//	public void buildHeap(int[] nums){
//		for(int i=nums.length-1;i>0;i--){
//			int parent = (i-1)/2;
//			//如果父节点较小，则交换
//			if(nums[parent] < nums[i]){
//				SwapUtils.swap(nums, i, parent);
//				//交换后需要继续递归检查
//				int temp = i;
//				while(2*temp+1<nums.length){
//					int max = 0;
//					if(2*temp+2<nums.length){
//						//符合则退出递归
//						if(nums[temp]>=nums[2*temp+1] && nums[temp]>=nums[2*temp+2]){
//							break;
//						}
//						max = nums[2*temp+1]>nums[2*temp+2]?2*temp+1:2*temp+2;
//					}else{
//						//符合则退出递归
//						if(nums[temp]>=nums[2*temp+1]){
//							break;
//						}
//						max = 2*temp+1;
//					}
//					SwapUtils.swap(nums, temp, max);
//					temp = max;
//				}
//			}
//		}
//	}
	
	//由于叶子节点形成的树一定是堆，所以从最后一个非叶子节点开始，以该节点为根节点，使该树为堆，则需要使节点下沉校验。
	public void buildHeap(int[] nums){
		for(int i=nums.length/2-1;i>=0;i--){
			adjustHeap(nums, i, nums.length);
		}
	}

	public int pop(int[] nums,int n){
		int value = nums[0];
		SwapUtils.swap(nums, 0, n-1);
		adjustHeap(nums,0,n-1);
		return value;
	}
	
	public void adjustHeap(int[] nums,int target, int n){
		int i=target;
		while(2*i+1<n){
			int max=0;
			if(2*i+2<n){
				//符合则退出递归
				if(nums[i] >= nums[2*i+1] && nums[i] >= nums[2*i+2]){
					break;
				}
				max = nums[2*i+1] > nums[2*i+2] ? 2*i+1:2*i+2;
			}else{
				//符合则退出递归
				if(nums[i] >= nums[2*i+1]){
					break;
				}
				max = 2*i+1;
			}
			
			SwapUtils.swap(nums, i, max);
			i = max;
		}
	}
}
