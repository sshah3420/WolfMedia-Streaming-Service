import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;

public class PodcastEpisodeInfoApi{
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";
	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void enterPodcastEpisodeInfo(int podcast_id, int episode_ID, int ad_count, String title, int duration, String release_date, double bonus_rate, int listening_count) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			// Query to insert the record into Episode table.
			String insertSql = "INSERT INTO Episode (podcast_id, episode_ID, ad_count, title, duration, release_date, bonus_rate, listening_count) VALUES (?,?,?,?,?,?,?,?)";
			// Create PreparedStatement Object for given insert query.
			ps = connection.prepareStatement(insertSql);
			// Set values with user-passed arguments.
			ps.setInt(1, podcast_id);
			ps.setInt(2, episode_ID);
			ps.setInt(3, ad_count);
			ps.setString(4, title);
			ps.setInt(5, duration);
			ps.setString(6, release_date);
			ps.setDouble(7, bonus_rate);
			ps.setInt(8, listening_count);
			ps.executeUpdate();
			System.out.println("Episode Added.");
			
			insertSql = "UPDATE Podcast SET episode_count = episode_count+1 WHERE podcast_ID = " + podcast_id;
			ps = connection.prepareStatement(insertSql);
			ps.executeUpdate();
			System.out.println("Episode count in Podcast Updated.");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection Objects.
			close(ps);
			close(connection);
		}
	}
	
	public static void updatePodcastEpisodeInfo(String column, Object value, int episode_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			// Query to update the Article Text.
			String updateSql = null;
			if (column.equals("listening_count") || column.equals("ad_count")) {
				;
			} else if (column.equals("title") || column.equals("release_date")){
				updateSql = "UPDATE Episode SET " + column + " = '" + value + "' WHERE episode_ID = " + episode_id;
				
			} else {
				updateSql = "UPDATE Episode SET " + column + " = " + value + " WHERE episode_ID = " + episode_id;
			}
			// Create Statement Object.
			stmt = connection.createStatement();
			// Execute the update query using Statement object.
			stmt.execute(updateSql);
			System.out.println("Episode updated.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close Statement and Connection Objects.
			close(stmt);
			close(connection);
		}
	}
	public static void deletePodcastEpisodeInfo(int episode_ID, int podcast_ID) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);

			// Query to delete the record from ARTICLES table.
			String deleteSql = "DELETE FROM Episode WHERE episode_ID = " + episode_ID;
			// Create Statement Object.
			stmt = connection.createStatement();
			// Execute the delete query using Statement object.
			stmt.executeUpdate(deleteSql);
			deleteSql = "UPDATE Podcast SET episode_count = episode_count-1 WHERE podcast_ID = " + podcast_ID;
			ps = connection.prepareStatement(deleteSql);
			ps.executeUpdate();

			System.out.println("Episode Deleted.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close Statement and Connection Objects.
			close(stmt);
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
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please select an operation:\n1. Insert Episode info\n2. Update Episode info\n3. Delete Episode info");
//		int choice = scanner.nextInt();
//
//		switch (choice) {
//			case 1:
//				System.out.println("Please enter the Podcast_ID: ");
//			    int PodcastId = scanner.nextInt();
//			    System.out.println("Please enter the Episode_ID: ");
//			    int EpisodeId = scanner.nextInt();
//			    System.out.println("Please enter the Duration: ");
//			    int duration = scanner.nextInt();
//			    System.out.println("Please enter the Release Date: ");
//			    String release_date = scanner.next();
//			    System.out.println("Please enter the Ad Count: ");
//			    int AdCount = scanner.nextInt();
//			    System.out.println("Please enter the Title: ");
//			    String Title = scanner.next();
//			    System.out.println("Please enter the Bonus Rate: ");
//			    double BonusRate= scanner.nextDouble();
//			    System.out.println("Please enter the Listening Count: ");
//			    int ListeningCount = scanner.nextInt();
//				enterPodcastEpisodeInfo(PodcastId, EpisodeId, AdCount, Title, duration, release_date, BonusRate, ListeningCount);
//				break;
//			case 2:
//				System.out.println("Please enter the Episode ID: ");
//			    int Episode_Id = scanner.nextInt();
//			    System.out.println("Please enter the column name you want to edit: ");
//			    String column = scanner.next();
//			    System.out.println("Please enter the Value for the column: ");
//			    Object value = scanner.next();
//				updatePodcastEpisodeInfo(column, value, Episode_Id);
//				break;
//			case 3:
//				System.out.println("Please enter the Episode ID: ");
//			    int Episode_Id2 = scanner.nextInt();
//			    System.out.println("Please enter the Podcast ID: ");
//			    int Podcast_ID = scanner.nextInt();
//				deletePodcastEpisodeInfo(Episode_Id2, Podcast_ID);
//				break;
//			default:
//				System.out.println("Invalid choice.");
//		}
//		
	}
}