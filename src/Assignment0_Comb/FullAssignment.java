package Assignment0_Comb;

import AlgTesting.ITask;
import AlgTesting.MyTester;

public class FullAssignment {
    public static void run() {

        System.out.println();
        System.out.println("Running all tasks from assignment 0.");
        System.out.println();
        System.out.println("Tasks:");
        System.out.println("+ Tasks 0: String Length.");
        System.out.println("  The function will run the tests.");
        System.out.println("+ Tasks 1: Tickets.");
        System.out.println("  The function will run the tests.");
        System.out.println("+ Tasks 2: Harry Potter Square.");
        System.out.println("  The function will write 12 squares to");
        System.out.println("  file SquarePatterns.out in data folder.");
        System.out.println("  Also it will print example of pattern 5");
        System.out.println("  to console.");


        System.out.println();
        System.out.println("Task 0: String Length.");
        ITask task0 = new StringLength();
        MyTester tester0 = new MyTester(task0, "/home/andrey/IdeaProjects/AlgorithmsOTUS/data/data_tickets/0.String");
        tester0.RunTests();

        System.out.println();
        System.out.println("Task 1: Tickets.");
        ITask task1 = new HappyTickets();
        MyTester tester1 = new MyTester(task1, "/home/andrey/IdeaProjects/AlgorithmsOTUS/data/data_tickets/1.Tickets");
        tester1.RunTests();

        System.out.println();
        System.out.println("Task 2: Harry Potter Square.");
        for (int i=1; i<=12; i++) {
            SquarePattern.writeSquarePatternToFile(i,
                    "/home/andrey/IdeaProjects/AlgorithmsOTUS/data/data_tickets/SquarePatterns.out");
        }
        System.out.println("Example of patter 5:");
        SquarePattern.printSquarePattern(5);
    }
}
