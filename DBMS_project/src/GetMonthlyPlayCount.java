import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;

public class GetMonthlyPlayCount {
    private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static PreparedStatement ps2 = null; 
	public static ResultSet rs = null;
	public static ResultSet rs1 = null;

	public static void getMonthlyPlayCountPerSong(int song_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "SELECT * from Song_month_count where song_id = ?";
			ps = connection.prepareStatement(insertSql);
            ps.setInt(1, song_id);
            ResultSet rs1 = ps.executeQuery();
			java.sql.ResultSetMetaData rsmd = rs1.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			for(int i = 1; i <= columnsNumber; i++) {
				if (i > 1) System.out.print(",  ");
				System.out.print(rsmd.getColumnName(i));
			}
			while(rs1.next()) {
				System.out.println();
				for(int i = 1; i <= columnsNumber; i++) {
					if (i > 1) System.out.print(",  ");
			        String columnValue = rs1.getString(i);
			        System.out.print(" " + columnValue);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(connection);
		}
	}
	
	
	public static void getMonthlyPlayCountPerArtist(int artist_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "SELECT * from Monthly_artist_count where artist_id = ?";
			ps = connection.prepareStatement(insertSql);
            ps.setInt(1, artist_id);
            ResultSet rs1 = ps.executeQuery();
			java.sql.ResultSetMetaData rsmd = rs1.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			for(int i = 1; i <= columnsNumber; i++) {
				if (i > 1) System.out.print(",  ");
				System.out.print(rsmd.getColumnName(i));
			}
			while(rs1.next()) {
				System.out.println();
				for(int i = 1; i <= columnsNumber; i++) {
					if (i > 1) System.out.print(",  ");
			        String columnValue = rs1.getString(i);
			        System.out.print(" " + columnValue);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(connection);
		}
	}
	
	public static void getMonthlyPlayCountPerAlbum(int album_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "SELECT a.album_id, a.name, YEAR(m.timestamp) as year, MONTH(m.timestamp) as month, SUM(m.count) as play_count "
					+ "FROM Album a JOIN Song s ON a.album_id = s.album_id "
					+ "JOIN Song_month_count m ON s.song_id = m.song_id "
					+ "WHERE a.album_id = ? GROUP BY a.album_id, a.name, YEAR(m.timestamp), MONTH(m.timestamp) "
					+ "ORDER BY a.album_id, YEAR(m.timestamp), MONTH(m.timestamp)";
			ps = connection.prepareStatement(insertSql);
            ps.setInt(1, album_id);
            ResultSet rs1 = ps.executeQuery();
			java.sql.ResultSetMetaData rsmd = rs1.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			for(int i = 1; i <= columnsNumber; i++) {
				if (i > 1) System.out.print(",  ");
				System.out.print(rsmd.getColumnName(i));
			}
			while(rs1.next()) {
				System.out.println();
				for(int i = 1; i <= columnsNumber; i++) {
					if (i > 1) System.out.print(",  ");
			        String columnValue = rs1.getString(i);
			        System.out.print(" " + columnValue);
				}
				
			}
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
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please select an operation:\n1. Get Monthly Count per Song \n2. Get Monthly Count Per Artist \n3. Get Monthly Count Per Album");
//		int choice = scanner.nextInt();
//
//		switch (choice) {
//			case 1:
//				System.out.println("Please enter the Song ID: ");
//			    int song_id = scanner.nextInt();
//			    getMonthlyPlayCountPerSong(song_id);
//				break;
//			case 2:
//				System.out.println("Please enter the Artist/ Member ID: ");
//			    int artist_id = scanner.nextInt();
//			    getMonthlyPlayCountPerArtist(artist_id);
//				break;
//			case 3:
//				System.out.println("Please enter the Album ID: ");
//			    int album_id = scanner.nextInt();
//			    getMonthlyPlayCountPerAlbum(album_id);
//				break;
//				
//			default:
//				System.out.println("Invalid choice.");
//		}

	}


}
