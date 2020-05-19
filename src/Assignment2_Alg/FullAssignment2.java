package Assignment2_Alg;

import AlgTesting.ITask;
import AlgTesting.MyTester;

public class FullAssignment2 {
    public static void run() {

        System.out.println();
        System.out.println("Running all tasks from Assignment 1.");
        System.out.println("Tasks:");
        System.out.println("+ Tasks 1: GCD.");
        System.out.println("  Part 1: GCD through Euclid algorithm with reminders.");
        System.out.println("  Part 2: GCD through bit operations (division by 2).");
        System.out.println("+ Tasks 2: Fast power of number.");
        System.out.println("  Part 1: Simple method with multiplication.");
        System.out.println("  Part 2: Method that uses the power of 2.");


        System.out.println();
        System.out.println("Task 1: Part 1.");
        ITask task11 = new GCD("EUCLID");
        MyTester tester11 = new MyTester(task11, "/home/andrey/IdeaProjects/AlgorithmsOTUS/data/2_alg/2.GCD");
        tester11.RunTests();

        System.out.println();
        System.out.println("Task 1: Part 2.");
        ITask task12 = new GCD("BIT");
        MyTester tester12 = new MyTester(task12, "/home/andrey/IdeaProjects/AlgorithmsOTUS/data/2_alg/2.GCD");
        tester12.RunTests();

        System.out.println();
        System.out.println("Task 2: Part 1.");
        ITask task21 = new PowAlg("SIMPLE");
        MyTester tester21 = new MyTester(task21, "/home/andrey/IdeaProjects/AlgorithmsOTUS/data/2_alg/3.Power");
        tester21.RunTests();

        System.out.println();
        System.out.println("Task 2: Part 2.");
        ITask task22 = new PowAlg("POWER_OF_TWO");
        MyTester tester22 = new MyTester(task22, "/home/andrey/IdeaProjects/AlgorithmsOTUS/data/2_alg/3.Power");
        tester22.RunTests();
    }
}
