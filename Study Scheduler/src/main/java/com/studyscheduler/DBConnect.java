import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnect {

	// Establishes a connection to the StudyScheduler database
	// returns the connection to be used for queries.
	static Connection connectToDb() {
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
	static void closeConnect(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}
	
	// Inserts the desired info into the correct column of the database depending on the type parameter.
	// Takes in the connection to the database, the column to insert into, and an ArrayList of the values to be inserted.
	static void insertStudentInfo(Connection connection, String type, ArrayList<Object> values) {
		Statement statement = null;
		String query = "INSERT INTO Student";
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error! Could not create a statement.");
			e.printStackTrace();
		}
		
		if(type.equals("NewStudent")) {
			query = query + "(username, password) VALUES (" + argsToString(values) + ")";
		}
		else if(type.equals("Classes")) {
			query = query + "(classes) VALUES (" + argsToString(values) + ")";
		}
		else if(type.equals("Blockouts")) {
			query = query + "(blockouts) VALUES (" + argsToString(values) + ")";
		}
		else if(type.equals("Schedules")) {
			query = query + "(schedules) VALUES (" + argsToString(values) + ")";
		}
		
		try {
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("Error! Could not execute insert query");
			e.printStackTrace();
		}
	}
	
	static void updateStudentInfo(Connection connection, String type) {
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
	
	static void deleteStudentInfo(Connection connection, String user) {
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
	
	//TODO: add a method to return student info
	
	// Inserts a new class into the Classes table with all the required class info.
	// Takes in the connection to the database and an ArrayList of the class info.
	static void insertClass(Connection connection, ArrayList<Object> values) {
		Statement statement = null;
		String query = "INSERT INTO Classes" + "(CourseId, CourseName, MeetingTime, CreditHours) VALUES (" + argsToString(values) + ")";
		
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
	
	static void updateClass(Connection connection) {
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
	
	static void deleteClass(Connection connection, String course) {
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
	static String argsToString(ArrayList<Object> values) {
		StringBuilder argsString = new StringBuilder();
		for(Object o: values) {
			argsString.append(o.toString());
			argsString.append(", ");
		}
		
		return argsString.toString();
	}
}