import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;

public class AssignApi {
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";
	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static PreparedStatement ps2 = null;
	public static ResultSet rs = null;
	
	public static void assignPodcastHostToPodcast(int memberId, int podcastId) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			
			System.out.println(connection);
			
			String insertSql = "INSERT INTO Podcast_Has_Host (member_id, podcast_ID) VALUES (" + memberId + ", " + podcastId + ")";
			ps = connection.prepareStatement(insertSql);
			ps.executeUpdate();
			System.out.println("Host successfully assigned to Podcast");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(connection);
		}
	}

	
	public static void assignArtistToAlbum(int albumId, int artistId) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			
			System.out.println(connection);
			
			String insertSql = "INSERT INTO Artist_Part_of (artist_id, album_id) VALUES (" + artistId + ", " + albumId + ")";
			ps = connection.prepareStatement(insertSql);
			ps.executeUpdate();
			System.out.println("Album successfully assigned to Artist");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(connection);
		}
	}
	
	
	public static void assignSongToArtist(int artistId, int songId, int is_lead) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			
			System.out.println(connection);
			
			String insertSql = "INSERT INTO Artist_contributes (artist_id, song_id, is_lead) VALUES (" + artistId + ", " + songId + ", " + is_lead + ")";
			ps = connection.prepareStatement(insertSql);
			ps.executeUpdate();
			System.out.println("Song successfully assigned to Artist");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(connection);
		}
	}
	
	public static void assignArtistToRecordLabel(int label_id, int member_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			String updateSql = "UPDATE Artist SET label_id = " + label_id + " WHERE member_id = " + member_id;
			stmt = connection.createStatement();
			stmt.execute(updateSql);
			
			System.out.println("Artist Assigned to Record Label.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(connection);
		}
	}
	
	public static void assignPodcastEpisodesToPodcast(int podcast_id, int episode_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			String updateSql = "UPDATE Episode SET podcast_id = " + podcast_id + " WHERE episode_ID = " + episode_id;
			stmt = connection.createStatement();
			stmt.execute(updateSql);
			
			System.out.println("Episode Assigned to Podcast.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(connection);
		}
	}
	
	public static void assignSongToAlbum(int Song_id, int Album_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			String updateSql = "UPDATE Song SET album_id = " + Album_id + " WHERE song_ID = " + Song_id;
			stmt = connection.createStatement();
			stmt.execute(updateSql);
			
			System.out.println("Song Assigned to Album.");
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
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Please select an Assign operation:\n1. Assign Host to Podcast info\n2. Assign Album to Artist info\n3. Assign Song to Artist");
//		int choice = scanner.nextInt();
//
//		switch (choice) {
//			case 1:
//				System.out.println("Please enter the Member ID/ Host ID:");
//			    int memberId = scanner.nextInt();
//			    System.out.println("Please enter the Podcast ID:");
//			    int podcast_id = scanner.nextInt();
//			    assignPodcastHostToPodcast(memberId, podcast_id);
//				break;
//			case 2:
//				System.out.println("Please enter the Album ID:");
//			    int album_id = scanner.nextInt();
//			    System.out.println("Please enter the Podcast ID:");
//			    int artist_id = scanner.nextInt();
//			    assignArtistToAlbum(album_id, artist_id);
//				break;
//			case 3:
//				System.out.println("Please enter the Member ID/ Artist ID:");
//			    int artistId = scanner.nextInt();
//			    System.out.println("Please enter the Song ID:");
//			    int songId = scanner.nextInt();
//			    System.out.println("Please enter artist's contribution ( 1: Lead, 0: Guest): ");
//			    int is_leadId = scanner.nextInt();
//			    assignSongToArtist(artistId, songId, is_leadId);
//				break;
//			default:
//				System.out.println("Invalid choice.");
//		}
//		
	}
}