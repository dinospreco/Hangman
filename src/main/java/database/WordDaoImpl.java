package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WordDaoImpl implements WordDao {
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public void getCategory() throws SQLException {
		String query = "Select * from Words order by RAND() LIMIT 1";
		ResultSet rs = null;
		Statement statement = (Statement) connection.createStatement();
		rs = ((java.sql.Statement) statement).executeQuery(query);

		System.out.println(rs.getString("category"));
		rs.close();

	}

	@Override
	public void getWord() throws SQLException {
		String query = "Select * from Words order by RAND() LIMIT 1";
		ResultSet rs = null;
		Statement statement = (Statement) connection.createStatement();
		rs = ((java.sql.Statement) statement).executeQuery(query);

		System.out.println(rs.getString("word"));
		rs.close();
	}

}
