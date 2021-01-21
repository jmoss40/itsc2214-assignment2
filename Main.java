import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayItem[] mainItems = new ArrayItem[30];
		ArrayItem[] searchItems = new ArrayItem[30];
		Scanner scanner;
		int index;
		
		// Load mainItems array from input file 1
		try {
			index = 0; // index variable is used to store each ArrayItem at the right array index
			String color; Integer id;
			scanner = new Scanner(new File("Lab2InputFile1.txt"));
			while(scanner.hasNext()) {
				color = scanner.next();
				id = scanner.nextInt();
				mainItems[index] = new ArrayItem(color, id); //create an ArrayItem object from color and ID, store in array
				index++;
			}
			scanner.close();
			mainItems = Arrays.copyOf(mainItems, index); //trim mainItems to size
		}catch(FileNotFoundException ex) {
			System.err.println("Error: Input file 1 not found.");
		}
		
		
		// Load mainItems array from input file 2
		try {
			index = 0;
			String color; Integer id;
			scanner = new Scanner(new File("Lab2InputFile2.txt"));
			while(scanner.hasNext()) {
				color = scanner.next();
				id = scanner.nextInt();
				searchItems[index] = new ArrayItem(color, id);
				index++;
			}
			scanner.close();
			searchItems = Arrays.copyOf(searchItems, index); //trim searchItems to size
		}catch(FileNotFoundException ex) {
			System.err.println("Error: Input file 2 not found.");
		}
		
		//ensure the arrays are sorted to prepare for binary search
		Arrays.sort(mainItems);
		Arrays.sort(searchItems);
		
		//Print a brief report of each array
		System.out.println("mainItems:"); 
		printArray(mainItems);
		System.out.println("searchItems:");
		printArray(searchItems);
		
		
		//perform a binary search on the mainItems array to search for each of the elements in searchItems
		System.out.println("Results of Binary Search:\n----------------------------------------");
		for(int j = 0; j < searchItems.length; j++) {
			int result = binarySearch(mainItems, searchItems[j], mainItems.length - 1, 0);
			System.out.println("Search item " + j+1 + ": {" + searchItems[j].toString() + "}\nFound: " + ((result < 0)?"No":"Yes"));
			System.out.println("----------------------------------------");
		}
	}
	
	/**
	 * Recursive function that searches the given array for the search value.
	 * @return -1 if not found, or else the index where the item was found.
	 */
	static int binarySearch(ArrayItem[] array, ArrayItem searchValue, int high, int low){
		if(high < low)
			return -1;
		int mid = (high + low) / 2;
		if(array[mid].compareTo(searchValue) > 0)
			return binarySearch(array, searchValue, mid - 1, low);
		else if(array[mid].compareTo(searchValue) < 0)
			return binarySearch(array, searchValue, high, mid+1);
		
		return mid;
	}
	
	/**
	 * A function to print an array.
	 * @param array to be printed.
	 */
	static void printArray(ArrayItem[] array) {
		String output = "";
		for(int i = 0; i < array.length; i++) {
			output += array[i].toString() + "\n";
		}
		System.out.println(output);
	}
}
