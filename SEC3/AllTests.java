import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CheckMembers.class, ZeroForAll.class, SumToOne.class, TestNormalization.class, TestZero.class })
public class AllTests {

}