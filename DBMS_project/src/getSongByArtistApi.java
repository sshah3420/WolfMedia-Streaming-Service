public import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
//gets songs by Artist_id
public class getSongByArtistApi {
	
    public public static void getSongsbyArtist(String column, Object value) {
        try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Get Connection object.
			connection = DriverManager.getConnection(jdbcURL, user, password);
			System.out.println(connection);

			
			String insertSql = " select res.artist_id,Song.song_id,Song.title,Song.album_id,Song.play_count from (select * from Artist_contributes where artist_id = " + value +") res join Song on res.song_id = Song.song_id;";
			ps = connection.prepareStatement(insertSql);			
			
			rs1 = ps.executeQuery();
			System.out.println("artist_id song_id, title, album_id, play_count");
			while(rs1.next()) {
				System.out.print(rs1.getString(1) + " ");
				System.out.print(rs1.getString(2) + " ");
				System.out.print(rs1.getString(3) + " ");
				System.out.print(rs1.getString(4) + " ");
				System.out.println(rs1.getString(5));
				
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

                System.out.println("Hello");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the Artist ID:");
                int artistId = scanner.nextInt();
                getSongsbyArtist(artistId);

            }
} 