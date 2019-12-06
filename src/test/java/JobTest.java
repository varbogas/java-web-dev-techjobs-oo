import org.junit.*;;
import org.launchcode.techjobs_oo.*;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

public class JobTest {
    private Job job1;
    private Job job2;
    private Job job3;
    private Job job4;
    private Job job5;
    private Job job6;

    @Before
    public void makeJobs() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        job5 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        job6 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    //Test that ID Numbers are equal
    @Test
    public void testSettingJobId() {
        assertEquals(job1.getId(),job2.getId()-1);
    }

    //Test that constructor correctly assigns the class and value of each field
    @Test
    public void testJobConstructorSetsAllFields(){
        assert(job3.getEmployer() instanceof Employer);
        assert(job3.getLocation() instanceof Location);
        assert(job3.getPositionType() instanceof PositionType);
        assert(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    //Test that two objects that are the same except ID do NOT equal to each other
    @Test
    public void testJobsForEquality() {
        assertNotEquals(job4.getId(),job5.getId());
    }

    //Test to string override starts and ends with blank lines
    @Test
    public void testJobToStringForBlankLines () {
        assertThat(job3.toString(), startsWith("\n"));
        assertThat(job3.toString(), endsWith("\n"));
    }

    //Test that constructor returns 'data not available' when there's no input for a field
    @Test
    public void emptyFieldDataNotAvailableMessage () {
        assertEquals(job6.getName(), "Data not available");
    }

    //Test that 'OOPS! This job does not seem to exist.' is returned if ID is the ONLY field
    @Test public void onlyIdFieldJobDataDoesNotExist () {
        assertEquals(job1.toString(), "OOPS! This job does not seem to exist.");
    }
}
