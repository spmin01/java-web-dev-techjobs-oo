package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job fullJob;
    Job fullJob2;

    @Before
    public void createJobObjects() {
        job1 = new Job();
        job2 = new Job();
        fullJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        fullJob2 =  new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
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

}
