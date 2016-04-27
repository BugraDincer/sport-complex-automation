package complex.process;

import java.util.ArrayList;

import db.adapter.DbProcess;
import db.adapter.MemberList;
import db.adapter.Report;
import db.adapter.SportList;
import db.adapter.TrainerList;

public class Process {
	private MemberList memberList = new MemberList();
	private SportList sportList = new SportList();
	private TrainerList trainerList = new TrainerList();
	private Report report = new Report();
	private DbProcess db = new DbProcess();

	Process() {

	}

	/*
	 * - searchOnTable metodu istenen table içinde veya memberfielddaki
	 * tablolarda search values sütununa göre arama yapar bulunan verilerin
	 * attribute sütunundaki verileri array list içinde döndürür
	 */
	public ArrayList<String> searchOnTable(String searchKey, String tableName) {
		return null;
	}

}
