package com.weekfourproject;

import java.util.Scanner;

public class OfficialDatabase {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		String userMenuInput =  null;
		boolean menuCorrect = false;
		
		System.out.println("Welcome to the Basketball Official's Database program");
		
		do {
			System.out.println("Press 1 to READ from the Database");
			System.out.println("Press 2 to ADD to a profile to the Database");
			System.out.println("Press 3 to UPDATE a profile in the Database");
			System.out.println("Press 4 to DELETE a profile from the Database");
			userMenuInput = keyboard.nextLine();

			switch (userMenuInput) {
			case "1":
				DAO.readFromDB();
				break;
			case "2":
//				DAO.writeToDB();
				break;
			case "3":
				DAO.updateProfileInDb();
				break;
			case "4":
				DAO.deleteFromProfileInDB();
				break;
			default:
				System.out.println("You've entered an invalid option");
				menuCorrect = true;
				break;

			}
		
		} while (menuCorrect);
		

	}

}
