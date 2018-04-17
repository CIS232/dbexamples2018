import java.sql.*;

public class CoffeeInserter {

	final static public String DB_URL = "jdbc:h2:./CoffeeDB";

	public static void main(String[] args) throws SQLException{
		Connection conn = DriverManager.getConnection(DB_URL);
		insertCoffee(conn, "25-001", 5.00, "');DELETE FROM COFFEE;--");
		insertCoffee(conn, "24-001", 4.00, "Maryland Crab Brew Decaf");
		insertCoffee(conn, "24-002", 6.00, "Maryland Crab Brew");
		insertCoffee(conn, "26-001", 4.00, "Shelly's Magic Brew");
	}

	public static int insertCoffee(Connection conn, String prodNum, double price, String description) throws SQLException{
		String sql = "INSERT INTO Coffee(ProdNum, Price, Description) VALUES (?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, prodNum);
		stmt.setDouble(2, price);
		stmt.setString(3, description);

		return stmt.executeUpdate();
	}
}
