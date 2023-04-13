import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.Scanner;
//import java.time.LocalDateTime;


public class MakeUserSubscriberPaymentsApi {
    private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
    public static PreparedStatement ps2 = null;
	public static ResultSet rs = null;

    public static void makeUserSubscriberPayments(int user_id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);
			String insertSql = "INSERT INTO User_payment(user_id, amount, is_paid) VALUES (?,10,1);";
			ps = connection.prepareStatement(insertSql);
            ps.setInt(1, user_id);
			ps.executeUpdate();
            int currentMonth = Integer.parseInt(new java.text.SimpleDateFormat("MM").format(new java.util.Date()));
            String insertSql2 = "Update revenue set revenue = revenue + 10 where month(month) = ?;";
            ps2 = connection.prepareStatement(insertSql2);
            ps2.setInt(1, currentMonth);
            ps2.executeUpdate();

			System.out.println("Subscription Done");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
            close(ps2);
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
      
//                System.out.println("Hello");
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("Please enter the User ID:");
//                int userId = scanner.nextInt();
//
//                makeUserSubscriberPayments(userId);
            }

    
}
