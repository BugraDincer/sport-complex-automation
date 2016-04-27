package db.adapter;

public class MemberList extends DbTable {
	private String name, id, birthYear, address, phoneNumber, healthState;
	private int debt, trainingCount;
	private boolean canReserve;
	private static final String tableName = "memberlist";

	public MemberList() {
		super(tableName, null);
	}

	@Override
	public void addRow() throws Exception {
		String searchValues = this.name + " " + this.id;
		super.getDb().insert(tableName, this.id, searchValues, this.toString());
		super.getRows().add(new DbRow(this.id, searchValues, this.toString()));
	}

	@Override
	public String toString() {
		String str = id + "|" + name + "|" + birthYear + "|" + address + "|" + phoneNumber + "|" + healthState + "|"
				+ Integer.toString(debt) + "|" + Integer.toString(trainingCount) + "|" + Boolean.toString(canReserve);
		return str;
	}

	@Override
	public void parseString(String str) {
		String[] tokens = str.split("|");
		this.id = tokens[0];
		this.name = tokens[1];
		this.birthYear = tokens[2];
		this.address = tokens[3];
		this.phoneNumber = tokens[4];
		this.healthState = tokens[5];
		this.debt = Integer.parseInt(tokens[6]);
		this.trainingCount = Integer.parseInt(tokens[7]);
		this.canReserve = Boolean.parseBoolean(tokens[8]);
	}

	// GETTERS & SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHealthState() {
		return healthState;
	}

	public void setHealthState(String healthState) {
		this.healthState = healthState;
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	public boolean isCanReserve() {
		return canReserve;
	}

	public void setCanReserve(boolean canReserve) {
		this.canReserve = canReserve;
	}

	public static String getTablename() {
		return tableName;
	}

}
