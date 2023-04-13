import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;

public class SongInfoApi {
	
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void enterSongInfo(int songId, String title, int duration, String release_date, String language, String country, double royalty_rate, int label_id, int album_id, int track_num, int play_count) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("start");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			System.out.println("start2");

			// Query to insert the record into Song table.
			String insertSql = "INSERT INTO Song (song_ID, title, duration, release_date, language, country, royalty_rate, label_id, album_id, track_num, play_count) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			// Create PreparedStatement Object for given insert query.
			ps = connection.prepareStatement(insertSql);
			ps.setInt(1, songId);
	        ps.setString(2, title);
	        ps.setInt(3, duration);
	        ps.setString(4, release_date);
	        ps.setString(5, language);
	        ps.setString(6, country);
	        ps.setDouble(7, royalty_rate);
	        ps.setInt(8, label_id);
	        ps.setInt(9, album_id);
	        ps.setInt(10, track_num);
	        ps.setInt(11, play_count);
			
			ps.executeUpdate();
			System.out.println("Song Added.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection Objects.
			close(ps);
			close(connection);
		}
	}
	
	
	public static void updateSongInfo(int song_id, String column, Object value) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			String updateSql = null;
			if (column.equals("play_count")) {
			    System.out.println("CALL THE PLAY COUNT UPDATE FUNCTION");
				updateSql = "UPDATE Song SET " + 1;

			} else if (column.equals("title") || column.equals("release_date") || column.equals("country") || column.equals("language")){
				updateSql = "UPDATE Song SET " + column + " = '" + value + "' WHERE song_ID = " + song_id;
			} else {
				updateSql = "UPDATE Song SET " + column + " = " + value + " WHERE song_ID = " + song_id;
			}
			// Query to update the Article Text.
			// Create Statement Object.
			stmt = connection.createStatement();
			// Execute the update query using Statement object.
			stmt.execute(updateSql);
			System.out.println("Song updated.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close Statement and Connection Objects.
			close(stmt);
			close(connection);
		}
	}
	
	public static void deleteSongInfo(int song_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);

			// Query to delete the record from ARTICLES table.
			String deleteSql = "DELETE FROM Song WHERE song_ID = " + song_id;
			// Create Statement Object.
			stmt = connection.createStatement();
			// Execute the delete query using Statement object.
			stmt.executeUpdate(deleteSql);
			System.out.println("Song Deleted.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close Statement and Connection Objects.
			close(stmt);
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
//		System.out.println("Please select an operation:\n1. Insert Song info\n2. Update Song info\n3. Delete Song info");
//		int choice = scanner.nextInt();
//
//		switch (choice) {
//			case 1:
//				System.out.println("Please enter the song_ID: ");
//			    int songId = scanner.nextInt();
//			    System.out.println("Please enter the Title: ");
//			    String title = scanner.next();
//			    System.out.println("Please enter the Duration: ");
//			    int duration = scanner.nextInt();
//			    System.out.println("Please enter the Release Date: ");
//			    String release_date = scanner.next();
//			    System.out.println("Please enter the Language: ");
//			    String language = scanner.next();
//			    System.out.println("Please enter the Country: ");
//			    String country = scanner.next();
//			    System.out.println("Please enter the Royalty Rate: ");
//			    double royalty_rate= scanner.nextDouble();
//			    System.out.println("Please enter the Label_ID: ");
//			    int label_id = scanner.nextInt();
//			    System.out.println("Please enter the Album_ID:");
//			    int album_id = scanner.nextInt();
//			    System.out.println("Please enter the Track Number:");
//			    int track_num = scanner.nextInt();
//			    System.out.println("Please enter the Play Count:");
//			    int play_count= scanner.nextInt();
//				enterSongInfo(songId, title, duration, release_date, language, country, royalty_rate, label_id, album_id, track_num, play_count);
//				break;
//			case 2:
//				System.out.println("Please enter the Song ID: ");
//			    int song_Id = scanner.nextInt();
//			    System.out.println("Please enter the column name you want to edit: ");
//			    String column = scanner.next();
//			    System.out.println("Please enter the Value for the column: ");
//			    Object value = scanner.next();
//				updateSongInfo(song_Id, column, value );
//				break;
//			case 3:
//				System.out.println("Please enter the Song ID: ");
//			    int Song_Id2 = scanner.nextInt();
//				deleteSongInfo(Song_Id2);
//				break;
//			default:
//				System.out.println("Invalid choice.");
//		}
		
	}


}
