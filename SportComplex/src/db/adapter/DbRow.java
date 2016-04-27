package db.adapter;

public class DbRow {
	private String tablePointer_date, searchValues, attr;

	DbRow(String t, String s, String a) {
		this.tablePointer_date = t;
		this.searchValues = s;
		this.attr = a;
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

}
