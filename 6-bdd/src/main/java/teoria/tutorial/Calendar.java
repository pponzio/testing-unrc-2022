package teoria.tutorial;

public class Calendar {
	
	private Day today;

	public void setDay(Day day) {
		this.today = day;
	}

	public boolean askTodayIs(Day day) {
		// TODO Auto-generated method stub
		return today.equals(day);
	}
	
	

}
