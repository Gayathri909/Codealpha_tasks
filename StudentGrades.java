import java.util.Scanner;
public class StudentGrades{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter number of students:");
        int numStudents=s.nextInt();
        if(numStudents <= 0){
            System.out.println("Invalid number of students.");
            System.exit(0);
        }
        double[] grades=new double[numStudents];
        for(int i=0;i<numStudents;i++){
            while(true){
                System.out.println("Enter grade of student "+(i+1)+" : ");
                double grade=s.nextDouble();
                if(grade >= 0 && grade <= 100){
                    grades[i]= grade;
                    break;
                }
                else
                System.out.println("Invalid grade! please enter a grade between 0 and 100.");
            }
        }
        double sum=0;
        double highest=grades[0];
        double lowest=grades[0];
        for(double grade : grades){
            sum+=grade;
            highest=Math.max(grade,highest);
            lowest=Math.min(grade,lowest);
        }
        double average=sum/numStudents;
        System.out.println("Grade Summary:");
        System.out.println("Total Students: "+numStudents);
        System.out.println("Average Grade: "+average);
        System.out.println("Highest Grade: "+highest);
        System.out.println("Lowest Grade: "+lowest);
        s.close();
    }
}