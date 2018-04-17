import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoffeeDeleter {
	final static public String DB_URL = "jdbc:h2:./CoffeeDB";

	public static void main(String[] args) throws SQLException{
		Connection conn = DriverManager.getConnection(DB_URL);

		int rowCount = deleteCoffee(conn, "14-001");

		System.out.printf("Deleted %d row(s)%n", rowCount);
		conn.close();
	}

	/**
	 * Deletes a coffee at the specified product number
	 * @param conn An open database connection
	 * @param prodNum Product number of coffee you'd like to delete
	 * @return the number of rows deleted
	 * @throws SQLException if there was a problem with the sql
	 */
	public static int deleteCoffee(Connection conn, String prodNum) throws SQLException{
		String sql = "DELETE FROM Coffee WHERE ProdNum = ?";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, prodNum);

		return stmt.executeUpdate();
	}
}
