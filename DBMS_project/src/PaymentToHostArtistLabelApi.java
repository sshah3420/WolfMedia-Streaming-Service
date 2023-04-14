import java.sql.*;
//import java.util.Scanner;
import java.time.LocalDateTime;

public class PaymentToHostArtistLabelApi  {

	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static void paidToHost(int host_id, int startMonth, int startYear, int endMonth, int endYear) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			
			LocalDateTime startDate = LocalDateTime.of(startYear, startMonth, 1, 0, 0, 0);
	        Timestamp startTime = Timestamp.valueOf(startDate);   
			LocalDateTime endDate = LocalDateTime.of(endYear, endMonth, 30, 0, 0, 0);
	        Timestamp endTime = Timestamp.valueOf(endDate);

			String temp = "SELECT SUM(amount) FROM Podcast_payment where host_id = ? and timestamp >= ? and timestamp < ?";
			
			PreparedStatement stmt = connection .prepareStatement(temp);
			stmt.setInt(1, host_id);
			stmt.setTimestamp(2, startTime);
			stmt.setTimestamp(3, endTime);

			int sum = 0;
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			    sum = rs.getInt(1);
			}
			
			System.out.println(sum);
			rs.close();
			stmt.close();
			connection.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(connection);
		}
	}
	
	
	public static void paidToArtist(int artist_id, int startMonth, int startYear, int endMonth, int endYear) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			
			LocalDateTime startDate = LocalDateTime.of(startYear, startMonth, 1, 0, 0, 0);
	        Timestamp startTime = Timestamp.valueOf(startDate);      
			LocalDateTime endDate = LocalDateTime.of(endYear, endMonth, 30, 0, 0, 0);
	        Timestamp endTime = Timestamp.valueOf(endDate);

			String temp = "SELECT SUM(amount) FROM Artist_Payment where artist_id = ? and timestamp >= ? and timestamp < ?";
			
			PreparedStatement stmt = connection .prepareStatement(temp);
			stmt.setInt(1, artist_id);
			stmt.setTimestamp(2, startTime);
			stmt.setTimestamp(3, endTime);

			int sum = 0;
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			    sum = rs.getInt(1);
			}
			
			System.out.println(sum);
			rs.close();
			stmt.close();
			connection.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(connection);
		}
	}
	
	public static void paidToLabel(int label_id, int startMonth, int startYear, int endMonth, int endYear) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			
			LocalDateTime startDate = LocalDateTime.of(startYear, startMonth, 1, 0, 0, 0);
	        Timestamp startTime = Timestamp.valueOf(startDate);	        
			LocalDateTime endDate = LocalDateTime.of(endYear, endMonth, 30, 0, 0, 0);
	        Timestamp endTime = Timestamp.valueOf(endDate);

			String temp = "SELECT SUM(amount) FROM RecordLabel_Payment where label_id = ? and timestamp >= ? and timestamp < ?";
			
			PreparedStatement stmt = connection .prepareStatement(temp);
			stmt.setInt(1, label_id);
			stmt.setTimestamp(2, startTime);
			stmt.setTimestamp(3, endTime);

			int sum = 0;
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
			    sum = rs.getInt(1);
			}
			
			System.out.println(sum);
			rs.close();
			stmt.close();
			connection.close();
			
			
			
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
//			Scanner scanner = new Scanner(System.in);
//			int roleChoice = -1;
//			System.out.println("Please enter period:");
//			System.out.println("Enter start month:");
//			int startMonth = Integer.parseInt(scanner.nextLine());
//			System.out.println("Enter start year:");
//			int startYear = Integer.parseInt(scanner.nextLine());
//			System.out.println("Enter end month:");
//			int endMonth = Integer.parseInt(scanner.nextLine());
//			System.out.println("Enter end year:");
//			int endYear = Integer.parseInt(scanner.nextLine());
//			
//			System.out.println("Please enter 1.Host 2.Artist 3.Label:");
//			int choice = scanner.nextInt();
//			switch(choice) {
//				case 1:
//					System.out.println("Enter Host Id to fetch payment record:");
//					int host_id = scanner.nextInt();
//					paidToHost(host_id,startMonth,startYear,endMonth,endYear);
//					break;
//					
//					
//				case 2:
//					System.out.println("Enter Artist Id to fetch payment record:");
//					int artist_id = scanner.nextInt();
//					paidToArtist(artist_id,startMonth,startYear,endMonth,endYear);
//					break;
//					
//					
//				case 3:
//					System.out.println("Enter Label Id to fetch payment record:");
//					int label_id = scanner.nextInt();
//					paidToLabel(label_id,startMonth,startYear,endMonth,endYear);
//					break;
//				
//				default:
//					System.out.println("Invalid choice.");
//
//					
//			}
			
			
			
//			
			
			
		}
		



}
