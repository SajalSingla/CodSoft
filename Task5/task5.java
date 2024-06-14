
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    public class task5 {
    
        private List<cour> courses;
        private List<Stud> students;
    
        public task5() {
            this.courses = new ArrayList<>();
            this.students = new ArrayList<>();
        }
    
        public void addCourse(cour course) {
            courses.add(course);
        }
    
        public void addStudent(Stud student) {
            students.add(student);
        }
    
        public void listCourses() {
            for (cour course : courses) {
                System.out.println(course);
            }
        }
    
        public Stud findStudentById(String studentID) {
            for (Stud student : students) {
                if (student.getStudentID().equals(studentID)) {
                    return student;
                }
            }
            return null;
        }
    
        public cour findCourseByCode(String courseCode) {
            for (cour course : courses) {
                if (course.getCode().equals(courseCode)) {
                    return course;
                }
            }
            return null;
        }
    
        public static void main(String[] args) {
            task5 system = new task5();
            Scanner scanner = new Scanner(System.in);
    
            
            system.addCourse(new cour("CS01", "Intro to Computer Science", "Basics of Computer Science", 30, "MWF 9-10AM"));
            system.addCourse(new cour("CS02", "Data Structures", "Intro to DSA", 25, "TTh 10-11:30AM"));
    
            
            system.addStudent(new Stud("S01", "sajal"));
            system.addStudent(new Stud("S02", "singla"));
    
            while (true) {
                System.out.println("1. List courses");
                System.out.println("2. Register for a course");
                System.out.println("3. Drop a course");
                System.out.println("4. List registered courses");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();  
    
                switch (choice) {
                    case 1:
                        system.listCourses();
                        break;
                    case 2:
                        System.out.println("Enter student ID: ");
                        String studentID = scanner.nextLine();
                        Stud student = system.findStudentById(studentID);
                        if (student == null) {
                            System.out.println("Student not found");
                            break;
                        }
                        System.out.println("Enter course code: ");
                        String courseCode = scanner.nextLine();
                        cour course = system.findCourseByCode(courseCode);
                        if (course == null) {
                            System.out.println("Course not found");
                            break;
                        }
                        if (student.registerCourse(course)) {
                            System.out.println("Successfully registered");
                        } else {
                            System.out.println("Course is full or already registered");
                        }
                        break;
                    case 3:
                        System.out.println("Enter student ID: ");
                        studentID = scanner.nextLine();
                        student = system.findStudentById(studentID);
                        if (student == null) {
                            System.out.println("Student not found");
                            break;
                        }
                        System.out.println("Enter course code: ");
                        courseCode = scanner.nextLine();
                        course = system.findCourseByCode(courseCode);
                        if (course == null) {
                            System.out.println("Course not found");
                            break;
                        }
                        if (student.dropCourse(course)) {
                            System.out.println("Successfully dropped");
                        } else {
                            System.out.println("You are not registered for this course");
                        }
                        break;
                    case 4:
                        System.out.println("Enter student ID: ");
                        studentID = scanner.nextLine();
                        student = system.findStudentById(studentID);
                        if (student == null) {
                            System.out.println("Student not found");
                            break;
                        }
                        System.out.println("Registered courses for student " + student.getName() + ":");
                        student.listRegisteredCourses();
                        break;
                    case 5:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }

