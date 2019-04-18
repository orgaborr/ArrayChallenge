
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		printArray(sortIntegers(getIntegers(5)));
		
		
		sc.close();
	}
	
	public static int[] getIntegers(int number) {
		System.out.println("Enter " + number + " integers:");
		int[] values = new int[number];
		for(int i=0; i<values.length; i++) {
			if(sc.hasNextInt()) {
				values[i] = sc.nextInt();
			} else {
				//error message and resetting incrementation
				System.out.println("Value is not an int");
				i--;
			}
			sc.nextLine(); //taking 'enter' key
		}
		return values;
		
	}
	
	public static void printArray(int[] array) {
		for(int i=0; i<array.length; i++) {
			System.out.println("Element " + i + " is " + array[i]);
		}
	}
	//sets up the values in a descending order
	public static int[] sortIntegers(int[] array) {
		int[] descendingArray = new int[array.length];
		int smallest = array[0];

		//finds the smallest element
		for(int i=0; i<array.length; i++) {
			if(array[i] <= smallest) {
				smallest = array[i];
			}	
		}

		for(int i=0; i<array.length; i++) {
			int biggest = smallest; //tracking biggest number
			int count = -1; //tracking index of biggest element
			for(int j=0; j<array.length; j++) {
				if(array[j] >= biggest) {
					biggest = array[j];
					count = j;
				}	
			}
			descendingArray[i] = biggest;
			biggest = smallest; //resetting 'biggest' to the smallest value
			array[count] = smallest; //changes the biggest element to the smallest value of the array
	
		}
		return descendingArray;
	}

}
