import java.sql.*;
//import java.util.Scanner;
import java.time.LocalDateTime;

public class PodcastHostPayment {

	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void makeHostPayment(int host_id, int month, int year) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			String temp = "SELECT * FROM Episode where podcast_id in (SELECT podcast_ID from Podcast where podcast_ID in (Select podcast_ID from Podcast_Has_Host where member_ID = ?)) AND is_paid = 0";

			PreparedStatement stmt = connection .prepareStatement(temp, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			stmt.setInt(1, host_id);
			ResultSet rs = stmt.executeQuery();
			int totalPaymentAmount = 0;
			int queryLength = 0;
			while (rs.next()) {
				
				totalPaymentAmount = totalPaymentAmount + rs.getInt("bonus_rate")*rs.getInt("ad_count");
				queryLength = queryLength + 1;
				boolean isPaid = rs.getBoolean("is_paid");
				if (!isPaid) {
		            rs.updateBoolean("is_paid", true);
		            rs.updateRow();
		        }
			}
			
			totalPaymentAmount = totalPaymentAmount + (queryLength*10);
			
	        LocalDateTime ldt = LocalDateTime.of(year, month, 1, 0, 0, 0);

	        Timestamp timestamp = Timestamp.valueOf(ldt);

	        String makePayment = "INSERT INTO Podcast_payment (timestamp, amount, is_paid, host_id) values (?, ?, 1, ?)";
	        
	        PreparedStatement stmt1 = connection .prepareStatement(makePayment);
	        
	        stmt1.setTimestamp(1, timestamp);
	        stmt1.setInt(2, totalPaymentAmount);
	        stmt1.setInt(3, host_id);
	        
	        stmt1.executeUpdate();
	        
	        
	        
			
			
			
			
			
			System.out.println(totalPaymentAmount);
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
//			Scanner scanner = new Scanner(System.in);
//			int roleChoice = -1;
//			System.out.println("Hello");
//			System.out.print("Enter Host Id to make payment:");
//			int song_id = Integer.parseInt(scanner.nextLine());
//	        System.out.print("Enter a month (1-12): ");
//	        int month = scanner.nextInt();
//	        // Prompt the user to input a year
//	        System.out.print("Enter a year: ");
//	        int year = scanner.nextInt();
//	        
//	        System.out.println("You entered: " + month + "/" + year);
//	        makeHostPayment(song_id, month, year);
//			
			
			
		}
		



}
