package complex.process;

public class TrainerProcess extends Process {

	TrainerProcess() {

	}

	public void checkSchedule() {

	}

	public boolean checkPayment(String id) {
		if(searchOnTable(id,"trainerlist") != null) {
			if(trainerList.getSalary() != 0) {
				return true;
			}
		}
		return false;

	}

}
