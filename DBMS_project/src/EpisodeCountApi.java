//package songApi;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;

public class EpisodeCountApi{
	
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void updateListeningCount(int episode_id, int count) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get connection object
			connection = DriverManager.getConnection(jdbcURL, user, password);

			String updateSql = "UPDATE Episode SET listening_count = '" + count + "' WHERE episode_ID = " + episode_id;
			// Create Statement Object.
			stmt = connection.createStatement();
			stmt.execute(updateSql);
			System.out.println("Podcast episode listening count updated.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection Objects.
			close(stmt);
			close(connection);
		}
	}
	
		static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (Throwable whatever) {
			}
		}
	}

	// method to Statement.
	static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Throwable whatever) {
			}
		}
	}

	// method to close PreparedStatement.
	static void close(PreparedStatement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Throwable whatever) {
			}
		}
	}

	// method to close ResultSet
	static void close(ResultSet result) {
		if (result != null) {
			try {
				result.close();
			} catch (Throwable whatever) {
			}
		}
	}
	
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int roleChoice = -1;
//		System.out.println("Hello");
//		System.out.print("Enter Episode Id:");
//		int episode_id = Integer.parseInt(scanner.nextLine());
//		System.out.println("Enter New Total Listening Count:");
//		int count = Integer.parseInt(scanner.nextLine());
//		updateListeningCount(episode_id, count);
		
	}


}
