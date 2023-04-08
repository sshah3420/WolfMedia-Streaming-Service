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
	
	public static void insertArticle() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			// Query to insert the record into ARTICLES table.
			String insertSql = "INSERT INTO Song (song_ID, title, duration, release_date, language, country, royalty_rate, label_id, album_id, track_num, play_count) VALUES (45, 'Forever alone', 6, '1998-10-06', 'Hindi', 'India', 0.12, 201, 301, 1, 2)";
			// Create PreparedStatement Object for given insert query.
			ps = connection.prepareStatement(insertSql);
			// Set values with user-passed arguments.
//			ps.setInt(1, pubId);
//			ps.setInt(2, artNum);
//			ps.setString(3, artName);
//			ps.setString(4, artText);
//			ps.setString(5, artCreationDate);
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
