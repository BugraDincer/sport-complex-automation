package db.adapter;

import java.util.ArrayList;

public class TrainerSchedule extends DbTable {

	private Date date;
	private String sportName, saloon;
	private ArrayList<String> members = new ArrayList<String>();

	TrainerSchedule(String tableName) {
		super(tableName, null);
	}

	@Override
	public void addRow() throws Exception {
		String searchValues = sportName + " " + saloon;
		super.getDb().insert(super.getTableName(), date.toString(), searchValues, this.toString());
		super.getRows().add(new DbRow(date.toString(), searchValues, this.toString()));
	}

	@Override
	public String toString() {
		String str = date.toString() + "|" + sportName + "|" + saloon + "|" + this.arrayListToString(members);
		return str;
	}

	@Override
	public void parseString(String str) {
		String[] tokens = str.split("|");
		date.parseString(tokens[0]);
		sportName = tokens[1];
		saloon = tokens[2];
		this.stringToArrayList(tokens[3]);
	}

	// GETTERS & SETTERS
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getSaloon() {
		return saloon;
	}

	public void setSaloon(String saloon) {
		this.saloon = saloon;
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}

}
