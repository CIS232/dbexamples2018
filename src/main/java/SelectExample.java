import java.sql.*;

public class SelectExample {

	public static void main(String[] args) throws SQLException {
		final String DB_URL = "jdbc:h2:./CoffeeDB";

		Connection conn = DriverManager.getConnection(DB_URL);
		Statement stmt = conn.createStatement();
		ResultSet cursor = stmt.executeQuery("SELECT * FROM COFFEE");

		while(cursor.next()){
			System.out.printf("%-25s  %10s  $%.2f%n",
					cursor.getString(1),
					cursor.getString(2),
					cursor.getDouble(3));

			//You could use column labels instead
			System.out.printf("%-25s  %10s  $%.2f%n",
					cursor.getString("Description"),
					cursor.getString("ProdNum"),
					cursor.getDouble("Price"));
		}

		conn.close();
	}
}
