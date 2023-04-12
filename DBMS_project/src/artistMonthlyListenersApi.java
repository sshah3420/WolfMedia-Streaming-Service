import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class artistMonthlyListenersApi{
	
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void enterArtistMonthlyListeners(int artist_id, int count_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			// Query to insert the record into ARTICLES table.
			String insertSql = "INSERT INTO Monthly_artist_count(artist_id, count) VALUES (?, ?)";
			// Create PreparedStatement Object for given insert query.
			ps = connection.prepareStatement(insertSql);
			// Set values with user-passed arguments.
			ps.setInt(1, artist_id);
			ps.setInt(2, count_id);
//			ps.setString(3, artName);
//			ps.setString(4, artText);
//			ps.setString(5, artCreationDate);
			ps.executeUpdate();
			System.out.println("Monthly Artist Count Added.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection Objects.
			close(ps);
			close(connection);
		}
	}
	public static void updateArtistMonthlyListeners(int artist_id, int count_no) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			// Query to insert the record into ARTICLES table.
			String insertSql = " UPDATE Monthly_artist_count SET count = ? WHERE artist_id = " + artist_id;
			// Create PreparedStatement Object for given insert query.
			ps = connection.prepareStatement(insertSql);
			// Set values with user-passed arguments.
			ps.setInt(1, count_no);
//			ps.setInt(2, count_id);
//			ps.setString(3, artName);
//			ps.setString(4, artText);
//			ps.setString(5, artCreationDate);
			ps.executeUpdate();
			System.out.println("Monthly Artist Count Updated.");
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
		
	}

	public static void main(String[] args) {
				System.out.println("Hello");
		
				Scanner scanner = new Scanner(System.in);
				System.out.println("Please select an operation:\n1. Enter Artist Monthly Listeners info\n2. Update Artist Monthly Listeners");
				int choice = scanner.nextInt();
		
				switch (choice) {
					case 1:
						System.out.println("Please enter the Member ID/ Artist ID:");
						int artistId = scanner.nextInt();
						System.out.println("Please enter its Song Count");
						int song_id = scanner.nextInt();
						enterArtistMonthlyListeners(artistId, song_id);
						break;
					case 2:
						System.out.println("Please enter the Member ID/ Artist ID:");
						 int artist_Id = scanner.nextInt();
						System.out.println("Please enter its Song Count:");
						int songid = scanner.nextInt();
						updateArtistMonthlyListeners(artist_Id, songid);
						break;
					default:
						System.out.println("Invalid choice.");
				}

				// Homework2.enterArtistMonthlyListeners(2001, -99);
				// Homework2.enterUpdatePodcastRating(5001, 4.5);
				
				
			}
}

