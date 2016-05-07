package complex.process;

import db.adapter.Date;

public class MemberProcess extends Process {

	private ReservationProcess rp;
	private PaymentProcess pp;

	MemberProcess() {

	}

	public void reserve(Date date, String sportID, String trainerID) {

	}

	public void payFee(String id, int payment) {
		if(searchOnTable("memberlist",id)!=null){
			if(memberList.getDebt()!=0){
				memberList.setDebt(memberList.getDebt()-payment);   //ODEMEDEN SONRA UYENIN BORCUNDAN ODEME MIKTARI DUSURULUR
			}
		}
	}

	public void checkForWeeklySchedule() {

	}

}
