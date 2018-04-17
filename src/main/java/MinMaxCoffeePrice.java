import java.sql.*;

public class MinMaxCoffeePrice {

	// Create a named constant for the URL.
	// NOTE: This value is specific for H2.
	public final static String DB_URL = "jdbc:h2:./CoffeeDB";

	public static void main(String[] args) throws SQLException{
		Connection conn = DriverManager.getConnection(DB_URL);

		double maxPrice = getFirstDoubleFromSQL(conn, "SELECT MAX(Price) FROM Coffee");
		double minPrice = getFirstDoubleFromSQL(conn, "SELECT MIN(Price) FROM Coffee");
		double avgPrice = getFirstDoubleFromSQL(conn, "SELECT AVG(Price) FROM Coffee");

		System.out.printf("MAX: $%.2f%n", maxPrice);
		System.out.printf("MIN: $%.2f%n", minPrice);
		System.out.printf("AVG: $%.2f%n", avgPrice);

		conn.close();
	}

	/**
	 * Useful for sql that returns a single double value in a single row. Assumes the first value is a double.
	 * Returns 0 by default.
	 * @param conn An open connection to a dbms.
	 * @param sql an SQL statement to be sent to the database, typically a
	 *              static SQL <code>SELECT</code> statement. Should only query for one double value.
	 * @return The double value or 0 if there are no results.
	 * @throws SQLException when a statement cannot be created.
	 */
	public static double getFirstDoubleFromSQL(Connection conn, String sql) throws SQLException{
		Statement statement = conn.createStatement();
		ResultSet cursor = statement.executeQuery(sql);
		double value = 0;
		if(cursor.next()){
			value = cursor.getDouble(1);
		}
		return value;
	}

}
