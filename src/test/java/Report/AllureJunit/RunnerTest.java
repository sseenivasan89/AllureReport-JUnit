package Report.AllureJunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BingSearch.class, GoogleSearch.class })

public class RunnerTest {

}
