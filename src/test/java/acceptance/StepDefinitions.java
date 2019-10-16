package acceptance;

import static org.junit.Assert.assertEquals;

import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	private String server = System.getProperty("calculator.url");
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private Integer a;
	private Integer b;
	private Integer result;

	@Given("I have two numbers: {int} and {int}")
	public void i_have_two_numbers_and(Integer int1, Integer int2) {
	    this.a = int1;
	    this.b = int2;
	}

	@When("the calculator sums them")
	public void the_calculator_sums_them() {

		String url = String.format("%s/sum?a=%s&b=%s", server, a, b);
		result = restTemplate.getForObject(url, Integer.class);
	}

	@Then("I receive {int} as a result")
	public void i_receive_as_a_result(Integer int1) {
	    assertEquals(int1.intValue(), result.intValue());
	}
}
