import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowCoffeeDescriptionsScrollableUpdateable {

	public static void main(String[] args) throws SQLException {
		final String DB_URL = "jdbc:h2:./CoffeeDB";

		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet cursor = stmt.executeQuery("SELECT Description FROM COFFEE");

		while(cursor.next()){
			System.out.println(cursor.getString("Description"));
		}
		System.out.println("Now back to the last!");
		cursor.last();
		String origDescription = cursor.getString("Description");
		cursor.updateString("Description", "Last " + origDescription);
		System.out.println(cursor.getString("Description"));

		conn.close();
	}
}
