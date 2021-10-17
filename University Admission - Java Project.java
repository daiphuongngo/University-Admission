/*
 This program helps user input and check password, number of students, subjects' scores, calculate GPA, print reports
*/
import java.util.Scanner;
public class JavaProjectCheckPassword {
	/* I: String 
	 * P: Invoking other specific methods, calculate GPA's final score for each student and inserting each into matrix
	 * O: void (not returning anything) so there is no output
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("----------Welcome to the University of Toronto----------\n");
		
		int attempt = 0; // Checking password:
		while (attempt < 3) {
			System.out.print("Enter your password: ");
	        String password = input.next();  
	        if (checkPassword(password) == true) {  
	            System.out.println("\nValid Password\n"); 
	            break;
	        } else {  
	            System.out.println("\nInvalid Password\n");  
	            attempt++;
	        }  
	    }
		if (attempt == 3) {
	        System.out.println("\nMaximum number of attempts exceeded\n");
	        System.exit(0); // end the program if exceeding 3 attempts
		}
		// Create two 1D-array to store Student name, number of admitted students per school, students' score & GPA sum
		String[] studentList = new String [enterNumStudent(input)]; // Name List should be in a separate List // check Number of Student // set string length by numStudent --> this list contains String values // neu ko phai void thi chi la bien tra ve. void thi moi call/invoke method duoc
		int [][] markList = new int[studentList.length][7]; // Enter Mark and Calculate GPA // create matrix containing Student Marks incl 6 cols for marks, 7th col for GPA // not use enterNumStudent() to avoid invoke that method and enter multiple times
		int [] schoolList = new int[4]; // Select School
		
		for (int i = 0; i < markList.length; i++) {
			System.out.print("\nEnter student name: ");
			studentList[i] = input.next();  
			markList = enterMark(i, markList, 4, "Math", 0, input); // added the 5th parameter (Scanner input) to this enterMark to generate inputting without having another line of Scanner
			markList = enterMark(i, markList, 5, "Science", 1, input);
			markList = enterMark(i, markList, 4, "Language", 2, input);
			markList = enterMark(i, markList, 3, "Drama", 3, input);
			markList = enterMark(i, markList, 2, "Music", 4, input);
			markList = enterMark(i, markList, 4, "Biology", 5, input); //markList[i][6] = calculateGPA(markList[i][6]);
			markList[i][6] = markList[i][6] / 22; // gpa/22 = 600/22 for example of 100 pts per course of the 1st student
			}
		
		// Print out maxtrix markList:
		for (int i = 0; i < markList.length; i++) {
		    for (int j = 0; j < markList[i].length; j++) {
		        System.out.print(markList[i][j] + " ");
		    }
		    System.out.println();
		}
		//Invoke admissionReport method
		admissionReport(studentList, markList, schoolList); // markList: score matrix's GPA has been divided by 22 (credit hours) 
		input.close();
	}	
	/*
	 * I: String parameter (password)
	 * P: Check password if meeting requirements
	 * O: Return boolean
	 */
	public static boolean checkPassword(String password) { /// specific method
		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        if (password.length() < 10) {   // check password length
            return false;  
        } else {      
            char c;  
            int numUpperCaseLetter = 0, numDigit = 0, numSpecialChar = 0;
            for (int i = 0; i < password.length(); i++) {  
                c = password.charAt(i);  
                if (Character.isUpperCase(c))  numUpperCaseLetter++; // check Uppercase
                else if (Character.isDigit(c)) numDigit++;  // check Digit 
                else if (specialCharactersString.contains(Character.toString(c))) numSpecialChar++; // check special char  
            }
            if (numUpperCaseLetter < 1) {
            	System.out.println("\nPassword must contain at least one upper case letter.\n");
            	return false;
            }
            if (numDigit != 2 && numDigit != 3)   {     
            	System.out.println("\nPassword must contain two or three numbers.\n");
            	return false;
            }     
            if (numSpecialChar != 1) {
            	System.out.println("\nPassword must contain one special character.\n");
            	return false;
            }
        }
        return true; // *** must return true to get the true condition 
	}
	
	/*
	 * I: Scanner object
	 * P: Check number of students if within range from 1-50
	 * O: Integer parameter (numStudent)
	 */
	public static int enterNumStudent(Scanner input) { // Check Number of Student // added Scanner input as a parameter for this method (actually no need to close Scanner running within a specific method)
		int attemptNumStudent = 0, numStudent = 0;
		//Scanner input = new Scanner(System.in);
		while (numStudent <1 || numStudent > 50) {
			System.out.print("Enter the number of students: "); // must enter new number (first time or again)
			numStudent = input.nextInt(); 
			if (numStudent < 1 || numStudent > 50) {
		        System.out.println("\nNumber of students must be between 1-50.\n");
		        attemptNumStudent++;
		    }
		    if (numStudent >= 1 && numStudent <= 50) {
		        System.out.println("\nNumber of students: " + numStudent); // --> check length of list student
		     //  input.close();
		        return numStudent; // stronger than break to exit // after return, the rest will not be proceeded		   
		    }
		    if (attemptNumStudent == 3) {
		        System.out.println("\nMaximum number of attempts exceeded.\n");
		        System.exit(0);
		    }		    
		}
		return numStudent;
	}
	/* 
	 * Input: Integer, String, Matrix of Integers (parameter), Scanner object
	 * Process: Enter each subject's mark of each student into a matrix cell, calculate total GPA of each student by summing up
	 * Output: Matrix of Integers (matrix)
	 */
	public static int [][] enterMark(int studentRowIndex, int [][] matrix, int credit, String subjectName, int courseColumnIndex, Scanner sc) { // added the 5th parameter (Scanner input) to this enterMark to generate inputting without having another line of Scanner //public static int calculateGPA(int gpa) ---> return gpa/22 in the main method;
		System.out.print("\nInput your mark in " + subjectName + ": ");
		matrix[studentRowIndex][courseColumnIndex] = sc.nextInt();
		matrix[studentRowIndex][6] += matrix[studentRowIndex][courseColumnIndex]*credit; // cumulative sum of GPA // 6 is the 6th column: GPA 100*4 + 100*3 + 100*4 .... = ...
		return matrix;
		}
	
	/*
	 * I: Array of String (studentName), Matrix of Integers (markList), Array of Integers (school)
	 * P: Print results and reports only
	 * O: void
	 */
	public static void admissionReport(String [] studentName, int [][] markList, int [] school) { // school: number of students accepted in a school // markList: score matrix
		for (int i = 0; i < studentName.length; i++) {
			System.out.print("Student Name: " + studentName[i]);
			if (markList[i][6] >= 90 && markList[i][6] <= 100) {
				school[0]++; // Engineering
				System.out.println(" is admitted in School of Engineering");
			}
			else if (markList[i][6] >= 80 && markList[i][6] < 90) {
				school[1]++; // Business
				System.out.println(" is admitted in School of Business");
			}
			else if (markList[i][6] >= 70 && markList[i][6] < 80) {
				school[2]++; //Law
				System.out.println(" is admitted in Law School");
			}
			else {
				school[3]++; // Cut
				System.out.println(" is unfortunately Not Accepted");
			}
		}
		System.out.println("Number of accepted students in the University of Toronto: " + (school[0] + school[1] + school[2]));
		System.out.println("Number of accepted students in School of Engineering: " + school[0]);
		System.out.println("Number of accepted students in School of Business: " + school[1]);
		System.out.println("Number of accepted students in School of Law: " + school[2]);
		System.out.println("Number of unaccepted students in the University of Toronto: " + school[3]);
		System.out.println("Ratio of accepted students in the University of Toronto among admission: " + ((double)(school[0] + school[1] + school[2]) / studentName.length)*100 + "%");
	}
}



