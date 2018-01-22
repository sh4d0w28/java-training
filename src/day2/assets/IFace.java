package day2.assets;

// Pure abstract
public interface IFace {
	
	static int sharedData = 0; // cannot have any obj-related vars
	void process();

}
