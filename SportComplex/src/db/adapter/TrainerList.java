package db.adapter;

public class TrainerList extends DbTable {

	private String name, id, birthYear, address, phoneNumber, certificates;
	private int memberCount, salary, workingTime;
	private static final String tableName = "trainerList";

	public TrainerList() {
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
		String str = id + "|" + name + "|" + birthYear + "|" + address + "|" + phoneNumber + "|" + certificates + "|"
				+ Integer.toString(memberCount) + "|" + Integer.toString(salary) + "|" + Integer.toString(workingTime);
		return str;
	}

	@Override
	public void parseString(String str) {
		String[] tokens = str.split("\\|");
		this.id = tokens[0];
		this.name = tokens[1];
		this.birthYear = tokens[2];
		this.address = tokens[3];
		this.phoneNumber = tokens[4];
		this.certificates = tokens[5];
		this.memberCount = Integer.parseInt(tokens[6]);
		this.salary = Integer.parseInt(tokens[7]);
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

	public String getCertificates() {
		return certificates;
	}

	public void setCertificates(String certificates) {
		this.certificates = certificates;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(int workingTime) {
		this.workingTime = workingTime;
	}

}
