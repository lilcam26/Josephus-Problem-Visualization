//Christian Shimko
import java.util.InputMismatchException;
import java.util.Scanner;

public class JosephusProblem {
	
	//User intractable interface
	public static void UI() {
		Scanner scan = new Scanner(System.in);
		int response = 0;
		int responseOne = 0;
		int skip = 0;
		System.out.printf("Welcome to the Josephus Problem.\n"
				+ "How many people in the circle (1 – 100)?  \n");
		
		do {
		    try {
		        response = scan.nextInt();
		    } catch (InputMismatchException e) {
		        System.out.print("Invalid input... try again\n"
		        		+ "How many people in the circle (1 – 100)?\n");
		        
		    }
		    scan.nextLine(); // clears the buffer						//this block handles input exceptions
		} while (response == 0);
		while(response > 100 || response < 2) {
			try {
				System.out.print("Invalid input... try again\n"
		        		+ "How many people in the circle (1 – 100)?\n");
		        response = scan.nextInt();
		    } catch (InputMismatchException e) {
		    }
			scan.nextLine();
		}
		
		LinkedList list = createList(response);
		
		
		
		System.out.println("Enter the number of people to skip between eliminations (inclusive): \n");		
		do {
		    try {
		        responseOne = scan.nextInt();
		    } catch (InputMismatchException e) {
		        System.out.print("Invalid input... try again\n"
		        		+ "Enter the number of people to skip between eliminations (inclusive): \n");
		    }
		    scan.nextLine(); // clears the buffer
		} while (responseOne == 0);																					
		while (responseOne > list.size) {											//this block handles input exceptions
			try {
				System.out.print("Invalid input... try again\n"
		        		+ "Enter the number of people to skip between eliminations (inclusive): \n");
		        responseOne = scan.nextInt();
		    } catch (InputMismatchException e) {}
		    scan.nextLine(); // clears the buffer	
		}
		
		skip = responseOne;
		start(skip, list);
	}
	
	
	
	//Creates list
	private static LinkedList createList(int size) {
		
		LinkedList list = new LinkedList();
		for(int i = 1; i < size + 1; i++) {list.addToEnd(i);}
		return list;
	}
	
	//prints puzzle then eliminates and loops until there is only one node left
	private static void start(int skip, LinkedList list) {
		
		int value = 0;
		int Skip = skip+ 1;
		LinkedList people = list;
		System.out.print("Initial puzzle:" + people.toString() + "\n");
	
		people.deleteIndex(Skip);
		System.out.println("Remaining:" + people.toString());
		
		while (people.size > 1){
			for(int i = 0; i < skip-1; i++) {
				if(Skip < people.size) {
					Skip += 1;
				}else {
					Skip = 1;
				}
			}
			if (Skip != 1) {
				people.deleteIndex(Skip);
			} else {
				people.deleteFront();
			}
			System.out.println("Remaining:" + people.toString());
		}
		
		System.out.println("Survivor: " + people.toString());
		
		
	}
			


}
