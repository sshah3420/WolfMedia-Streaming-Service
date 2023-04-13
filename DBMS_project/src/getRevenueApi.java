import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class getRevenueApi {
    private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static PreparedStatement ps2 = null; 
	public static ResultSet rs = null;
	public static ResultSet rs1 = null;

	public static void getRevenuePerMonth(int month) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "SELECT revenue from revenue where month(month) = ?";
			ps = connection.prepareStatement(insertSql);
            ps.setInt(1, month);
			ResultSet rs1 = ps.executeQuery();
			 while (rs1.next()) {
	                double revenue = rs1.getInt("revenue");
	                System.out.println("Revenue: " + revenue);
	            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection Objects.
			close(ps);
			close(connection);
		}
	}
	public static void getRevenuePerYear(int year) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "SELECT SUM(revenue) as total_revenue from revenue WHERE YEAR(month) = ?";
			ps = connection.prepareStatement(insertSql);
            ps.setInt(1, year);
			ResultSet rs1 = ps.executeQuery();
			 while (rs1.next()) {
	                double revenue = rs1.getInt("total_revenue");
	                System.out.println("Revenue: " + revenue);
	            }
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
		// getRevenuePerMonth(4);
//		getRevenuePerYear(2023);
		System.out.println("Hello");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please select an operation:\n1. Get revenue by Month\n2. Get revenue by year");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				System.out.println("Please enter the Month");
			    int month = scanner.nextInt();
			    getRevenuePerMonth(month);
				break;
			case 2:
				System.out.println("Please enter the year");
				int year = scanner.nextInt();
				getRevenuePerYear(year);
				break;
			default:
				System.out.println("Invalid choice.");
		}

	}


}
