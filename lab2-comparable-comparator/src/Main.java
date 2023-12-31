import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {

    // used for exercise 3
    public static ArrayList<Integer> generateRandomIntegerArray(int size){
        Random randomNumber = new Random();
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        for (int i=0; i< size; i++ ){
            intArray.add(randomNumber.nextInt(100));
        }

        return intArray;
    }

    public static void main(String[] args) {
        /*
         * CPRG304F Lab2 - Comparable and Comparator Interfaces
         * @author izalumpio
         *
         * Area to test solution to exercises
         */

        //////// Exercise 1 ////////////////////////////////////////////////////////////////////////////////
        /*
        * implement class Student with fields name and age
        * implement comparable and comparator interfaces to compare students based on their name and age
        * the Student class implements both Comparable and Comparator interfaces
        * create a compareTo method by the Comparable Interface to compare students by name
        * create a compare method by the Comparator Interface to compare students based on their age.
        * if their age is equal then compare by name
        * to test, create a list of student objects and sort it using Collections sort method.
        */
        System.out.print("""
                -------------------| EXERCISE 1 |---------------------------------------------------------------

                """);

        //1. create an array of Students
        List<Student> studentList1 = new ArrayList<Student>();
        studentList1.add(new Student("Star", 23));
        studentList1.add(new Student("Bucks", 24));
        studentList1.add(new Student("Chars", 27));
        studentList1.add(new Student("Gretta", 24));

        List<Student> studentList2 = new ArrayList<Student>();
        studentList2.add(new Student("Star", 23));
        studentList2.add(new Student("Bucks", 24));
        studentList2.add(new Student("Chars", 27));
        studentList2.add(new Student("Gretta", 24));

        //2. print the unsorted array
        System.out.println("------------Unsorted list of students in studentList1");
        for (Student student: studentList1){
            System.out.println(student.getName() + "," + student.getAge());
        }

        //3. sort with collections sort
        System.out.println("------------Sorted (by name) studentList1 using Collections sort");
        Collections.sort(studentList1);
        for (Student student: studentList1){
            System.out.println(student.getName() + "," + student.getAge());
        }
        System.out.println("""
                Notice that studentList1 is sorted by Name. This is because we implemented comparable
                in the Student class. Otherwise it would be sorted by age.
                """);


        //4. Use comparator with collections sort
        System.out.println("------------Sorted studentList2 using Collections sort and comparator");

        // create a comparator and override the comparator's compare method
        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                int ageDiff = student1.getAge() - student2.getAge();

                if (ageDiff == 0){
                    return student1.compareTo(student2);
                }
                else{
                    return ageDiff;
                }
            }
        };

        //sort and print
        Collections.sort(studentList2, studentComparator);
        for (Student student: studentList2){
            System.out.println(student.getName() + "," + student.getAge());
        }
        System.out.println("""
                The studentList2 should now be in order from youngest to oldest and if the same age,
                they are ordered by name.
                """);





        //////// Exercise 2 ///////////////////////////////////////////////////////////////////////////////////
        /* Implement a static method binarySearch that takes a Sorted list of integer objects
         * and an integer target and returns the index of the target in the lift if it exists,
         * return -1 if it doesn't.
         */
        System.out.print("""
                -------------------| EXERCISE 2 |----------------------------------------------------------------

                """);


        //1. create an array of integers
        ArrayList<Integer> intArray = generateRandomIntegerArray(7);

        System.out.println("------------Unsorted Integer array");
        System.out.println(intArray);

        //2. sort and apply binary search
        Collections.sort(intArray);
        System.out.println("------------sorted Integer array");
        System.out.println(intArray);

        //3. apply binary search
        System.out.println("------------Given a random value, find it in the array");
        BinarySearch bs = new BinarySearch();
        Random randomNumber = new Random();
        int targetVal = randomNumber.nextInt(100);

        System.out.println("target value: "+targetVal);
        int targetIndex = bs.binarySearch(intArray,targetVal);
        System.out.println("target index: "+targetIndex);

        //4. try finding one that actually is there
        System.out.println("------------finding the last value of the array");
        int targetVal2 = intArray.get(intArray.size()-1);
        System.out.println("target value: "+targetVal2);
        int targetIndex2 = bs.binarySearch(intArray,targetVal2);
        System.out.println("target index: "+targetIndex2);





        //////// Exercise 3 ///////////////////////////////////////////////////////////////////////////////////
        /* write a program that sorts an array of integers
         * using one of the four: bubble sort, quick sort, insertion sort or selection sort
         * print the array before and after the sort
         *
         *
         * The class ArraySorter will have methods corresponding to the four different ways to sort
         */
        System.out.print("""
                -------------------| EXERCISE 3 |----------------------------------------------------------------

                """);


        // initialize ArraySorter
        ArraySorter arraysorter = new ArraySorter();


        // bubble sort
        System.out.println("------------Sort by bubble sort");
        ArrayList<Integer> intArray2 = generateRandomIntegerArray(5);
        arraysorter.bubbleSort(intArray2);

        // selection sort
        System.out.println("------------Sort by selection sort");
        ArrayList<Integer> intArray3 = generateRandomIntegerArray(5);
        arraysorter.selectionSort(intArray3);


        // quick sort
        System.out.println("------------Sort by selection sort");
        ArrayList<Integer> intArray4 = generateRandomIntegerArray(5);
        System.out.println("Array BEFORE quick sort: " + intArray4);
        arraysorter.quickSort(intArray4, 0, intArray4.size()-1);
        System.out.println("Array AFTER quick sort: " + intArray4);

        ////////
        System.out.println("--------------------choose a sorting algorithm");
        // ask for user input
        // first print the array
        ArrayList<Integer> intArray5 = generateRandomIntegerArray(8);
        System.out.println("Given the array: " + intArray5);

        Scanner scanner = new Scanner(System.in);
        // ask for input which sort to do
        System.out.println("""
                Choose a sorting algorithm.
                Enter the number that corresponds to one of the following:
                1 - Bubble sort
                2 - Selection sort
                3 - Quick sort
                Enter your number of choice here:\s""");

        //Read the input
        int choice = scanner.nextInt();
        if (choice == 1){
            // bubble sort
            System.out.println("------------Sort by bubble sort");
            arraysorter.bubbleSort(intArray5);
        }
        else if (choice == 2){
            System.out.println("------------Sort by selection sort");
            arraysorter.selectionSort(intArray5);
        }
        else if (choice == 3){
            System.out.println("------------Sort by selection sort");
            System.out.println("Array BEFORE quick sort: " + intArray5);
            arraysorter.quickSort(intArray5, 0, intArray5.size()-1);
            System.out.println("Array AFTER quick sort: " + intArray5);
        }
        else{
            System.out.println("Entered number is not recognized");
        }

        //chose scanner
        scanner.close();


    }// end of main function
}// end of main class