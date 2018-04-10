import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowCoffeeDescriptions {

	public static void main(String[] args) throws SQLException {
		final String DB_URL = "jdbc:h2:./CoffeeDB";

		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		ResultSet cursor = stmt.executeQuery("SELECT Description FROM COFFEE");

		while(cursor.next()){
			System.out.println(cursor.getString("Description"));
		}

		conn.close();
	}
}
