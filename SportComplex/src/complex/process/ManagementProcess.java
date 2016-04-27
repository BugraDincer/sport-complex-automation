package complex.process;

import db.adapter.Date;

public class ManagementProcess extends Process {

	ManagementProcess() {

	}

	/*
	 * -insert metodları alınan parametre değerlerine göre ilgili liste ya bakıp
	 * id degerinin var olup olmadığını kontrol eder aynı id ye ait bir satır
	 * yoksa parametre değerlerini setter metodlarıyla ilgili listeye atar
	 * ...List.addRow metodunu kullanarak elemanı ilgili listeye ekler ayrıca
	 * aldığı id değeriyle yeni bir schedule tablosu oluşturur.
	 * dbProcess.createTable metoduyla
	 */
	public void insertMember(String name, String id, String birthYear, String address, String phoneNumber,
			String healthState, int debt, int trainingCount, boolean canReserve) {

	}

	public void insertSport(String name, String id, String saloons, String healtRequirement, int trainerCount,
			int memberCount, int seanceCount) {

	}

	public void insertTrainer(String name, String id, String birthYear, String address, String phoneNumber,
			String certificates, int memberCount, int salary, int workingTime) {

	}

	/*
	 * -update metodları alınan parametre degerlerine gore ilgili listeden
	 * ilglili dbRow objesi seçilir objenin attr değeri parse edilir
	 * updateAttribute degerine göre switch-case kullanılarak updateValue
	 * parametresi ilgili yere yazılır ...List.update metodu kullanılarak update
	 * edilir
	 */
	public void updateMember(String id, String updateAttribute, String updateValue) {

	}

	public void updateSport(String id, String updateAttribute, String updateValue) {

	}

	public void updateTrainer(String id, String updateAttribute, String updateValue) {

	}

	/*
	 * -delete metodları alınan id degeri member ve trainer metodunda herhangi
	 * bir borcu veya icerde kalan parası var mı kontrol edilir kontrolden
	 * gecerse isleme devam edilir ve true dondurur gecemezse false dondurur
	 * ...List.delRow metodu kullanılarak listedeki deger silinir
	 * dbProcess.dropTable metodu kullanılarak ilgili id deki schedule tablosu
	 * drop edilir
	 */
	public void deleteMember(String id) {

	}

	public void deleteSport(String id) {

	}

	public void deleteTrainer(String id) {

	}

	/*
	 * -schedule metodları alınan id parametresi için ilgili schedule nesnesini
	 * oluşturur alınan tarih ve salon parametreleri schedule nesnesine a set
	 * edilir ...Schedule.addRow metoduyla schedule tablosuna eklenir
	 */
	public void scheduleSport(String id, Date date, String saloon) {

	}

	public void scheduleTrainer(String id, Date date, String sportName, String saloon) {

	}

}
