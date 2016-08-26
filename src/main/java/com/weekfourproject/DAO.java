package com.weekfourproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {

	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	static Scanner keyboard = new Scanner(System.in);

	public static void connToDB() {

		try {
			System.out.println("Attempting to connect to the Database...");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the Database");
		} catch (SQLException e) {
			System.out.println("Unable to connect to the Database!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// connToDB method

	public static void readFromDB() {

		connToDB();

		ArrayList<BasketballOfficial> listedOfficials = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM basketball_official_schedule.basic_official_information;");

			while (RES_SET.next()) {

				BasketballOfficial officialInDB = new BasketballOfficial();

				officialInDB.setOfficialID(RES_SET.getString("official_id"));
				officialInDB.setLastName(RES_SET.getString("last_name"));
				officialInDB.setFirstName(RES_SET.getString("first_name"));
				officialInDB.setPhoneNumber(RES_SET.getString("phone_number"));
				officialInDB.setDepartureLocation(RES_SET.getString("departure_location"));

				listedOfficials.add(officialInDB);

			} // while

			for (BasketballOfficial basketballOfficial : listedOfficials) {
				System.out.println(basketballOfficial.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// readFromDB method

	public static void writeToDB() {
		// Bypasses getting an instance of object BasksetballOfficial
		// String lastName = "test1";
		// String firstName = "test2";
		// String phoneNumber = "test3";
		// String departureLocation = "test4";

		String recordToInsert = "INSERT INTO `basketball_official_schedule`.`basic_official_information`"
				+ "(last_name, first_name, phone_number, departure_location)" + "VALUES" + "(?, ?, ?, ?" + ");";

		connToDB();

		BasketballOfficial officialToAdd = new BasketballOfficial();

		officialToAdd = aboutOfficial();

		try {
			PREP_STMT = CONN.prepareStatement(recordToInsert);

			PREP_STMT.setString(1, officialToAdd.getLastName());
			PREP_STMT.setString(2, officialToAdd.getFirstName());
			PREP_STMT.setString(3, officialToAdd.getPhoneNumber());
			PREP_STMT.setString(4, officialToAdd.getDepartureLocation());

			PREP_STMT.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}// writeToDB method

	public static void updateProfileInDb() {

		// String lastName = "Bundy";
		// String firstName = "Al";
		// String phoneNumber = "0000000000";
		// String departureLocation = "Chicago";

		String recordToUpdate = "UPDATE `basketball_official_schedule`.`basic_official_information`" + "SET"
				+ "`last_name` = ?,`first_name` = ?,`phone_number` = ?,`departure_location` = ?"
				+ "WHERE `official_id` = " + "?" + ";";

		BasketballOfficial officialToUpdate = new BasketballOfficial();

		connToDB();

		readFromDB();

		officialToUpdate = aboutOfficial();

		System.out.println("What is the Official ID you wish to update?");
		String officialID = keyboard.nextLine();

		try {
			PREP_STMT = CONN.prepareStatement(recordToUpdate);

			PREP_STMT.setString(1, officialToUpdate.getLastName());
			PREP_STMT.setString(2, officialToUpdate.getFirstName());
			PREP_STMT.setString(3, officialToUpdate.getPhoneNumber());
			PREP_STMT.setString(4, officialToUpdate.getDepartureLocation());
			
			PREP_STMT.setString(5, officialID);;

			PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// updateProfileInDB method

	public static void deleteFromProfileInDB() {

		// String officialID = "11";

			String recordToDelete = "DELETE FROM `basketball_official_schedule`.`basic_official_information`" + "WHERE"
				+ "`official_id` = " + "?" + ";";

		connToDB();

		readFromDB();

//		BasketballOfficial officialToDelete = new BasketballOfficial();

		System.out.println("What is the Official ID you wish to Delete?");
		String officialID = keyboard.nextLine();

		try {
			PREP_STMT = CONN.prepareStatement(recordToDelete);

			PREP_STMT.setString(1, officialID);

			PREP_STMT.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// deleteProfileInDB method

	public static BasketballOfficial aboutOfficial() {

		BasketballOfficial officialToUpdate = new BasketballOfficial();

		System.out.println("What is the new last name?");
		officialToUpdate.setLastName(keyboard.nextLine());

		System.out.println("What is the new first name?");
		officialToUpdate.setFirstName(keyboard.nextLine());

		System.out.println("What is the new phone number?");
		officialToUpdate.setPhoneNumber(keyboard.nextLine());

		System.out.println("What is the departure location?");
		officialToUpdate.setDepartureLocation(keyboard.nextLine());

		return officialToUpdate;
	}// aboutOfficial

}// main
