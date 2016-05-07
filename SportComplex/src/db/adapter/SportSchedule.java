package db.adapter;

import java.util.ArrayList;

public class SportSchedule extends DbTable {

	private Date date;
	private String saloon;
	private ArrayList<String> memberNames = new ArrayList<String>();
	private ArrayList<String> trainerNames = new ArrayList<String>();

	public SportSchedule(String tableName) {
		super(tableName, null);
	}

	@Override
	public void addRow() throws Exception {
		String searchValues = this.saloon;
		super.getDb().insert(super.getTableName(), date.toString(), searchValues, this.toString());
		super.getRows().add(new DbRow(date.toString(), searchValues, this.toString()));
	}

	@Override
	public String toString() {
		String str = date.toString() + "|" + saloon + "|" + this.arrayListToString(memberNames) + "|"
				+ this.arrayListToString(trainerNames);
		return str;
	}

	@Override
	public void parseString(String str) {
		String[] tokens = str.split("|");
		date.parseString(tokens[0]);
		this.saloon = tokens[1];
		this.memberNames = this.stringToArrayList(tokens[2]);
		this.trainerNames = this.stringToArrayList(tokens[3]);
	}

	// GETTERS & SETTERS
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSaloon() {
		return saloon;
	}

	public void setSaloon(String saloon) {
		this.saloon = saloon;
	}

	public ArrayList<String> getMemberNames() {
		return memberNames;
	}

	public void setMemberNames(ArrayList<String> memberNames) {
		this.memberNames = memberNames;
	}

	public ArrayList<String> getTrainerNames() {
		return trainerNames;
	}

	public void setTrainerNames(ArrayList<String> trainerNames) {
		this.trainerNames = trainerNames;
	}

}
