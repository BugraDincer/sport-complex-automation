package complex.process;

import db.adapter.Date;
import db.adapter.DbProcess;
import db.adapter.DbTable;
import db.adapter.MemberList;
import db.adapter.SportList;
import db.adapter.TrainerList;
import db.adapter.Report;
import db.adapter.Schedule;

public class ManagementProcess extends Process {
	
	protected String searchKey;
	protected PaymentProcess paymentP = new PaymentProcess();
	protected ReservationProcess reservationP = new ReservationProcess();
	protected TrainerProcess trainerP = new TrainerProcess();
	protected UiProcess uiP = new UiProcess();
	
	ManagementProcess() {
		
	}

	/*
	 * -insert metodlari alinan parametre degerlerine gore ilgili listeye bakip
	 * id degerinin var olup olmadigini kontrol eder ayni id ye ait bir satir
	 * yoksa parametre degerlerini setter metodlariyla ilgili listeye atar
	 * ...List.addRow metodunu kullanarak elemani ilgili listeye ekler ayrica
	 * aldigi id degeriyle yeni bir schedule tablosu olusturur.
	 * dbProcess.createTable metoduyla
	 */
	public void insertMember(String name, String id, String birthYear, String address, String phoneNumber,
			String healthState, int debt, int trainingCount, boolean canReserve) {
		if(searchOnTable(id,"memberlist") == null) { // id sine göre memberlistte arama yapalým mesela
			//memberList.addRow(); bunu en sonra ekleyelim çünkü bu metod memberfielddaki verileri alýp bir row oluþturuyo
			//ilk önce member fieldi set etmezsek önceki verileri row yapýp veri tabanýna ekler 
			memberList.setName(name);
			memberList.setId(id);
			memberList.setBirthYear(birthYear);
			memberList.setAddress(address);
			memberList.setPhoneNumber(phoneNumber);
			memberList.setHealthState(healthState);
			memberList.setDebt(debt);
			memberList.setCanReserve(canReserve);
			try {
				memberList.addRow(); // ayný þekilde diðer insert metodlarý için de bunun yapýlmasý lazým
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Bu uye zaten var !");
		}

	}

	public void insertSport(String name, String id, String saloons, String healthRequirement, int trainerCount,
			int memberCount, int seanceCount) {
		if(searchOnTable(searchKey,"sportlist") == null){
			sportList.setName(name);
			sportList.setId(id);
			sportList.setSaloons(saloons);
			sportList.setHealthRequirement(healthRequirement);
			sportList.setTrainerCount(trainerCount);
			sportList.setMemberCount(memberCount);
			try {
				sportList.addRow(); // ayný þekilde diðer insert metodlarý için de bunun yapýlmasý lazým
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Bu spor zaten var !");
		}

	}

	public void insertTrainer(String name, String id, String birthYear, String address, String phoneNumber,
			String certificates, int memberCount, int salary, int workingTime) {
		if(searchOnTable(searchKey,"trainerlist") == null){
			trainerList.setName(name);
			trainerList.setId(id);
			trainerList.setBirthYear(birthYear);
			trainerList.setAddress(address);
			trainerList.setPhoneNumber(phoneNumber);
			trainerList.setCertificates(certificates);
			trainerList.setMemberCount(memberCount);
			trainerList.setSalary(salary);
			trainerList.setWorkingTime(workingTime);
			try {
				trainerList.addRow(); // ayný þekilde diðer insert metodlarý için de bunun yapýlmasý lazým
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Bu calistirici zaten var !");
		}


	}

	/*
	 * -update metodlari alinan parametre degerlerine gore ilgili listeden
	 * ilglili dbRow objesi secilir objenin attr degeri parse edilir
	 * updateAttribute degerine gore switch-case kullanilarak updateValue
	 * parametresi ilgili yere yazilir ...List.update metodu kullanilarak update
	 * edilir
	 */
	public void updateMember(String id, String updateAttribute, String updateValue) {
		if(searchOnTable(id,"memberlist") != null){
			
			    if(memberList.getAttr() == memberList.getName()) {    //switch constans deger aldigi icin burada calismiyor
			    	memberList.setName(updateValue); 
			    }else if (memberList.getAttr() == memberList.getId()) {
			    	memberList.setId(updateValue); 
			    }else if (memberList.getAttr() == memberList.getBirthYear()) {
			    	memberList.setBirthYear(updateValue); 
			    }else if (memberList.getAttr() == memberList.getAddress()) {
			    	memberList.setAddress(updateValue); 
			    }else if (memberList.getAttr() == memberList.getPhoneNumber()) {
			    	memberList.setPhoneNumber(updateValue); 
			    }else if (memberList.getAttr() == memberList.getHealthState()) {
			    	memberList.setHealthState(updateValue); 
			    }else if (memberList.getAttr() == memberList.getDebt()) {
			    	memberList.setDebt(updateValue); 
			    }else if (memberList.getAttr() == memberList.isCanReserve()) {
			    	memberList.setCanReserve(updateValue); 
			    }else {
			    	System.out.println("Yanlis secim.");
			    }
		}
		else {
			System.out.println("Uye bulunamadi.");
		}

	}

	public void updateSport(String id, String updateAttribute, String updateValue) {
		if(searchOnTable(id,"sportlist") != null){
			if(sportList.getAttr() == sportList.getName()) {  
				sportList.setName(updateValue); 
		    }else if (sportList.getAttr() == sportList.getId()) {
		    	sportList.setId(updateValue); 
		    }else if (sportList.getAttr() == sportList.getSaloons()) {
		    	sportList.setSaloons(updateValue); 
		    }else if (sportList.getAttr() == sportList.getHealthRequirement()) {
		    	sportList.setHealthRequirement(updateValue); 
		    }else if (sportList.getAttr() == sportList.getTrainerCount()) {
		    	sportList.setTrainerCount(updateValue); 
		    }else if (sportList.getAttr() == sportList.getMemberCount()) {
		    	sportList.setMemberCount(updateValue); 
		    }else {
		    	System.out.println("Yanlis secim.");
		    }
		}
		else {
			System.out.println("Spor bulunamadi.");
		}

	}

	public void updateTrainer(String id, String updateAttribute, String updateValue) {
		if(searchOnTable(id,"trainerlist") != null){
			trainerList.update(updateAttribute,updateValue);	//update methodu bunlar icin gecerli olmayabilir
															    //gecerliyse sikinti yok, degilse getter&setterlar 
															    //kullanilarak yapilabilir.
		}
		else {
			System.out.println("Calistirici bulunamadi.");
		}

	}

	/*
	 * -delete metodlari alinan id degeri member ve trainer metodunda herhangi
	 * bir borcu veya icerde kalan parasi var mi kontrol edilir kontrolden
	 * gecerse isleme devam edilir ve true dondurur gecemezse false dondurur
	 * ...List.delRow metodu kullanilarak listedeki deger silinir
	 * dbProcess.dropTable metodu kullanilarak ilgili id deki schedule tablosu
	 * drop edilir
	 */
	public void deleteMember(String id) {
		if(searchOnTable(id,"memberlist") != null) {
			if(paymentP.checkMemberPayment(id)) {
				try {
					memberList.delRow(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    }
	}

	public void deleteSport(String id) {
		if(searchOnTable(id,"sportlist") != null) {
			try {
				sportList.delRow(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteTrainer(String id) {
		if(searchOnTable(id,"trainerlist") != null) {
			if(paymentP.checkTrainerPayment(id)) {
				try {
					trainerList.delRow(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


	/*
	 * -schedule metodlari alinan id parametresi icin ilgili schedule nesnesini
	 * olusturur alinan tarih ve salon parametreleri schedule nesnesine a set
	 * edilir ...Schedule.addRow metoduyla schedule tablosuna eklenir
	 */
	public void scheduleSport(String id, Date date, String saloon) {
		Schedule schedule = new Schedule();     //db deki schedule classi bos, burasi sonra yapilacak

	}

	public void scheduleTrainer(String id, Date date, String sportName, String saloon) {
		Schedule schedule = new Schedule();		//db deki schedule classi bos, burasi sonra yapilacak
	}
}