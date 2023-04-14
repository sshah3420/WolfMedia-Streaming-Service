import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;

public class PodcastHostInfoApi {
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";
	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static PreparedStatement ps2 = null;
	public static ResultSet rs = null;
	
	public static void enterPodcastHostInfo(int memberId, String firstName, String lastName, String country, String email, String phone, String city) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			
			System.out.println(connection);
			

			String insertSql = "INSERT INTO Members (member_id, first_name, last_name, country, email, phone) VALUES (" + memberId + ", '" + firstName + "', '" + lastName + "', '" + country + "', '" + email + "', '" + phone + "')";
			// make autoCommit false
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(insertSql);
			System.out.println("Member insert successful");

			ps.executeUpdate();

			String insertSql2 = "INSERT INTO Host (member_id, city) VALUES (" + memberId + ", '" + city + "')";
			ps = connection.prepareStatement(insertSql2);
			System.out.println("Host insert successful");
			
			ps.executeUpdate();
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
		} finally {
			close(ps);
			close(connection);
		}
	}

	
	public static void updatePodcastHostInfo(int member_Id, String column, Object value) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);
			String updateSql = null;
			if (column.equals("first_name") || column.equals("last_name") || column.equals("country") || column.equals("email") || column.equals("phone")) {
				updateSql = "UPDATE Members SET " + column + " = '" + value + "' WHERE member_id = " + member_Id;
				stmt = connection.createStatement();
				stmt.execute(updateSql);
			}
			else {
				updateSql = "UPDATE Host SET " + column + " = '" + value + "' WHERE member_id = " + member_Id;
				stmt = connection.createStatement();
				stmt.execute(updateSql);

			}
			
			System.out.println("Host updated.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(connection);
		}
	}
	
	
	public static void deletePodcastHostInfo(int member_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, user, password);

			String deleteSql = "DELETE FROM Members WHERE member_id = " + member_id;
			stmt = connection.createStatement();
			stmt.executeUpdate(deleteSql);
			System.out.println("Host Deleted.");
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
//		System.out.println("Please select an operation:\n1. Insert Host info\n2. Update Host info\n3. Delete Host info");
//		int choice = scanner.nextInt();
//
//		switch (choice) {
//			case 1:
//				System.out.println("Please enter the member ID:");
//			    int memberId = scanner.nextInt();
//			    System.out.println("Please enter the first name:");
//			    String firstName = scanner.next();
//			    System.out.println("Please enter the last name:");
//			    String lastName = scanner.next();
//			    System.out.println("Please enter the country:");
//			    String country = scanner.next();
//			    System.out.println("Please enter the email:");
//			    String email = scanner.next();
//			    System.out.println("Please enter the phone number:");
//			    String phone = scanner.next();
//			    System.out.println("Please enter the City:");
//			    String city = scanner.next();
//				enterPodcastHostInfo(memberId, firstName, lastName, country, email, phone, city);
//				break;
//			case 2:
//				System.out.println("Please enter the Member ID: ");
//			    int member_Id = scanner.nextInt();
//			    System.out.println("Please enter the column name you want to edit: ");
//			    String column = scanner.next();
//			    System.out.println("Please enter the Value for the column: ");
//			    Object value = scanner.next();
//				updatePodcastHostInfo(member_Id, column, value );
//				break;
//			case 3:
//				System.out.println("Please enter the Member ID: ");
//			    int member_Id2 = scanner.nextInt();
//				deletePodcastHostInfo(member_Id2);
//				break;
//			default:
//				System.out.println("Invalid choice.");
//		}
//		
	}
}