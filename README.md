# Doubly-Linked-List-Data-Structure
A guide application has been developed based on the use of the doubly linked list data structure, where students are maintained in a sorted order according to their student numbers. 

It was an assignment for the Algorithms and Programming lecture.


A class named "Student" has been created to represent students. In the "Student" class, information such as student number, full name, and contact phone numbers are stored. Since a student may have multiple phone numbers (such as multiple mobile phones, home phones, etc.), the information about phone numbers is kept in an "ArrayList." The "Student" class includes three constructor methods (parameterless, with all parameters, and a copy constructor), get/set methods, and a toString method.

In the node class I wrote, there are the necessary link fields for a doubly linked list, as well as a variable definition of the type "Student" class.

### Methods in the Student Class
- A method that takes a parameter of type "Student" and adds it to the list in a sorted manner based on the student number.

- A method that searches for a student in the list based on the given first and last name. If found, it prints the information of this student (and other students with the same name and surname).

- A deletion method that removes the student with the given student number from the list.

- A method that prints all records in ascending order (from the smallest student number to the largest student number).

- A method that prints all records in descending order (from the largest student number to the smallest student number).


### The application provides the user with the following options:

1. Reading from the text file named "ogrenciler.txt" and creating a doubly linked list in memory as shown below. (Data is separated by commas.)
     - NOTE: As previously mentioned, the guide is created in order based on the student number.
     - ogrenciler.txt:
     - 125, Veli Tuz, 0 533 1111111, 0 232 1111111
     - 112, Ali Can Kara, 0 554 2222222, 0 543 3333333, 0 312 1111111
     - 144, Canan Demir, 0 216 4444444
     - 118, Veli Tuz, 0 505 2222222
     - 102, Ayse Demir, 0 532 6667777, 0 232 2233455
     - ... and so on

2. Entering all data from the keyboard, the student is added to the list in a sorted manner based on the student number. In other words, an addition is made to the doubly linked list.

4. Entering the name and surname of a student from the keyboard, the information of the student (and all students with the same name and surname if any) is printed on the screen.

5. Entering the student number, the student is deleted from the list. In other words, deletion is performed from the doubly linked list.

6. All records in the list are printed on the screen in ascending order (from the smallest student number to the largest student number).

7. All records in the list are printed on the screen in descending order (from the largest student number to the smallest student number).

8. EXIT: The program is exited.
