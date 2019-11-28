import org.junit.*;;
import org.launchcode.techjobs_oo.*;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;
    Job job3;
    Job job4;
    Job job5;
    Job job6;

    @Before
    public void makeJobs() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        job5 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        job6 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(job1.getId(),job2.getId()-1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assert(job3.getEmployer() instanceof Employer);
        assert(job3.getLocation() instanceof Location);
        assert(job3.getPositionType() instanceof PositionType);
        assert(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertEquals(job4.getId(),job5.getId());
    }

    @Test
    public void testJobToStringForBlankLines () {
        assertThat(job3.toString(), startsWith("\n"));
        assertThat(job3.toString(), endsWith("\n"));
    }

    @Test
    public void emptyFieldDataNotAvailableMessage () {
        assertEquals(job6.getName(), "Data not available");
    }

    @Test public void onlyIdFieldJobDataDoesNotExist () {
        assertEquals(job1.toString(), "OOPS! This job does not seem to exist.");
    }
}
