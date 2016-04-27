package db.adapter;

public class MemberSchedule extends DbTable {

	private Date date;
	private String sportName, trainerName, saloonName;

	MemberSchedule(String tableName) {
		super(tableName, null);
	}

	@Override
	public void addRow() throws Exception {
		String searchValues = this.trainerName + " " + this.sportName;
		super.getDb().insert(super.getTableName(), date.toString(), searchValues, this.toString());
		super.getRows().add(new DbRow(date.toString(), searchValues, this.toString()));
	}

	@Override
	public String toString() {
		String str = date.toString() + "|" + sportName + "|" + trainerName + "|" + saloonName;
		return str;
	}

	@Override
	public void parseString(String str) {
		String[] tokens = str.split("|");
		date.parseString(tokens[0]);
		sportName = tokens[1];
		trainerName = tokens[2];
		saloonName = tokens[3];
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

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getSaloonName() {
		return saloonName;
	}

	public void setSaloonName(String saloonName) {
		this.saloonName = saloonName;
	}

}
