import java.util.Scanner;

import FinancialTools.*;
import utils.InputHelper;

// Import all packages
import DataStructure.*;
import FileTools.*;
import FinancialTools.*;
import Games.*;
import HealthTools.*;
import ManagementTools.*;
import MathTools.*;
import TableGenerators.*;
import  TextTools.*;
import TimeDateTools.*;



public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu: Select a Category to view the projects  ---");
            System.out.println("1. Data Structure ");
            System.out.println("2. File Tools ");
            System.out.println("3. Financial Tools");
            System.out.println("4. Games");
            System.out.println("5. Health Tools");
            System.out.println("6. Management Tools");
            System.out.println("7. Math Tools");
            System.out.println("8. Table Generators");
            System.out.println("9. Text Tools");
            System.out.println("10. Time & Date Tools");
            System.out.println("11. Exit");

            int packageChoice = InputHelper.readInt(scanner, "Enter your choice (1-11): ");

            switch (packageChoice) {
                case 1 -> showDataStructureMenu(scanner);
                case 2 -> showFileToolsMenu(scanner);
                case 3 -> showFinancialToolsMenu(scanner);
                case 4 -> showGamesMenu(scanner);
                case 5 -> showHealthToolsMenu(scanner);
                case 6 -> showManagementToolsMenu(scanner);
                case 7 -> showMathToolsMenu(scanner);
                case 8 -> showTableGeneratorsMenu(scanner);
                case 9 -> showTextToolsMenu(scanner);
                case 10 -> showTimeDateToolsMenu(scanner);
                case 11 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Example: Data Structure Menu
    private static void showDataStructureMenu(Scanner scanner) {
        while (true){
        System.out.println("\n--- Data Structure Projects ---");
        System.out.println("1. Binary Tree Implementation");
        System.out.println("2. Custom Hash Map");
        System.out.println("3. Custom Linked List");
        System.out.println("4. Custom Queue");
        System.out.println("5. Custom Stack");
        System.out.println("6. Graph BTS Traversal");
        System.out.println("7. Graph DFS Traversal");
        System.out.println("8. Priority Queue Implementation");
        System.out.println("9. Searching Algorithm Demo");
        System.out.println("10. Sorting Algorithm Demo");
        System.out.println("11. Back");

        int choice = InputHelper.readInt(scanner, "Choose a project: ");

        switch (choice) {
            case 1 -> new BinaryTreeImplementation().run();
            case 2 -> new CustomHashMap<>().run();
            case 3 -> new CustomLinkedList().run();
            case 4 -> new CustomQueue().run();
            case 5 -> new CustomStack().run();
            case 6 -> new GraphBFSTraversal().run();
            case 7 -> new GraphDFSTraversal().run();
            case 8 -> new PriorityQueueImplementation().run();
            case 9 -> new SearchingAlgorithmDemo().run();
            case 10 -> new SortingAlgorithmDemo().run();
            case 11 -> { return; }
            default -> System.out.println("Invalid option.");
        }
    }
    }

    private static void showFileToolsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- File Tools Projects ---");
            System.out.println("1. Backup Folder Generator");
            System.out.println("2. Directory Size Scanner");
            System.out.println("3. File Comparator");
            System.out.println("4. File Decryption Tool");
            System.out.println("5. File Encryption Tool");
            System.out.println("6. File Merger");
            System.out.println("7. File Rename Utility");
            System.out.println("8. File Word Counter");
            System.out.println("9. Simple Log Analyzer");
            System.out.println("10. Text Formatter");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new BackupFolderGenerator().run(scanner);
                case 2 -> new DirectorySizeScanner().run(scanner);
                case 3 -> new FileComparator().run();
                case 4 -> new FileDecryptionTool().run();
                case 5 -> new FileEncryptionTool().run();
                case 6 -> new FileMerger().run();
                case 7 -> new FileRenameUtility().run();
                case 8 -> new FileWordCounter().run();
                case 9 -> new SimpleLogAnalyzer().run();
                case 10 -> new TextFormatter().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }


    private static void showFinancialToolsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Financial Tools Projects ---");
            System.out.println("1. Bank Interest Projection");
            System.out.println("2. Bill Splitter");
            System.out.println("3. Credit Card Payoff Estimator");
            System.out.println("4. Currency Converter");
            System.out.println("5. Interest Calculator");
            System.out.println("6. Investment Growth Calculator");
            System.out.println("7. Loan Calculator");
            System.out.println("8. Mortgage Calculator");
            System.out.println("9. Salary After Tax Calculator");
            System.out.println("10. Savings Goal Planner");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new BankInterestProjection().run();
                case 2 -> new BillSplitter().run();
                case 3 -> new CreditCardPayoffEstimator().run();
                case 4 -> new CurrencyConverter().run();
                case 5 -> new InterestCalculator().run();
                case 6 -> new InvestmentGrowthCalculator().run();
                case 7 -> new LoanCalculator().run();
                case 8 -> new MortgageCalculator().run();
                case 9 -> new SalaryAfterTaxCalculator().run();
                case 10 -> new SavingsGoalPlanner().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showGamesMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Games Projects ---");
            System.out.println("1. Coin Toss Simulator");
            System.out.println("2. Dice Roll Simulator");
            System.out.println("3. Hangman Game");
            System.out.println("4. Math Puzzle Game");
            System.out.println("5. Memory Matching Game");
            System.out.println("6. Minesweeper");
            System.out.println("7. Quiz Game");
            System.out.println("8. Random Adventure Generator");
            System.out.println("9. Rock Paper Scissors");
            System.out.println("10. Tic-Tac-Toe");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new CoinTossSimulator().run();
                case 2 -> new DiceRollSimulator().run();
                case 3 -> new HangmanGame().run();
                case 4 -> new MathPuzzleGame().run();
                case 5 -> new MemoryMatchingGame().run();
                case 6 -> new Minesweeper().run();
                case 7 -> new QuizGame().run();
                case 8 -> new RandomAdventureGenerator().run();
                case 9 -> new RockPaperScissors().run();
                case 10 -> new TicTacToe().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showHealthToolsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Health Tools Projects ---");
            System.out.println("1. Basal Metabolic Rate Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Body Fat Percentage Estimator");
            System.out.println("4. Calorie Burn Estimator");
            System.out.println("5. Calorie Estimator");
            System.out.println("6. Daily Step Estimator");
            System.out.println("7. Heart Rate Zone Calculator ");
            System.out.println("8. Ideal Weight Calculator");
            System.out.println("9. Sleep Cycle Assistant");
            System.out.println("10. Water Intake Calculator");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new BasalMetabolicRateCalculator().run();
                case 2 -> new BMICalculator().run();
                case 3 -> new BodyFatPercentageEstimator().run();
                case 4 -> new CalorieBurnEstimator().run();
                case 5 -> new CalorieEstimator().run();
                case 6 -> new DailyStepEstimator().run();
                case 7 -> new HeartRateZoneCalculator().run();
                case 8 -> new IdealWeightCalculator().run();
                case 9 -> new SleepCycleAssistant().run();
                case 10 -> new WaterIntakeCalculator().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showManagementToolsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Management Tools Projects ---");
            System.out.println("1. Appointment Scheduler");
            System.out.println("2. Basic To-Do List");
            System.out.println("3. Expense Tracker");
            System.out.println("4. Habit Tracker");
            System.out.println("5. Inventory Manager");
            System.out.println("6. Library Book Tracker");
            System.out.println("7. Notes Manager");
            System.out.println("8. Simple Bank Account");
            System.out.println("9. Simple CRM");
            System.out.println("10. Student Marks Calculator ");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new AppointmentScheduler().run();
                case 2 -> new BasicToDoList().run();
                case 3 -> new ExpenseTracker().run();
                case 4 -> new HabitTracker().run();
                case 5 -> new InventoryManager().run();
                case 6 -> new LibraryBookTracker().run();
                case 7 -> new NotesManager().run();
                case 8 -> new SimpleBankAccount().run();
                case 9 -> new SimpleCRM().run();
                case 10 -> new StudentMarksCalculator().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

        private static void showMathToolsMenu (Scanner scanner){
        while (true){
            System.out.println("\n--- Math Tools Projects ---");
            System.out.println("1. Basic Calculator");
            System.out.println("2. Equation Solver");
            System.out.println("3. Factorial Calculator");
            System.out.println("4. Fibonacci Generator");
            System.out.println("5. GCD/LCM Calculator");
            System.out.println("6. Matrix Calculator");
            System.out.println("7. Percentage Calculator");
            System.out.println("8. Pythagorean Theorem Solver");
            System.out.println("9. Scientific Calculator");
            System.out.println("10. Temperature Converter ");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new BasicCalculator().run();
                case 2 -> new EquationSolver().run();
                case 3 -> new FactorialCalculator().run();
                case 4 -> new FibonacciGenerator().run();
                case 5 -> new GCDLCMCalculator().run();
                case 6 -> new MatrixCalculator().run();
                case 7 -> new PercentageCalculator().run();
                case 8 -> new PythagoreanTheoremSolver().run();
                case 9 -> new ScientificCalculator().run();
                case 10 -> new TemperatureConverter().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    private static void showTableGeneratorsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Table Generator Projects ---");
            System.out.println("1. Age Sorter");
            System.out.println("2. Calendar For One Month");
            System.out.println("3. Daily Task Table");
            System.out.println("4. Employee Work Hours Table");
            System.out.println("5. Factor Table Generator");
            System.out.println("6. Multiplication Table Generator");
            System.out.println("7. Name Sorter");
            System.out.println("8. Prime NUmber Table Generator");
            System.out.println("9. Temperature Conversion Table");
            System.out.println("10. Weekly Meal Planner");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new AgeSorter().run();
                case 2 -> new CalendarForOneMonth().run();
                case 3 -> new DailyTaskTable().run();
                case 4 -> new EmployeeWorkHoursTable().run();
                case 5 -> new FactorTableGenerator().run();
                case 6 -> new MultiplicationTableGenerator().run();
                case 7 -> new NameSorter().run();
                case 8 -> new PrimeNumberTableGenerator().run();
                case 9 -> new TemperatureConversionTable().run();
                case 10 -> new WeeklyMealPlanner().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showTextToolsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Text Tools Projects ---");
            System.out.println("1. Acronym Generator");
            System.out.println("2. Anagram Checker");
            System.out.println("3. Camel Case To Snake Case Conversion");
            System.out.println("4. Duplicate Word Remover");
            System.out.println("5. Palindrome Checker");
            System.out.println("6. Random Username & Password Generator");
            System.out.println("7. Sentence Reverser");
            System.out.println("8. String Decoder");
            System.out.println("9. String Encoder");
            System.out.println("10. Text Summarizer");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new AcronymGenerator().run();
                case 2 -> new AnagramChecker().run();
                case 3 -> new CamelCaseToSnakeCaseConverter().run();
                case 4 -> new DuplicateWordRemover().run();
                case 5 -> new PalindromeChecker().run();
                case 6 -> new RandomUsernamePasswordGenerator().run();
                case 7 -> new SentenceReverser().run();
                case 8 -> new StringDecoder().run();
                case 9 -> new StringEncoder().run();
                case 10 -> new TextSummarizer().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showTimeDateToolsMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Time & Date  Tools Projects ---");
            System.out.println("1. Age In Month & Days Calculator");
            System.out.println("2. Countdown Timer");
            System.out.println("3. Day Of Week Calculator");
            System.out.println("4. Leap Year Checker");
            System.out.println("5. Product Expiry Calculator");
            System.out.println("6. Simple Alarm Logic");
            System.out.println("7. Stopwatch");
            System.out.println("8. Time Converter");
            System.out.println("9. Working Hours Calculator");
            System.out.println("10. World Clock");
            System.out.println("11. Back");

            int choice = InputHelper.readInt(scanner, "Choose a project: ");

            switch (choice) {
                case 1 -> new AgeInMonthsDaysCalculator().run();
                case 2 -> new CountdownTimer().run();
                case 3 -> new DayOfWeekCalculator().run();
                case 4 -> new LeapYearChecker().run();
                case 5 -> new ProductExpiryCalculator().run();
                case 6 -> new SimpleAlarmLogic().run();
                case 7 -> new Stopwatch().run();
                case 8 -> new TimeConverter().run();
                case 9 -> new WorkingHoursCalculator().run();
                case 10 -> new WorldClock().run();
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }

    }
}
