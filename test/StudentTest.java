import cpe200.Course;
import cpe200.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StudentTest {

    private Student s;

    @Test
    public void defaultConstructor() throws Exception {
        s = new Student();
        assertEquals("John Doe", s.getName());
        assertEquals("560610000", s.getStudent_id());
        assertEquals(1990, s.getYearOfBirth());
        assertEquals(false, s.isActive());
    }

    @Test
    public void parameterizedConstructor() throws Exception {
        // valid data
        s = new Student("Saman Boonme", "590613001", 1998, true);
        assertEquals("Saman Boonme", s.getName());
        assertEquals("560610000", s.getStudent_id());
        assertEquals(1998, s.getYearOfBirth());
        assertEquals(true, s.isActive());

        // invalid data
        s = new Student("Somchai Maakmee", "500611701", 1980, false);
        assertEquals("Somchai Maakmee", s.getName());
        assertEquals("560610000", s.getStudent_id());
        assertEquals(1990, s.getYearOfBirth());
        assertEquals(false, s.isActive());
    }

    @Before
    public void setUp() throws Exception {
        s = new Student("Sanguan Sornjai", "590611702", 1999, false);
    }

    @Test
    public void invalidName() throws Exception {
        // continue from setUp()
        s.setName("");
        assertEquals("Sanguan Sornjai", s.getName());
    }

    @Test
    public void invalidStudentID() throws Exception {
        // continue from setUp()

        // invalid data
        s.setStudent_id("550710111");
        assertEquals("590611702",s.getStudent_id());

        // valid data
        s.setStudent_id("590612111");
        assertEquals("590612111",s.getStudent_id());

        // invalid data
        s.setStudent_id("590613111");
        assertEquals("590612111",s.getStudent_id());

        // invalid data
        s.setStudent_id("590613111000");
        assertEquals("590612111",s.getStudent_id());

        // invalid data
        s.setStudent_id("helloworld");
        assertEquals("590612111",s.getStudent_id());
    }

    @Test
    public void invalidYOB() throws Exception {
        // continue from setUp()
        s.setYearOfBirth(1976);
        assertEquals(1999, s.getYearOfBirth());
    }

    @Test
    public void checkToString() throws Exception {
        // continue from setUp()

        assertEquals("Sanguan Sornjai (590611702) was born in 1999 is an INACTIVE student.", s.toString());
    }

    @Test
    public void testAddDropCourse() throws Exception {
        Student s1 = new Student("S1","590610701",1995);
        Course c1 = new Course("C1","111111","L1");
        Course c2 = new Course("C2","222222","L2");
        Course c3 = new Course("C3","333333","L3");

        assertTrue(s1.addCourse(c1));
        assertTrue(s1.addCourse(c2));
        assertTrue(s1.addCourse(c3));
        assertFalse(s1.addCourse(c1));
        assertFalse(s1.addCourse(c2));

        assertTrue(s1.dropCourse(c2));
        assertTrue(s1.dropCourse(c1));
        assertTrue(s1.dropCourse(c3));
        assertFalse(s1.dropCourse(c1));
        assertFalse(s1.dropCourse(c2));
    }

}