package day2.assets;

public abstract class Parent { 
	// 1. ONCE WE HAVE ONE ABSTRACT FUNC, ALL CLASS WILL BECOME ABSTRACT
	// 2. ABSTRACT CLASSES CANNOT BE INSTANTIATED
	// 3. CHILD SHOULD OVERRIDE ALL FUNCTIONS

	private String name;  // STRICT TO THIS CLASS (incapsulation)
	protected String sharedName;
	public int infoIndex;
	
	public Parent() {
		System.out.println("Parent " + name + " Default Constructor");
	}
	
	public Parent(int x) {
		System.out.println("Parent Overrided Constructor");
	}
	
	public abstract void doSomething(); // 
	
	public abstract void doSomething(String x);
}
