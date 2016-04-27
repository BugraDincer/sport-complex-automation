package db.adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DbProcess {

	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String dbURL = "jdbc:derby:C:\\Users\\accumulator\\Desktop\\system analysis and design\\code\\db\\;create=true";

	public Connection connect() throws Exception {
		Class.forName(driver).newInstance();
		return DriverManager.getConnection(dbURL, null, null);
	}

	public void disconnect(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(String tableName, String tablePointer, String searchValues, String attr) throws Exception {
		String query = this.queryCreator("insert", tableName);
		Connection conn = this.connect();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, tablePointer);
		ps.setString(2, searchValues);
		ps.setString(3, attr);
		ps.executeUpdate();
		ps.close();
		this.disconnect(conn);
	}

	public ArrayList<DbRow> select(String tableName, String queryExtra) throws Exception {
		ArrayList<DbRow> strL = new ArrayList<DbRow>();
		DbRow row = new DbRow(null, null, null);
		String query = this.queryCreator("select", tableName);
		query = query + " " + queryExtra;
		Connection conn = this.connect();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			row.setTablePointer_date(rs.getString("tablePointer_date"));
			row.setSearchValues(rs.getString("searchValues"));
			row.setAttr(rs.getString("attr"));
			strL.add(row);
		}
		rs.close();
		ps.close();
		this.disconnect(conn);
		return strL;
	}

	public void update(String tableName, String tablePointer, String searchValues, String attr, String queryExtra)
			throws Exception {
		String query = this.queryCreator("update", tableName);
		query = query + " " + queryExtra;
		Connection conn = this.connect();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, tablePointer);
		ps.setString(2, searchValues);
		ps.setString(3, attr);
		ps.executeUpdate();
		ps.close();
		this.disconnect(conn);
	}

	public void delete(String tableName, String queryExtra) throws Exception {
		String query = this.queryCreator("delete", tableName);
		query = query + " " + queryExtra;
		Connection conn = this.connect();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.executeUpdate();
		ps.close();
		this.disconnect(conn);
	}

	public void createTable(String tableName) throws Exception {
		String query = this.queryCreator("createTable", tableName);
		Connection conn = this.connect();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.executeUpdate();
		ps.close();
		this.disconnect(conn);
	}

	public void dropTable(String tableName) throws Exception {
		String query = this.queryCreator("dropTable", tableName);
		Connection conn = this.connect();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.executeUpdate();
		ps.close();
		this.disconnect(conn);
	}

	public String queryCreator(String method, String tableName) {
		String query = null;
		switch (method) {
		case "insert":
			query = "insert into " + tableName + " (tablePointer_date , searchValues, attr) values (?, ?, ?) ";
			break;
		case "select":
			query = "select * from " + tableName + " ";
			break;
		case "update":
			query = "update " + tableName + "set tablePointer_date = ?, searchValues = ?, attr = ? ";
			break;
		case "delete":
			query = "delete from " + tableName + " ";
			break;
		case "createTable":
			query = "create table " + tableName
					+ " ( tablePointer_date varchar(128), searchValues varchar(128), attr varchar(1024) )";
			break;
		case "dropTable":
			query = "drop table " + tableName;
			break;
		default:
			break;
		}
		return query;
	}

}