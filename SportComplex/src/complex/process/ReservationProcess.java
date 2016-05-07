package complex.process;

import java.util.ArrayList;

import db.adapter.Date;
import db.adapter.DbRow;
import db.adapter.MemberSchedule;
import db.adapter.SportSchedule;
import db.adapter.TrainerSchedule;

public class ReservationProcess extends Process {

	ReservationProcess() {

	}

	public void reserveSportWithTrainer(Date d, String member, String trainerID, String sport,
			String saloon) {/*
							 * -reserveSportWithTrainer metodu parametre olarak
							 * date, member id, trainer id, sport id, saloon
							 * name bilgilerini al�r bu bilgiler memberSchedule
							 * bilgilerinin ilgili yerlerine set edilir ve
							 * addRow metoduyla veritaban�na eklenir ayn�
							 * bilgiler kullan�larak trainer ve member schedule
							 * daki member name bilgilerine eklenerek... (ekleme
							 * i�lemi i�in �nce member fielddaki veriyi �ek
							 * member bilgisini ekle sonra tekrar set et) ...
							 * DbTable.update(ilgili id) metoduyla ilgili
							 * sat�rlar update edilir.
							 */

		MemberSchedule ms = new MemberSchedule(member); // schedullar her
														// ki�iye(member,
														// trainer, sport) �zel
														// oldu�u i�in id siyle
														// a��lmal�

		ms.setSaloonName(saloon);
		ms.setSportName(sport);
		ms.setTrainerName(trainerID);
		ms.setDate(d);
		try {
			ms.addRow(); // ayn� �ekilde di�er insert metodlar� i�in de bunun
							// yap�lmas� laz�m
		} catch (Exception e) {
			e.printStackTrace();
		}

		TrainerSchedule ts = new TrainerSchedule(trainerID); // trainer schedule
																// �ekildi
		ArrayList<DbRow> row = searchOnTable(d.toString() + sport, trainerID); // ilgili
																				// bilgilerin
																				// bulundu�u
																				// rowlar
																				// �ekildi
		ts.parseString(row.get(0).getAttr()); // al�nan row bilgisinin attr
												// bilgisi trainer schedule
												// memberfield�na cache olarak
												// kullan�labilmesi i�inparse
												// edildi
		ts.getMembers().add(member); // member idsi arrayliste eklendi
		try {
			ts.update("where searchValues like %" + row.get(0).getSearchValues() + "%");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // al�nan
																						// row
																						// un
																						// searchValues
																						// de�eri
																						// ile
																						// ayn�
																						// yerde
																						// olan
																						// row,
																						// member
																						// fieldda
																						// bulunan
																						// verilerle
																						// update
																						// edildi

		// trainer schedule a veri ekleme mevzusu yok sadece member bilgisini update ediyoruz.
		// sport schedule update inin bu bilgilere g�re tekrar yap�lmas� gerekiyor
		
		SportSchedule ss = new SportSchedule(sport);
		ArrayList<DbRow> srow= searchOnTable(d.toString() + sport, sport);

		ss.parseString(srow.get(0).getAttr());
		ss.getMemberNames().add(member);
		try{
			ss.update("where searchValues like %" +srow.get(0).getSearchValues() + "%");
		}
		catch (Exception e1){
			e1.printStackTrace();
		}
	}

	public void reserveSportSelf(Date d, String member, String sport, String saloon) {
		MemberSchedule ms = new MemberSchedule("memberschedule");
		ms.setSaloonName(saloon);
		ms.setSportName(sport);
		ms.setDate(d);
		try {
			ms.addRow(); // ayn� �ekilde di�er insert metodlar� i�in de bunun
							// yap�lmas� laz�m
		} catch (Exception e) {
			e.printStackTrace();
		}
		SportSchedule ss = new SportSchedule(sport);
		ArrayList<DbRow> srow= searchOnTable(d.toString() + sport, sport);

		ss.parseString(srow.get(0).getAttr());
		ss.getMemberNames().add(member);
		try{
			ss.update("where searchValues like %" +srow.get(0).getSearchValues() + "%");
		}
		catch (Exception e1){
			e1.printStackTrace();
		}
	}
}