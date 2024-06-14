
    import java.util.ArrayList;
    import java.util.List;
    
    public class Stud {
        private String studentID;
        private String name;
        private List<cour> registeredCourses;
    
        public Stud(String studentID, String name) {
            this.studentID = studentID;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }
    
        public String getStudentID() {
            return studentID;
        }
    
        public String getName() {
            return name;
        }
    
        public List<cour> getRegisteredCourses() {
            return registeredCourses;
        }
    
        public boolean registerCourse(cour course) {
            if (course.enrollStudent()) {
                registeredCourses.add(course);
                return true;
            }
            return false;
        }
    
        public boolean dropCourse(cour course) {
            if (registeredCourses.remove(course)) {
                course.dropStudent();
                return true;
            }
            return false;
        }
    
        public void listRegisteredCourses() {
            if (registeredCourses.isEmpty()) {
                System.out.println("No courses registered.");
            } else {
                for (cour course : registeredCourses) {
                    System.out.println(course);
                }
            }
        }
    }

