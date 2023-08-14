import java.util.*;

class taskmanager {
    public static void main(String a[]) {
    Scanner s = new Scanner(System.in);
    System.out.println("\n\n~~~~\t\tWelcome to TaskMaster\t\t~~~~\n\n");
    ToDoList  toDoList = new ToDoList();
    System.out.println("\n\nTo Do List Manager Commands.....\n\n add    \t-> \t To add Task into To-Do_List\n mark   \t-> \t TO Mark Task as Completed \n delete \t-> \t To Delete the Completed Task \n pending   \t-> \t To see Pending Tasks by Priorities\n view   \t-> \t TO View Task List \n exit   \t-> \t To Exit from the To Do List Manager");
    while (true) {
        System.out.print("\n\nEnter CMD Command \n>>");
        String cmd = s.next();
        switch (cmd) {
            case "add":
                System.out.println("\n\t>> Add Task in To-Do List\n");
                toDoList.add();
                break;


				case "mark":
					System.out.println("\n\t>> Mark Completed Task\n");
					toDoList.mark();
					break;
					
				case "pending":
					System.out.println("\n\t>> Pending / Not Completed Tasks\n");
					toDoList.pending();
					break;

				case "delete":
					System.out.println("\n\t>> Delete Completed Task...\n");
					toDoList.delete();
					break;

				case "view":
					System.out.println("\n\t>> View All To-Do List Tasks\n");
					toDoList.view();
					break;

				case "exit":
					System.out.println("Exited from Task Manager Sucessfully.....");
					System.exit(0);
					break;

				default:
					System.out.println("\n\nYou Entered Wrong Command\nPlese Enter Correct Command");

			}

			toDoList.remainder();

		}
	}
}
