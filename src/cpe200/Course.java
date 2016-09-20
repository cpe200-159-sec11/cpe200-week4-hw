package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() { this("","","",DMAX); }

    public Course(String n, String cid) {
        this(n,cid,"",DMAX);
    }

    public Course(String n, String cid, String l) {
        this(n,cid,l,DMAX);
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = isValidCourse_id(cid)?cid:"000000";
        this.lecturer = !l.equalsIgnoreCase("")?l:"TBA";
        this.max_students = max<DMAX?DMAX:max;
        this.no_students = 0;

        // initialized the list of enrolled students
        this.students = new PList();                     //Done!
    }

    public boolean enrollStudent(Student s) {

        if (this.no_students < this.max_students) {     // check if the course is FULL

                if(this.students.found(s)==true) { // check if the student has ALREADY enrolled in this course
                    return false;

                }
                else{
                    this.students.pushToTail(s);     //put it in list.
                    this.no_students++;         //increase num of student.

                    return true;
                }
        }
              // add the student to the list of students (PList)
            // update number of students in the course
            // print message and return value accordingly
            // print error message, and return value accordingly
            // implement your code here!!!
        return false;
    }

    public boolean removeStudent(Student s) {

        if(this.students.found(s)){
            this.students.remove(s);
            this.no_students--;
            return true;
        }

        return false;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = !lecturer.equalsIgnoreCase("")?lecturer:this.lecturer;
    }

    public int getMax_students() {
        return max_students;
    }

    public void setMax_students(int max_students) {
        this.max_students = max_students<10?this.max_students:max_students;
    }

    public int getNo_students() {
        return no_students;
    }

    public void setNo_students(int no_students) {
        this.no_students = (no_students>=0 && no_students<=max_students)?no_students:this.no_students;
    }

    @Override
    public String toString() {
        String o = this.course_name + " ("
                + this.course_id + "), Teacher: "
                + this.lecturer + ", has ";

        if (this.no_students < 1)
            o += "NO student, ";
        else if (this.no_students == 1)
            o += "ONE student, ";
        else if (this.no_students > 1)
            o += this.no_students + " students, ";

        o += "[maximum: " + this.max_students + "]";

        // Information on student(s) who has enrolled in this course
        // implement your code here!!!
        for (int i=0; i<students.getSize(); i++) {
            Student s = (Student)students.elementAt(i);

            // implement your code here!!!
            o += "\n\t" + s.getStudent_id() + " - " + s.getName()  ;
        }
        return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        return m.matches();
    }

    private static final String idREGEX = "\\d{6}";
    private static final int DMAX = 3;

    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;

    // add a list of enrolled students
    private PList students;

}
