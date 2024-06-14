

    import java.util.Scanner;
    public class task2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();
    
            double totalMarks = 0;
            for (int i = 1; i <= numSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                double marks = scanner.nextDouble();
                totalMarks += marks;
            }
    
            double averagePercentage = totalMarks / numSubjects;
    
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
    
            System.out.println("Total Marks: " + totalMarks);
            System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
            System.out.println("Grade: " + grade);
        }
    }
