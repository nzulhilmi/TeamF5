package testing;

import java.util.Observable;

public class algModel extends Observable{
	
	public algModel(sortingAlgs alg){
		super();

	}

	public void goBack(){
		System.err.println("set the array to go back one position and update the GUI");
	}

	public void goForward(){
		System.err.println("set the array to go forward one position and update the GUI");
	}

	public void pause(){
		System.err.println("pause the annimation");
	}
	public void play(){
		System.err.println("play the annimation");
	}

	public void setSpeed(int value) {
		System.err.println("set the speed");
		
	}

	public String getSortTypeString() {
		String sort = sortingAlgs.getSortTypeString();
		return sort;
	}
}
