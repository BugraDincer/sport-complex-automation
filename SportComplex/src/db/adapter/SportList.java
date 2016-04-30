package db.adapter;

public class SportList extends DbTable {

	private String name, id, saloons, healtRequirement;
	private int trainerCount, memberCount, seanceCount;
	private static final String tableName = "sportlist";

	public SportList() {
		super(tableName, null);
	}

	@Override
	public void addRow() throws Exception {
		String searchValues = this.name + " " + this.saloons;
		super.getDb().insert(tableName, this.id, searchValues, this.toString());
		super.getRows().add(new DbRow(this.id, searchValues, this.toString()));
	}

	@Override
	public String toString() {
		String str = id + "|" + name + "|" + saloons + "|" + healtRequirement + "|" + Integer.toString(trainerCount)
				+ "|" + Integer.toString(memberCount) + "|" + Integer.toString(seanceCount);
		return str;
	}

	@Override
	public void parseString(String str) {
		String[] tokens = str.split("\\|");
		this.id = tokens[0];
		this.name = tokens[1];
		this.saloons = tokens[2];
		this.healtRequirement = tokens[3];
		this.trainerCount = Integer.parseInt(tokens[4]);
		this.memberCount = Integer.parseInt(tokens[5]);
		this.seanceCount = Integer.parseInt(tokens[6]);
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

	public String getSaloons() {
		return saloons;
	}

	public void setSaloons(String saloons) {
		this.saloons = saloons;
	}

	public String getHealtRequirement() {
		return healtRequirement;
	}

	public void setHealtRequirement(String healtRequirement) {
		this.healtRequirement = healtRequirement;
	}

	public int getTrainerCount() {
		return trainerCount;
	}

	public void setTrainerCount(int trainerCount) {
		this.trainerCount = trainerCount;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

}
