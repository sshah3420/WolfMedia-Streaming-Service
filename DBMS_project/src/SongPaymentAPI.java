import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
//import java.util.Scanner;
import java.time.LocalDateTime;


public class SongPaymentAPI {
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";
	public static Connection connection = null;
	public static Statement stmt = null;
	public static Statement stmt1 = null;
	public static Statement stmt2 = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void makePaymentGivenSong(int song_ID, int month, int year) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);

			String query = "select Song.royalty_rate*count AS royalty_generated, Song.label_id from Song, Song_month_count where Song_month_count.song_id=Song.song_ID and YEAR(timestamp) = ? AND MONTH(timestamp)=? AND Song.song_ID=? and Song_month_count.royalty_paid=0";
			// make autoCommit false
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(query);
			ps.setInt(1, year);
			ps.setInt(2, month);
			ps.setInt(3, song_ID);

			ResultSet res = ps.executeQuery();
			while(res.next()) {
				int amount = res.getInt("royalty_generated");
				double label_payment = amount*0.3;
				int label_id = res.getInt("label_id");
				double total_artist_payment = 0.7*amount;
				LocalDateTime ldt = LocalDateTime.of(year, month, 1, 0, 0, 0);
		        Timestamp timestamp = Timestamp.valueOf(ldt);
		        String makeLabelPayment = "insert into RecordLabel_Payment(label_id, timestamp, amount) values(?,?,?)";
		        PreparedStatement stmt1 = connection.prepareStatement(makeLabelPayment);
		        stmt1.setInt(1, label_id);
		        stmt1.setTimestamp(2, timestamp);
		        stmt1.setDouble(3, label_payment);
		        stmt1.executeUpdate();
		        String makeStatusPaid = "update Song_month_count set royalty_paid=1 where song_id=? and timestamp=?";
		        PreparedStatement stmt2 = connection.prepareStatement(makeStatusPaid);
		        stmt2.setInt(1, song_ID);
		        stmt2.setTimestamp(2, timestamp);
		        stmt2.executeUpdate();
		        System.out.println("Record Label Payment of " + label_payment +" done"+ " to Record Label " +(label_id));
		        String getSongArtist = "select artist_id from Artist_contributes where song_id=?";
		        PreparedStatement stmt3 = connection.prepareStatement(getSongArtist);
		        stmt3.setInt(1, song_ID);
				ResultSet res1 = stmt3.executeQuery();
				int no_of_artists=1;
				while(res1.next()) {
					String getArtistCount = "select COUNT(*) AS count from Artist_contributes where song_id=?";
			        PreparedStatement stmt5 = connection.prepareStatement(getArtistCount);
			        stmt5.setInt(1, song_ID);
			        ResultSet r = stmt5.executeQuery();
			        if(r.next()) {
						no_of_artists = r.getInt("count");			
			        }
					double individual_artist_payment = total_artist_payment/no_of_artists;
					System.out.println(individual_artist_payment);
					String makeArtistPayment = "insert into Artist_Payment(artist_id, timestamp, amount) values(?,?,?)";
			        PreparedStatement stmt4 = connection.prepareStatement(makeArtistPayment);
			        stmt4.setInt(1, res1.getInt("artist_id"));
			        stmt4.setTimestamp(2, timestamp);
			        stmt4.setDouble(3, individual_artist_payment);
			        stmt4.executeUpdate();
			        System.out.println("Artist payment of "+individual_artist_payment+" done to Artist "+res1.getInt("artist_id"));
				}
				
				
			}

			// commit if everything runs successfully
			connection.commit();
		} catch (Exception e) {
			try{
				// Rollback if errors
				connection.rollback();
			}
			catch(SQLException e1){
				try{
					// Set autoCommit back to true
					connection.setAutoCommit(true);
				}
				catch(SQLException e2){
					e2.printStackTrace();
				}

			}
			e.printStackTrace();		} finally {
			// Close PreparedStatement and Connection Objects.
			close(ps);
			close(stmt1);
			close(stmt2);
			close(connection);
		}
	}
	
	public static void makeAllSongPayments(int month, int year) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);

			String query = "select * from Song";

			ps = connection.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				int song_ID = res.getInt("song_ID");
				makePaymentGivenSong(song_ID, month, year);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
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
//		System.out.println("Please select an operation:\n1. Make Payment for a particular Song\n2. Make Payment for all songs given month");
//		int choice = scanner.nextInt();
//
//		switch (choice) {
//			case 1:
//				System.out.println("Please enter the song_ID: ");
//			    int song_ID = scanner.nextInt();
//			    System.out.println("Please enter the month(01-12) :");
//			    int month = scanner.nextInt();
//			    System.out.println("Please enter the year() :");
//			    int year = scanner.nextInt();
//			    makePaymentGivenSong(song_ID, month, year);
//				break;
//			case 2:
//			    System.out.println("Please enter the month(01-12) :");
//			    int month1 = scanner.nextInt();
//			    System.out.println("Please enter the year() :");
//			    int year1 = scanner.nextInt();
//			    makeAllSongPayments(month1, year1);
//				break;
//			default:
//				System.out.println("Invalid choice.");
//		}
//		
	}
}