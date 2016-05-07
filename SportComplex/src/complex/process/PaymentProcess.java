package complex.process;

public class PaymentProcess extends Process {

	PaymentProcess() {

	}

	public boolean checkMemberPayment(String id) {
		if(searchOnTable(id,"memberlist") != null) {
			if(memberList.getDebt() == 0) {
				return true;
			}	
		}
		return false;
	}

	public boolean checkTrainerPayment(String id) {
		if(searchOnTable(id,"trainerlist") != null) {
			if(trainerList.getSalary() != 0) {
				return true;
			}
		}
		return false;

	}

	public void memberPays(String id, int payment) {
		if(searchOnTable("memberlist",id)!=null){
			if(memberList.getDebt()!=0){
				memberList.setDebt(memberList.getDebt()-payment);   //ODEMEDEN SONRA UYENIN BORCUNDAN ODEME MIKTARI DUSURULUR
			}
		}

	}

	public boolean payToTrainer(String id) {
		if(searchOnTable("trainerlist",id)!=null){
			if(trainerList.getSalary()!=0){        //MAAS GUNU KONTROLUYLE DEGISTIRELECEK
				return true;					   //MAAS ODENDIYSE TRUE DONDURUR	
			}
		}
	return false;
	}

}