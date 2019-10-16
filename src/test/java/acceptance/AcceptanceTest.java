package acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This is an acceptance test using Cucumber
 * @author Ben Gu
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/calculator.feature")
public class AcceptanceTest {

}
