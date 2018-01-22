package day1;

public class Day1Arrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int[] nums = {1,-5}; // 4 bytes for "5" 
		
		nums[0] = 1;
		// nums = {0,0}; // CANNOT ASSIGN
		
		// default value for char: \0
		// default for boolean: false
		
		boolean[] moreNums = new boolean[100];
		for(boolean b: moreNums) {
			b = true;
			System.out.println(b);
		}
		
		// arrays are FIXED length
		
		int[][] mint = new int[5][2];
		System.out.println(mint);
		
		 // JAGGED ARRAY (several dimensions)
		boolean[][] attend = new boolean[2][];
		attend[0] = new boolean[17];
		attend[1] = new boolean[14];
	}

}
