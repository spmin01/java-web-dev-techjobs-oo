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
    static Location emptyField;

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
        emptyField = new Location("");

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
        assertEquals("ID: " + fullJob.getId(), jobStringByLines[1]);
        assertEquals("Name: " + fullJob.getName(), jobStringByLines[2]);
        assertEquals("Employer: " + fullJob.getEmployer(), jobStringByLines[3]);
        assertEquals("Location: " + fullJob.getLocation(), jobStringByLines[4]);
        assertEquals("Position Type: " + fullJob.getPositionType(), jobStringByLines[5]);
        assertEquals("Core Competency: " + fullJob.getCoreCompetency(), jobStringByLines[6]);
    }

    @Test
    public void toStringShouldListDataNotAvailableForEmptyFields() {
        // Only needs to be tested for one field as all fields share common base class constructor
        assertEquals("Data not available", emptyField.toString());
    }

    @Test
    public void toStringShouldReturnErrorStringForEmptyJob() {
        assertEquals("OOPS! This job does not seem to exist.", job1.toString());
    }


}
