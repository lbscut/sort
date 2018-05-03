package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestCaseUtils {
	
	static File file;
	static FileReader fr;
	static BufferedReader br;
	
	static{
//		try {
//			file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testcase");
//			fr = new FileReader(file);
//			br = new BufferedReader(fr);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	public static int[] nextInput(){
		try {
			String input = br.readLine();
			return stringToNumber(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String nextAnswer(){
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String arrayToString(int[] nums){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<nums.length;i++){
			sb.append(nums[i]+",");
		}
		if(sb.length()>0){
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	public static int[] stringToNumber(String str){
		if(str==null){
			return null;
		}
		String[] numStr = str.trim().split(",");
		int[] nums = new int[numStr.length];
		for(int i=0;i<nums.length;i++){
			nums[i] = Integer.valueOf(numStr[i]);
		}
		return nums;
	}
	
	public static void testSort(Sort sort){
		try {
			file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testcase");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(sort.getClass());
		int[] nums;
		int[] result;
		int success = 0;
		int failed = 0;
		while((nums = TestCaseUtils.nextInput()) != null){
			String input = TestCaseUtils.arrayToString(nums);
			result = sort.sort(nums);
			String now = TestCaseUtils.arrayToString(result);
			String expected = TestCaseUtils.nextAnswer();
			if(now.equals(expected)){
				success++;
			}else{
				failed++;
				System.out.println("input: " + input);
				System.out.println("actual: " + now);
				System.out.println("expecdted: " + expected);
			}
		}
		System.out.println("success:"+success + " failed:"+failed);
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
