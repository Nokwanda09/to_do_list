
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean quit = false;
    static Scanner scanner;
    static String taskName;


    private static String menu(){
        return "What do you want to do:\n" +
                "   1. View tasks\n" +
                "   2. Add task\n" +
                "   3. Delete task\n" +
                "   4. Mark task done\n" +
                "   5. Quit\n";
    }

    private static String getInputFromUser(){
        scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        while (userInput.isEmpty()){
            System.out.println("Invalid input.");
            userInput = scanner.nextLine();
        }
         return userInput;
    }

    public static void main(String[] args) throws IOException {
        scanner = new Scanner(System.in);
        System.out.println(menu());

        while (!quit){
            String userOption = getInputFromUser();

            switch (Integer.parseInt(userOption)){

                case 5:
                    quit = true;
                    break;
                case 1:
                    TaskManager.viewTasks();
                    break;
                case 2:
                    System.out.print("Task name: ");
                    taskName = getInputFromUser();
                    TaskManager.addTask(new Task(taskName));
                    break;
                case 3:
                    System.out.print("Task name: ");
                    taskName = getInputFromUser();
                    TaskManager.deleteTask(new Task(taskName));
                    break;
                case 4:
                    System.out.print("Task name: ");
                    taskName = getInputFromUser();
                    TaskManager.markTaskDone(new Task(taskName));
                    break;
            }
            TaskManager.updateFile();
        }
    }



}
