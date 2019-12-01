package org.launchcode.techjobs_oo.tests;


import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    static Job job1;
    static Job job2;
    static Job fullJob;
    static Job fullJob2;
    static String jobString;
    static String emptyJobString;

    @BeforeClass
    public static void createJobObjects() {
        job1 = new Job();
        job2 = new Job();

        fullJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        fullJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobString = fullJob.toString();
        emptyJobString = job1.toString();

    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, job1.getId());
        assertEquals(2, job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(3, fullJob.getId());
        assertEquals("Product tester", fullJob.getName());

        assertTrue(fullJob.getEmployer() instanceof Employer);
        assertEquals("ACME", fullJob.getEmployer().toString());

        assertTrue(fullJob.getLocation() instanceof Location);
        assertEquals("Desert", fullJob.getLocation().toString());

        assertTrue(fullJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", fullJob.getPositionType().toString());

        assertTrue(fullJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", fullJob.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEquality() {
        assertFalse(fullJob == fullJob2);
    }

    @Test
    public void toStringShouldContainBlankLineBeforeAndAfter() {
        assertTrue(jobString.charAt(0) == '\n');
        assertTrue(jobString.charAt(jobString.length() - 1) == '\n');
    }

    @Test
    public void toStringShouldHaveLabelAndDataForEachFieldOnNewLine() {
        String[] jobStringByLines = jobString.split("\n");

        // jobStringByLines[0] is empty
        assertTrue(jobStringByLines[1].equals("ID: " + fullJob.getId()));
        assertTrue(jobStringByLines[2].equals("Name: " + fullJob.getName()));
        assertTrue(jobStringByLines[3].equals("Employer: " + fullJob.getEmployer()));
        assertTrue(jobStringByLines[4].equals("Location: " + fullJob.getLocation()));
        assertTrue(jobStringByLines[5].equals("Position Type: " + fullJob.getPositionType()));
        assertTrue(jobStringByLines[6].equals("Core Competency: " + fullJob.getCoreCompetency()));
    }

    @Test
    public void toStringShouldListDataNotAvailableForEmptyFields() {
        String[] jobStringByLines = emptyJobString.split("\n");

        assertTrue(jobStringByLines[2].equals("Name: Data not available"));
        assertTrue(jobStringByLines[3].equals("Employer: Data not available"));
        assertTrue(jobStringByLines[4].equals("Location: Data not available"));
        assertTrue(jobStringByLines[5].equals("Position Type: Data not available"));
        assertTrue(jobStringByLines[6].equals("Core Competency: Data not available"));
    }

}
