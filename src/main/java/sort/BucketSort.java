package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSort implements Sort {

	public int[] sort(int[] nums) {
		List<LinkedList<Integer>> buckets = new ArrayList<LinkedList<Integer>>(3);
		buckets.add(new LinkedList<Integer>());
		buckets.add(new LinkedList<Integer>());
		buckets.add(new LinkedList<Integer>());
		for (int i = 0; i < nums.length; i++) {
			buckets.get(map(nums[i])).add(nums[i]);
		}
		int current = 0;
		for (int i = 0; i < buckets.size(); i++) {
			Integer[] temp = {};
			temp = buckets.get(i).toArray(temp);
			if(temp.length>0){
				temp = new QuickSortForBucketSort().sort(temp);
				for (int j = 0; j < temp.length; j++) {
					nums[current++] = temp[j];
				}
			}
		}
		return nums;
	}
	
	public int map(int num){
		int key;
		if(num<50){
			key = 0;
		}else if(num<200){
			key = 1;
		}else {
			key = 2;
		}
		return key;
	}

}
