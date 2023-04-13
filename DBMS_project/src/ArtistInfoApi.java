import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ArtistInfoApi {
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";
	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static PreparedStatement ps2 = null;
	public static ResultSet rs = null;
	
	public static void enterArtistInfo(int memberId, String firstName, String lastName, String country, String email, String phone, int labelId, String status, String type) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			
			System.out.println(connection);
			

			// Query to insert the record into Members table.
			String insertSql = "INSERT INTO Members (member_id, first_name, last_name, country, email, phone) VALUES (" + memberId + ", '" + firstName + "', '" + lastName + "', '" + country + "', '" + email + "', '" + phone + "')";
			ps = connection.prepareStatement(insertSql);
			System.out.println("Member insert successful");

			ps.executeUpdate();
			// Query to insert the record into Artists table.
			String insertSql2 = "INSERT INTO Artist (member_id, label_id, status, type) VALUES (" + memberId + ", " + labelId + ", '" + status + "', '" + type + "')";
			ps2 = connection.prepareStatement(insertSql2);
			System.out.println("Artist insert successful");
			
			ps2.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection Objects.
			close(ps);
			close(ps2);
			close(connection);
		}
	}

	
	public static void updateArtistInfo(int member_Id, String column, Object value) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			// Query to update the specified column in the Artist table.
			if (column.equals("first_name") || column.equals("last_name") || column.equals("country") || column.equals("email") || column.equals("phone")) {
				String updateSql = "UPDATE Members SET " + column + " = '" + value + "' WHERE member_id = " + member_Id;
				// Create Statement Object.
				stmt = connection.createStatement();
				// Execute the update query using Statement object.
				stmt.execute(updateSql);
			}
			else {
				String updateSql2 = "UPDATE Artist SET " + column + " = '" + value + "' WHERE member_id = " + member_Id;
				// Create Statement Object.
				stmt = connection.createStatement();
				// Execute the update query using Statement object.
				stmt.execute(updateSql2);

			}
			
			System.out.println("Artist updated.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close Statement and Connection Objects.
			close(stmt);
			close(connection);
		}
	}
	
	
	public static void deleteArtistInfo(int member_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);

			// Query to delete the record from ARTICLES table.
			String deleteSql = "DELETE FROM Artist WHERE member_id = " + member_id;
			// Create Statement Object.
			stmt = connection.createStatement();
			// Execute the delete query using Statement object.
			stmt.executeUpdate(deleteSql);
			System.out.println("Article Deleted.");
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
//		System.out.println("Please select an operation:\n1. Insert artist info\n2. Update artist info\n3. Delete artist info");
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
//			    System.out.println("Please enter the label ID:");
//			    int labelId = scanner.nextInt();
//			    System.out.println("Please enter the status (active/retired):");
//			    String status = scanner.next();
//			    System.out.println("Please enter the type(Band/musician/composer):");
//			    String type = scanner.next();
//				enterArtistInfo(memberId, firstName, lastName, country, email, phone, labelId, status, type);
//				break;
//			case 2:
//				System.out.println("Please enter the Member ID: ");
//			    int member_Id = scanner.nextInt();
//			    System.out.println("Please enter the column name you want to edit: ");
//			    String column = scanner.next();
//			    System.out.println("Please enter the Value for the column: ");
//			    Object value = scanner.next();
//				updateArtistInfo(member_Id, column, value );
//				break;
//			case 3:
//				System.out.println("Please enter the Member ID: ");
//			    int member_Id2 = scanner.nextInt();
//				deleteArtistInfo(member_Id2);
//				break;
//			default:
//				System.out.println("Invalid choice.");
//		}
//		
	}
}