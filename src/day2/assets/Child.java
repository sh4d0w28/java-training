package day2.assets;

public class Child extends Parent {
	
	public Child() {
		this(10);				// ONLY ONCE AND ONLY ON THE FIRST LINE!
		System.out.println("Child Default Constructor");
	}
	
	public Child(int x) {
		System.out.println("Child Overrided Constructor");
	}
	
	public void play() {
		System.out.println("Child playing " + this.sharedName);
	}
	
	@Override								 // OVERRIDE !!
	public void doSomething() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Child " + this.sharedName + " object ";
	}
	
	@Override
	public boolean equals(Object x) {
		if (this.infoIndex == ((Child)x).infoIndex) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doSomething(String x) {
		// TODO Auto-generated method stub
		
	}
	
}
