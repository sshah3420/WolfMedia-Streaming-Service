import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;

public class ArtistMonthlyListenersApi{
	
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
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			String insertSql = "INSERT INTO Monthly_artist_count(artist_id, count) VALUES (?, ?)";
			ps = connection.prepareStatement(insertSql);
			ps.setInt(1, artist_id);
			ps.setInt(2, count_id);
			ps.executeUpdate();
			System.out.println("Monthly Artist Count Added.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(connection);
		}
	}
	public static void updateArtistMonthlyListeners(int artist_id, int count_no) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			String insertSql = " UPDATE Monthly_artist_count SET count = ? WHERE artist_id = " + artist_id;
			ps = connection.prepareStatement(insertSql);
			ps.setInt(1, count_no);

			ps.executeUpdate();
			System.out.println("Monthly Artist Count Updated.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
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
//				System.out.println("Hello");
//				Scanner scanner = new Scanner(System.in);
//				System.out.println("Please select an operation:\n1. Enter Artist Monthly Listeners info\n2. Update Artist Monthly Listeners");
//				int choice = scanner.nextInt();
//		
//				switch (choice) {
//					case 1:
//						System.out.println("Please enter the Member ID/ Artist ID:");
//						int artistId = scanner.nextInt();
//						System.out.println("Please enter its Song Count");
//						int song_id = scanner.nextInt();
//						enterArtistMonthlyListeners(artistId, song_id);
//						break;
//					case 2:
//						System.out.println("Please enter the Member ID/ Artist ID:");
//						 int artist_Id = scanner.nextInt();
//						System.out.println("Please enter its Song Count:");
//						int songid = scanner.nextInt();
//						updateArtistMonthlyListeners(artist_Id, songid);
//						break;
//					default:
//						System.out.println("Invalid choice.");
//				}
//
//				// Homework2.enterArtistMonthlyListeners(2001, -99);
//				// Homework2.enterUpdatePodcastRating(5001, 4.5);
//				
//				
			}
}

