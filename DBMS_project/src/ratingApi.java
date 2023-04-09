public import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ratingApi {
	
	
	public static void enterUpdatePodcastRating(int podcast_id, double rating) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			// Query to insert the record into ARTICLES table.
//			String insertSql = "INSERT INTO Rates (user_id, podcast_id, rating) VALUES (?, ?, ?)";
//			// Create PreparedStatement Object for given insert query.
//			ps = connection.prepareStatement(insertSql);
//			// Set values with user-passed arguments.
//			ps.setInt(1, user_id);
//			ps.setInt(2, podcast_id);
//			ps.setInt(3, rating);
////			ps.setString(3, artName);
////			ps.setString(4, artText);
////			ps.setString(5, artCreationDate);
//			ps.executeUpdate();
			String insertSql = "UPDATE Podcast SET rating = ? WHERE podcast_id = ?";
			ps = connection.prepareStatement(insertSql);
			ps.setDouble(1, rating);
			ps.setInt(2, podcast_id);
			
			ps.executeUpdate();
//			insertSql = "UPDATE Podcast SET rating_count = rating_count+1 WHERE podcast_id = ?";
//			
//			ps.setInt(1, podcast_id);
//			ps = connection.prepareStatement(insertSql);
//			ps.executeUpdate();
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
//		Scanner scanner = new Scanner(System.in);
		// int roleChoice = -1;
		System.out.println("Hello");
//		Homework2.enterArtistMonthlyListeners(2001, -99);
//		Homework2.updateArtistMonthlyListeners(2001, -100);
		Homework2.enterUpdatePodcastRating(5001, 4.5);
		
	}


}
