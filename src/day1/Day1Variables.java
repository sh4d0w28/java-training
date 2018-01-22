package day1;
import java.util.ArrayList;
import java.util.List;


public class Day1Variables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		num = 50;
		System.out.println(num);
		
		float nd = (float)20.5; // -> TYPECAST FROM DBL TO FLT
		System.out.println(nd);
		
		short color = 0xFFF;
		System.out.println(color);
		
		long cc_num = 1234_5678_1234_5678L;
		System.out.println(cc_num);
		// char = 2B
		// boolean = 1B (byte)
		
		Long myVal = new Long(10);
		
		long someVal = myVal;
		System.out.println(someVal);
		
		Byte x = 0; // byte
		Short y = 0; // 
		Integer z = 0; // integer
		Long a = 0L; // long
		Float b = 0.0f; // float
		Character c = '\0'; // character
		Boolean d = false; // boolean
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		Long l = 2L; // Long a = new Long(2);
		long l2 = 2;
		String s = "tes2t"; // - - is a REFERENCE
		
		System.out.println(l);
		System.out.println(l2);
		
		System.out.println(s.toUpperCase());
		
		// List<int> numbers = new List<>(); - incorrect
		List<Integer> numbers = new ArrayList<>();
		numbers.add(0);
	}

}
