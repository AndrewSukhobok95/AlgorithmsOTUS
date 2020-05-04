import AlgTesting.ITask;
import AlgTesting.MyTester;
import Assignment0_Recursion.HappyTickets;
import Assignment0_Recursion.SquarePattern;
import Assignment0_Recursion.StringLength;



public class Main {
    public static void main(String[] args) {

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
        //System.out.println("Example of patter 5:");
        //SquarePattern.printSquarePattern(5);

    }
}
