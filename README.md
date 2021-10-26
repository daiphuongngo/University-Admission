# University-Admission

### Category:

- Education

- Schooling

- Admission


### Targets:

- Store information about the newly admitted students

- Assign them to the University of Toronto's schools according to their GPA

- Prompt the user to enter the name of each student, and the grades of the courses they completed in the high school

- Calculate the GPA and use it to assign students the schools

### Approach:

Utilizing 1D & 2D arrays, for & while loops, 1 main method to invoke all 4 specific methods, including:

- checkPassword

- enterNumStudent

- enterMark

- admissionReport

### Main Method’s IPO:

* Input: String 

* Process: Invoking other specific methods, calculate GPA's final score for each student and inserting each into matrix

* Output: void (not returning anything) so there is no output

### Checking password's IPO:

- Method’s name: checkPassword

- Input: String

- Process: Loop through if-else conditions to return if the password is valid or not

- Output: Boolean

### Entering number of students's IPO:

- Method’s name: enterNumStudent

- Input: Integer

- Process: Check number of students if within range from 1-50
 
- Output: numStudent(Integer)

### Entering, calculating GPA & assigning schools' IPO:

- Method’s name: enterMark

- Input: Integer, String, Matrix of Integers (parameters), Scanner (object)

- Process: Enter each subject's mark of each student into a matrix cell, calculate total GPA of each student by summing up

- Output: Matrix of Integers (matrix)

### Printing the report's IPO:

- Method’s name: admissionReport

- Input: studentName, matrix of markList, array of schools

- Process: Assign each student a school. Show number of accepted students by school and non accepted students

- Output: void










