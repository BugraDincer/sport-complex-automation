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
							 * name bilgilerini alýr bu bilgiler memberSchedule
							 * bilgilerinin ilgili yerlerine set edilir ve
							 * addRow metoduyla veritabanýna eklenir ayný
							 * bilgiler kullanýlarak trainer ve member schedule
							 * daki member name bilgilerine eklenerek... (ekleme
							 * iþlemi için önce member fielddaki veriyi çek
							 * member bilgisini ekle sonra tekrar set et) ...
							 * DbTable.update(ilgili id) metoduyla ilgili
							 * satýrlar update edilir.
							 */

		MemberSchedule ms = new MemberSchedule(member); // schedullar her
														// kiþiye(member,
														// trainer, sport) özel
														// olduðu için id siyle
														// açýlmalý

		ms.setSaloonName(saloon);
		ms.setSportName(sport);
		ms.setTrainerName(trainerID);
		ms.setDate(d);
		try {
			ms.addRow(); // ayný þekilde diðer insert metodlarý için de bunun
							// yapýlmasý lazým
		} catch (Exception e) {
			e.printStackTrace();
		}

		TrainerSchedule ts = new TrainerSchedule(trainerID); // trainer schedule
																// çekildi
		ArrayList<DbRow> row = searchOnTable(d.toString() + sport, trainerID); // ilgili
																				// bilgilerin
																				// bulunduðu
																				// rowlar
																				// çekildi
		ts.parseString(row.get(0).getAttr()); // alýnan row bilgisinin attr
												// bilgisi trainer schedule
												// memberfieldýna cache olarak
												// kullanýlabilmesi içinparse
												// edildi
		ts.getMembers().add(member); // member idsi arrayliste eklendi
		try {
			ts.update("where searchValues like %" + row.get(0).getSearchValues() + "%");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // alýnan
																						// row
																						// un
																						// searchValues
																						// deðeri
																						// ile
																						// ayný
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
		// sport schedule update inin bu bilgilere göre tekrar yapýlmasý gerekiyor
		
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
			ms.addRow(); // ayný þekilde diðer insert metodlarý için de bunun
							// yapýlmasý lazým
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