package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 基数排序
 * 限制只能是正数
 * @author lb
 *
 */
public class RadixSort implements Sort {

	public int[] sort(int[] nums) {
		//计算可能的位数
		int count = 0;
		int value = Integer.MAX_VALUE;
		while(value > 0){
			count++;
			value >>= 1;
		}
		//辅助空间，大小为10，每一个是个链表，用于放置该位为0-9的数，
		List<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>(10);
		//对每一位进行排序
		for (int i = 0; i < count; i++) {
			//重置辅助空间
			list = new ArrayList<LinkedList<Integer>>(10);
			for(int j=0;j<10;j++){
				list.add( new LinkedList<Integer>());
			}
			int divideNum = (int)Math.pow(10, i+1);
			//遍历数组
			for (int j = 0; j < nums.length; j++) {
				//求出该位的数，并放置到链表里
				list.get((nums[j]%divideNum)/(divideNum/10)).add(nums[j]);
			}
			//从辅助空间取出，此时的顺序在该位有序
			int current = 0;
			for(int j=0;j<10;j++){
				while(!list.get(j).isEmpty()){
					nums[current++] = list.get(j).removeFirst();
				}
			}
		}
		//遍历了31*N个元素，所以是线性时间
		//辅助空间也是max(N,10)个
		return nums;
	}

}
