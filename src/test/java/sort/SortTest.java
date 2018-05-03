package sort;

import java.io.IOException;

public class SortTest {
	public static void main(String[] args) throws IOException {
		TestCaseUtils.testSort(new BubbleSort());
		TestCaseUtils.testSort(new SelectSort());
		TestCaseUtils.testSort(new InsertSort());
		TestCaseUtils.testSort(new ShellSort());
		TestCaseUtils.testSort(new QuickSort());
		TestCaseUtils.testSort(new MergeSort());
		TestCaseUtils.testSort(new CountSort());
		TestCaseUtils.testSort(new RadixSort());
		TestCaseUtils.testSort(new BucketSort());
		TestCaseUtils.testSort(new HeapSort());
	}
}
