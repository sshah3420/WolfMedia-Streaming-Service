import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.mariadb.jdbc.client.result.ResultSetMetaData;

public class getSongsbyAlbumApi {
	
	private static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/sshah34";
	private static final String user = "sshah34";
	private static final String password = "200474707";

	public static Connection connection = null;
	public static Statement stmt = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	public static ResultSet rs1 = null;

    public static void getSongsbyAlbum(int value) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			String insertSql = "SELECT * FROM Song WHERE album_id = " + value + ";";
			ps = connection.prepareStatement(insertSql);
			
			
			ResultSet rs1 = ps.executeQuery();
			java.sql.ResultSetMetaData rsmd = rs1.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while(rs1.next()) {
				for(int i = 1; i <= columnsNumber; i++) {
					if (i > 1) System.out.print(",  ");
					System.out.print(rsmd.getColumnName(i));
				}
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
}
