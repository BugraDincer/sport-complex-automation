package db.adapter;

public class Report extends DbTable {
	private int inOutAmount;
	private String explanation, source;
	private Date date;
	private static final String tableName = "report";

	public Report() {
		super(tableName, null);
	}

	@Override
	public void addRow() throws Exception {
		String searchValues = this.source;
		super.getDb().insert(tableName, date.toString(), searchValues, this.toString());
		super.getRows().add(new DbRow(date.toString(), searchValues, this.toString()));
	}

	@Override
	public String toString() {
		String str = date.toString() + "|" + source + "|" + explanation + "|" + Integer.toString(inOutAmount);
		return str;
	}

	@Override
	public void parseString(String str) {
		String[] tokens = str.split("|");
		date.parseString(tokens[0]);
		source = tokens[1];
		explanation = tokens[2];
		inOutAmount = Integer.parseInt(tokens[3]);
	}

	// GETTERS & SETTERS
	public int getInOutAmount() {
		return inOutAmount;
	}

	public void setInOutAmount(int inOutAmount) {
		this.inOutAmount = inOutAmount;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
