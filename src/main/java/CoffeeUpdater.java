import java.sql.*;

public class CoffeeUpdater {
	final static public String DB_URL = "jdbc:h2:./CoffeeDB";

	public static void main(String[] args) throws SQLException{
		Connection conn = DriverManager.getConnection(DB_URL);

		int rowCount = updateCoffee(conn, "14-001", 5, "Bolivian Sale Coffee");

		System.out.printf("Updates %d row(s)%n", rowCount);
		conn.close();
	}

	/**
	 * Updates a coffee's price and description at the specified product number
	 * @param conn An open database connection
	 * @param prodNum Product number of coffee you'd like to update
	 * @param price New price for the coffee
	 * @param description New description for the coffee
	 * @return the number of rows updated
	 * @throws SQLException if there was a problem with the sql
	 */
	public static int updateCoffee(Connection conn, String prodNum, double price, String description) throws SQLException{
		String sql = "UPDATE Coffee SET Price = ?, Description = ? WHERE ProdNum = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, price);
		stmt.setString(2, description);
		stmt.setString(3, prodNum);

		return stmt.executeUpdate();
	}
}
