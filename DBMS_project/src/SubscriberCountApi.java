//package songApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;

public class SubscriberCountApi{
	
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void updateSubscriberCount(int podcast_id, int count) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);

			String updateSql = "UPDATE Podcast SET subscriber_count = '" + count + "' WHERE podcast_ID = " + podcast_id;
			stmt = connection.createStatement();
			stmt.execute(updateSql);
			System.out.println("Podcast subscriber count updated.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Throwable whatever) {
			}
		}
	}

	static void close(PreparedStatement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Throwable whatever) {
			}
		}
	}

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
//		System.out.print("Enter Podcast Id:");
//		int podcast_id = Integer.parseInt(scanner.nextLine());
//		System.out.println("Enter New Total Subscriber Count:");
//		int count = Integer.parseInt(scanner.nextLine());
//		updateSubscriberCount(podcast_id, count);
		
	}


}
