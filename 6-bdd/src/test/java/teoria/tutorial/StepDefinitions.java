package teoria.tutorial;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

	private Calendar calendar;	
	private boolean res;
	
	@Given("Today is Sunday")
	public void today_is_sunday() {
		calendar = new Calendar();
		calendar.setDay(Day.SUNDAY);
	}

	@When("I ask the system whether it's Friday")
	public void i_ask_the_system_whether_it_s_friday() {
		res = calendar.askTodayIs(Day.FRIDAY);
	}

	@Then("The answer should be false")
	public void the_answer_should_be_false() {
		assertThat(res).isFalse();
	}
	
}
