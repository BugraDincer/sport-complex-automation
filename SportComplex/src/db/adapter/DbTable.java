package db.adapter;

import java.util.ArrayList;

public abstract class DbTable {
	private String tableName;
	private String tablePointer_date, searchValues, attr;
	private ArrayList<DbRow> rows = new ArrayList<DbRow>();
	private DbProcess db = new DbProcess();

	DbTable(String tableName, ArrayList<DbRow> rows) {
		this.tableName = tableName;
		this.rows = rows;
		try {
			rows = db.select(tableName, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract String toString();

	public abstract void parseString(String str);

	public abstract void addRow() throws Exception;

	public void delRow(String where) throws Exception {
		db.delete(tableName, " where searchValues like %" + where + "%");
	}

	public void update(String where) throws Exception {
		db.update(tableName, tablePointer_date, searchValues, this.toString(),
				" where searchValues like %" + where + "%");
	}

	public void destructTable() {
		try {
			db.dropTable(tableName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("please do not use this object anymore because there is no db acces for it");
	}

	public String arrayListToString(ArrayList<String> l) {
		String str = null;
		for (String s : l) {
			str = str + s + ",";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}

	public ArrayList<String> stringToArrayList(String str) {
		ArrayList<String> al = new ArrayList<String>();
		String[] tokens = str.split(",");
		for (String s : tokens) {
			al.add(s);
		}
		return al;
	}

	// GETTERS & SETTERS
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTablePointer_date() {
		return tablePointer_date;
	}

	public void setTablePointer_date(String tablePointer_date) {
		this.tablePointer_date = tablePointer_date;
	}

	public String getSearchValues() {
		return searchValues;
	}

	public void setSearchValues(String searchValues) {
		this.searchValues = searchValues;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public ArrayList<DbRow> getRows() {
		return rows;
	}

	public void setRows(ArrayList<DbRow> rows) {
		this.rows = rows;
	}

	public DbProcess getDb() {
		return db;
	}

	public void setDb(DbProcess db) {
		this.db = db;
	}

}
