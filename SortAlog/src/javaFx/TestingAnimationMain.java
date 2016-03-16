package javaFx;

public class TestingAnimationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,1,2,4,8,7,9,0};
		SortAlgos a = new SortAlgos("Quick", array);

		System.out.println("Start: ");
		for(int i = 0;i<a.sorted.size();i++){
			System.out.println();
			for(int j=0;j<a.sorted.get(i).length;j++){
				System.out.print(a.sorted.get(i)[j] + ", ");
			}
		}
	}

}
