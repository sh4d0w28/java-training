package day3;

interface IMyFace {
	
	void dothis();
	int dothat(int x);
	
}

class Sample implements IMyFace{

	@Override
	public void dothis() {
		System.out.println("anon::dothis::" + this.getClass().getSimpleName());	
	}

	@Override
	public int dothat(int x) {
		System.out.println("anon::dothat::" + this.getClass().getSimpleName() + x);	
		return 0;
	}
	
}

public class Day3AnonymousLabmdas {

	public static void process(IMyFace ix) {
		ix.dothis();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a = 10;
		
		IMyFace refer = new IMyFace() { // create a class from interface
			
			@Override
			public void dothis() {
				System.out.println("anon::dothis::" + this.getClass().getName());	
			}
			
			@Override
			public int dothat(int x) {
				System.out.println("anon::dothat"+this.getClass().getName() + ++x);
				return 0;
			}
		};
		refer.dothis();
		refer.dothat(a);
		
		// anon class in function call
		process(new IMyFace() {
			
			@Override
			public void dothis() {
				// a++;   ----- CANNOT! 
				System.out.println("dothis-anon-imface");
			}
			
			@Override
			public int dothat(int x) {
				System.out.println("dothat-anon-imface");
				return 0;
			}
		});
		
	}

}
