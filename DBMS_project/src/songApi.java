import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class songApi {
	
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void insertSong(int song_ID, String title, int duration,String release_date, String language, String country, double royalty_rate, int label_id, int album_id, int track_num, int play_count) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			
			String insertSql = "INSERT INTO Song (song_ID, title, duration, release_date, language, country, royalty_rate, label_id, album_id, track_num, play_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// Create PreparedStatement Object for given insert query.
			ps = connection.prepareStatement(insertSql);
			ps.setInt(1, song_ID);
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
		Scanner scanner = new Scanner(System.in);
		int roleChoice = -1;
		System.out.println("Hello");
		insertArticle();
		
	}


}
