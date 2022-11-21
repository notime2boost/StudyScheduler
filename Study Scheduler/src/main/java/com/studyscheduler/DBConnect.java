package com.studyscheduler;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

	// Establishes a connection to the StudyScheduler database
	// returns the connection to be used for queries.
	public Connection connectToDb() {
		String url = "jdbc:mysql://studyscheduler-db.cuevkg6rb9hl.us-east-1.rds.amazonaws.com:3306/StudyScheduler";
		String username = "admin";
		String password = "C00P4331S5Db22";
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error! Could not connect to the database.");
			e.printStackTrace();
		}
		
		return connection;
	}	
		
	// Closes the connection to the database.
	public void closeConnect(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
	
	// Inserts the desired info into the correct column of the database depending on the type parameter.
	// Takes in the connection to the database, the column to insert into, and an Object array of the values to be inserted.
	public void insertStudentInfo(Connection connection, String type, Object[] values) {
		Statement statement = null;
		String query = "INSERT INTO Student ";
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error! Could not create a statement.");
			e.printStackTrace();
		}
		
		if(type.equals("NewStudent")) {
			query = query + "(username, password) VALUES (\"" + values[0] + "\", \""  + values[1] + "\");";
		}
		else if(type.equals("Classes")) {
			query = query + "(classes) VALUES (\"" + argsToString(values) + "\");";
		}
		else if(type.equals("Blockouts")) {
			query = query + "(blockouts) VALUES (\"" + argsToString(values) + "\");";
		}
		else if(type.equals("Schedules")) {
			query = query + "(schedules) VALUES (\"" + argsToString(values) + "\");";
		}
		System.out.println(query);
		try {
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Error! Could not execute insert query");
			e.printStackTrace();
		}
	}

	public void updateStudentInfo(Connection connection, String type, String user, String newInfo) {
		Statement statement = null;
		String query = "UPDATE Student";
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error! Could not create a statement.");
			e.printStackTrace();
		}
		
		try {
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Error! Could not execute update query");
			e.printStackTrace();
		}
	}

	public void deleteStudentInfo(Connection connection, String user) {
		Statement statement = null;
		String query = "DELETE FROM Student WHERE username = " + user + ";";
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error! Could not create a statement.");
			e.printStackTrace();
		}
		
		try {
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Error! Could not execute delete query");
			e.printStackTrace();
		}
	}
	
	// Retrieves info from the database for the desired user
	// Takes in a connection to the database and the user's username as a String
	public ResultSet retrieveStudentInfo(Connection connection, String type, String user) {
		Statement statement = null;
		ResultSet studentInfo = null;
		String query = "SELECT ";

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error! Could not create a statement.");
			e.printStackTrace();
		}

		if(type.equals("login")) {
			query = query + "username, password FROM Student WHERE username = \"" + user + "\";";
		}
		else if(type.equals("class")) {
			query = query + "classes FROM Student WHERE username = \"" + user + "\";";
		}
		else if(type.equals("blockout")) {
			query = query + "blockouts FROM Student WHERE username = \"" + user + "\";";
		}
		else if(type.equals("schedule")) {
			query = query + "schedules FROM Student WHERE username = \"" + user + "\";";
		}

		try {
			studentInfo = statement.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Error! Could not execute select query");
			e.printStackTrace();
		}

		return studentInfo;
	}
	
	// Inserts a new class into the Classes table with all the required class info.
	// Takes in the connection to the database and an ArrayList of the class info.
	public void insertClass(Connection connection, Object[] values) {
		Statement statement = null;
		String query = "INSERT INTO Classes" + "(CourseId, CourseName, MeetingTime, CreditHours) VALUES (" + argsToString(values) + ");";
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error! Could not create a statement.");
			e.printStackTrace();
		}
		
		try {
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Error! Could not execute insert query");
			e.printStackTrace();
		}
	}

	public void updateClass(Connection connection) {
		Statement statement = null;
		String query = "UPDATE Classes";
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error! Could not create a statement.");
			e.printStackTrace();
		}
		
		try {
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Error! Could not execute insert query");
			e.printStackTrace();
		}
	}

	public void deleteClass(Connection connection, String course) {
		Statement statement = null;
		String query = "DELETE From Classes WHERE CourseId = " + course + ";";
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error! Could not create a statement.");
			e.printStackTrace();
		}
		
		try {
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Error! Could not execute insert query");
			e.printStackTrace();
		}
	}
	
	//TODO: add method to return Class info
	
	// Helper method to turn a list of values into a string for the MySQL queries
	public String argsToString(Object[] values) {
		StringBuilder argsString = new StringBuilder();
		for(Object o: values) {
			argsString.append(o.toString());
			argsString.append(", ");
		}
		
		return argsString.toString();
	}
}
