package View;

import java.util.Scanner;

public class FirstChoice {
	 int choice = -1;
	 Scanner sca = new Scanner(System.in);
	
	public int choice() {
		int ch = -1;
		

		System.out.println("1-Insert");
		System.out.println("2-Display");
		System.out.println("3-Update");
		System.out.println("4-Search");
		System.out.println("5-Delete");
		System.out.println("0-Exit");
try {
		while (true) {
			System.out.println("Enter your choice here:");
			ch = sca.nextInt();
			if (ch <= 5 && ch >= 0) {
				choice = ch;
				break;
			}
			System.out.println("Please enter a number between 0-5");
		}
}catch(Exception e){
	e.printStackTrace();
	
}
		return choice;
	}
	int secondCh = 0;
	public int secondCh() {
		int choice2 = 0;
		System.out.println("1-New Member");
		System.out.println("2-New GymClass");
		System.out.println("3-New Trainer");
		try {
			while (true) {
				System.out.println("Enter your choice here:");
				choice2 = sca.nextInt();
				if (choice2 >= 1 && choice2 <= 3) {
					secondCh = choice2;
					break;
				}
				System.out.println("Please enter a number between 1-3");
			}
	}catch(Exception e){
		e.printStackTrace();
		
	}
		
		
		return secondCh;
		
	}
	int thirdCh = -1;
	public int thirdCh() {
		int choice3 = 0;
		System.out.println("1-To Delete a Member/Client");
		System.out.println("2-To Delete a Gym Class");
		System.out.println("3-To Delete a Trainer");
		try {
			while (true) {
				System.out.println("Enter your choice here:");
				choice3 = sca.nextInt();
				if (choice3 >= 1 && choice3 <= 3) {
					thirdCh = choice3;
					break;
				}
				System.out.println("Please enter a number between 1-3");
			}
	}catch(Exception e){
		e.printStackTrace();
		
	}
		
		
		return thirdCh;
	}
	int fourthCh = -1;
	public int fourthCh() {
		int choice3 = 0;
		System.out.println("1-To update a Member/Client");
		System.out.println("2-To update a Gym Class");
		System.out.println("3-To update a Trainer");
		try {
			while (true) {
				System.out.println("Enter your choice here:");
				choice3 = sca.nextInt();
				if (choice3 >= 1 && choice3 <= 3) {
					fourthCh = choice3;
					break;
				}
				System.out.println("Please enter a number between 1-3");
			}
	}catch(Exception e){
		e.printStackTrace();
		
	}
		
		
		return fourthCh;
	}
	int FifthCh = -1;
	public int FifthCh() {
		int choice3 = 0;
		System.out.println("1-To search for a Member/Client");
		System.out.println("2-To search for a Gym Class");
		System.out.println("3-To search for a Trainer");
		try {
			while (true) {
				System.out.println("Enter your choice here:");
				choice3 = sca.nextInt();
				if (choice3 >= 1 && choice3 <= 3) {
					FifthCh = choice3;
					break;
				}
				System.out.println("Please enter a number between 1-3");
			}
	}catch(Exception e){
		e.printStackTrace();
		
	}
		
		
		return FifthCh;
	}


}
