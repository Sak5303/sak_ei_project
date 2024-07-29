package ei;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice: 0-add, 1-remove, 2-view, 3-end");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 0:
                    //adding a new task in the list
                    System.out.println("Enter the description, start time, end time, priority (L/M/H):");
                    String input = sc.nextLine();
                    String[] inputs = input.split(" ");
                    String description = inputs[0];
                    int startTime = Integer.parseInt(inputs[1]);
                    int endTime = Integer.parseInt(inputs[2]);
                    char priority = inputs[3].charAt(0);
                    
                    Task t = new Task(description, startTime, endTime, priority);
                    add(t);
                    break;
                case 1:
                    System.out.println("Enter the description of the task to remove:");
                    String descToRemove = sc.nextLine();
                    remove(descToRemove);
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void add(Task t) {
        if (isConflicting(t)) {
            System.out.println("Error: Task conflicts with existing task.");
        } else {
            taskList.add(t);
            System.out.println("Task added successfully. No conflicts.");
        }
    }

    static void remove(String description) {
        for (Task t : taskList) {
            if (t.getDescription().equals(description)) {
                taskList.remove(t);
                System.out.println("Task removed successfully.");
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    static void view() {
        System.out.println("Task Description     Start Time     End Time     Priority");
        for (Task t : taskList) {
            System.out.printf("%s     %02d:00     %02d:00     %s\n", t.getDescription(), t.getStartTime(), t.getEndTime(), t.getPriority());
        }
    }

    static boolean isConflicting(Task newTask) {
        for (Task existingTask : taskList) {
            if ((newTask.getStartTime() < existingTask.getEndTime()) && (newTask.getEndTime() > existingTask.getStartTime())) {
                return true;
            }
        }
        return false;
    }
}
