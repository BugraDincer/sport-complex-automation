package db.adapter;

public class Date {
	int DD, MM, hs, ms;

	Date() {

	}

	Date(int DD, int MM, int hs, int ms) {
		this.DD = DD;
		this.MM = MM;
		this.hs = hs;
		this.ms = ms;
	}

	@Override
	public String toString() {
		String str = DD + "." + MM + "." + hs + "." + ms;
		return str;
	}

	public void parseString(String str) {
		String[] tokens = str.split(".");
		DD = Integer.parseInt(tokens[0]);
		MM = Integer.parseInt(tokens[1]);
		hs = Integer.parseInt(tokens[2]);
		ms = Integer.parseInt(tokens[3]);
	}

	// GETTERS && SETTERS
	public int getDD() {
		return DD;
	}

	public void setDD(int dD) {
		DD = dD;
	}

	public int getMM() {
		return MM;
	}

	public void setMM(int mM) {
		MM = mM;
	}

	public int getHs() {
		return hs;
	}

	public void setHs(int hs) {
		this.hs = hs;
	}

	public int getMs() {
		return ms;
	}

	public void setMs(int ms) {
		this.ms = ms;
	}

}
