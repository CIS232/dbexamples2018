import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowDescriptionAndPrices {

	public static void main(String[] args) throws SQLException {
		final String DB_URL = "jdbc:h2:./CoffeeDB";

		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		ResultSet cursor = stmt.executeQuery("SELECT Description, Price FROM COFFEE WHERE Price > 12.00");

		//Could use this method that we wrote on April 16th:
		//MetaDataDemo.printResults(cursor);

		while(cursor.next()){
			System.out.println(cursor.getString("Description") + " " +
					cursor.getString("Price"));
		}

		conn.close();
	}
}
