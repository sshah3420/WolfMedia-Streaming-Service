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

	public static void getRevenuePerMonth() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "SELECT DATE_FORMAT(month, '%M') AS month_name, SUM(revenue) AS total_revenue FROM revenue GROUP BY month_name;";
			ps = connection.prepareStatement(insertSql);
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
					if (i > 1) System.out.print(":  ");
			        String columnValue = rs1.getString(i);
			        System.out.print(" " + columnValue);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close PreparedStatement and Connection Objects.
			close(ps);
			close(connection);
		}
	}

	
	public static void getRevenuePerYear() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "SELECT DATE_FORMAT(month, '%Y') AS month_name, SUM(revenue) AS total_revenue FROM revenue GROUP BY month_name;";
			
			ps = connection.prepareStatement(insertSql);
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
					if (i > 1) System.out.print(":  ");
			        String columnValue = rs1.getString(i);
			        System.out.print(" " + columnValue);
				}
				
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
		System.out.println("Please select an operation:\n1. Get revenue report - by Month\n2. Get revenue report - by year");
		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				System.out.println("Revenue per month is:");
			    getRevenuePerMonth();
				break;
			case 2:
				System.out.println("Revenue per year is:");
				getRevenuePerYear();
				break;
			default:
				System.out.println("Invalid choice.");
		}

	}


}
