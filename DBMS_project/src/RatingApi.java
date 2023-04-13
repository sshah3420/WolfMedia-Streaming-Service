import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;

public class RatingApi {
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static PreparedStatement ps2 = null; 
	public static ResultSet rs = null;
	public static ResultSet rs1 = null;
	
	public static void enterUpdatePodcastRating(int podcast_id, double rating) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "UPDATE Podcast SET rating = ? WHERE podcast_id = ?";
			ps = connection.prepareStatement(insertSql);
			ps.setDouble(1, rating);
			ps.setInt(2, podcast_id);
			
			ps.executeUpdate();
			System.out.println("Rating Added.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection Objects.
			close(ps);
			close(connection);
		}
	}

	// method to close Connection.
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
		
//				System.out.println("Hello");
//				Scanner scanner = new Scanner(System.in);
//				System.out.println("Please enter the Podcast ID:");
//				int podcastId = scanner.nextInt();
//				System.out.println("Please enter the Rating:");
//				Double Rating = scanner.nextDouble();
//				enterUpdatePodcastRating(podcastId, Rating);
			}


}
