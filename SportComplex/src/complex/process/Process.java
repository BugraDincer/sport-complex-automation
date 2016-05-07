package complex.process;

import java.util.ArrayList;
import db.adapter.DbProcess;
import db.adapter.DbRow;
import db.adapter.MemberList;
import db.adapter.Report;
import db.adapter.SportList;
import db.adapter.TrainerList;

public class Process {
	protected MemberList memberList = new MemberList();
	protected SportList sportList = new SportList();
	protected TrainerList trainerList = new TrainerList();
	private Report report = new Report();
	private DbProcess db = new DbProcess();

	Process() {
		/*
		memberList = db.select(memberlist);
		sportList = db.select(sportlist);
		trainerList = db.select(trainerlist);
		*/
	}

	/*
	 * - searchOnTable metodu istenen table icinde veya memberfield daki
	 * tablolarda search values sutununa gore arama yapar bulunan verilerin
	 * attribute sutunundaki verileri array list icinde dondurulur.
	 */
	public ArrayList<DbRow> searchOnTable(String searchKey, String tableName) {
		ArrayList<DbRow> s = new ArrayList<DbRow>(); 				// yeni bir row array listi olusturulur
		switch (tableName) {										//table name göre kullanilacak listeyi belirlemek için switch case kullanilir
		case "memberlist":
			for (DbRow d : memberList.getRows()) {					//ilgili member field daki tum rowlari cekerek d degiskenine atadim
				if (d.getSearchValues().contains(searchKey)) { 		// d row unun searchValues kisminda eger searchKey bulunuyorsa ...
					s.add(d);										//... bu row, olusturulan row array listine eklenir
				}
			}
			break;
			
		case "sportlist":
			for (DbRow d : sportList.getRows()) {
				if (d.getSearchValues().contains(searchKey)) {
					s.add(d);
				}
			}
			break;
			
		case "trainerlist":
			for (DbRow d : trainerList.getRows()) {
				if (d.getSearchValues().contains(searchKey)) {
					s.add(d);
				}
			}
			break;
			
		default : 
			break;
		}
		
		return s;
	}	

}