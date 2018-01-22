package day3;

enum Day{   // another ordinal types
	Monday(1),
	Tuesday(2),
	Wednesday(3),
	Thursday(4),
	Friday(5),
	Saturday(6),
	Sunday(7);
	
	private int daynum;

	private Day() {	}
	
	private Day(int setNum) {
		this.daynum = setNum;
	}
}

enum Color {  //   < - is a numbers
	BLACK("notacolor"),    //0
	RED(""),      //1
	WHITE(""),    //2
	GREEN(""),    //3
	WHATEVER("");  //4
	
	private String description = "ClrS";
	
	private Color(String x) {  // << ONLY PRIVATE!
		this.description = x;
	}
	
	public String getDesc() {
		return description;
	}
}

class Data {
	public String info;
}

// 1. main: 
// obj -> heap obj
// trans -> head obj (same obj)

public class Day3Enum {

	public static void processColor(Color color) {  // PASSED BY VALUE like a PRIMITIVE
		color = Color.RED; 
	}
	
	public static void processData(Data trans) {  // PASSED BY REF
		trans.info = "this is an empty string";
	}
	
	public static void main(String[] args) {
		
		Data obj = new Data();
		obj.info = "Lorem Ipsum";
		
		processData(obj);
		
		System.out.println(obj.info);
		
		Color myFav = Color.BLACK;
		System.out.format("ORD: %d\n", myFav.ordinal()); // << - ordinal number
		System.out.format("DSC: %s\n", myFav.getDesc()); // << - call a func
		
		processColor(myFav);
		System.out.println(myFav);
	}

}
