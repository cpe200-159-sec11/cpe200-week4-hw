package cpe200;

public class TestEnrollment {
    public static void main (String [] args) {
        Student [] s = new Student[10];

        System.out.println("******** All students ********");
        for (int i=1; i<9; i++) {
            // Student s[0] will not be used.
            s[i] = new Student("S"+String.valueOf(i),"58061170"+String.valueOf(i),1990+(i));
            System.out.println(s[i]);
        }

        System.out.println("\n******** Available courses ********");
        Course cpe102 = new Course("Computer Programming","261102", "Santi");
        Course cpe200 = new Course("Object Oriented Programming", "261200", "Dome");
        Course isne103 = new Course("Programming for ISNE", "269103", "Patiwet",10);
        Course isne200 = new Course("Web Programming", "269200", "Kenneth",10);
        Course isne202 = new Course("Algorithm for ISNE", "269202", "Kenneth",10);

        System.out.println(cpe102);
        System.out.println(cpe200);
        System.out.println(isne103);
        System.out.println(isne200);
        System.out.println(isne202);


        System.out.println("\n******** Start batch enrollment: ADD transactions ********");
        s[1].addCourse(cpe102); s[1].addCourse(cpe102); s[1].addCourse(cpe200); s[1].addCourse(isne103); s[1].addCourse(isne200);
        s[2].addCourse(cpe102); s[2].addCourse(cpe200); s[2].addCourse(isne103); s[2].addCourse(isne202);
        s[3].addCourse(cpe102); s[3].addCourse(isne103); s[3].addCourse(isne200); s[3].addCourse(isne202);
        s[4].addCourse(cpe102); s[4].addCourse(isne202);
        s[5].addCourse(isne202); s[5].addCourse(isne200);
        s[6].addCourse(isne202);
        s[7].addCourse(isne202);
        s[8].addCourse(isne202);


        System.out.println("\n******** After ADD transactions ********");
        for (int i=1; i<9; i++) {
            System.out.println(s[i]);
        }
        System.out.println();
        System.out.println(cpe102);
        System.out.println(cpe200);
        System.out.println(isne103);
        System.out.println(isne200);
        System.out.println(isne202);

        System.out.println("\n******** Start batch enrollment: DROP transactions ********");
        s[1].dropCourse(cpe102);
        s[1].dropCourse(isne200);
        s[2].dropCourse(isne103);
        s[3].dropCourse(cpe200); s[3].dropCourse(cpe102);
        s[8].dropCourse(isne202); s[8].dropCourse(cpe200);



        System.out.println("\n******** After DROP transactions ********");
        for (int i=1; i<9; i++) {
            System.out.println(s[i]);
        }
        System.out.println();
        System.out.println(cpe102);
        System.out.println(cpe200);
        System.out.println(isne103);
        System.out.println(isne200);
        System.out.println(isne202);

    }
}
