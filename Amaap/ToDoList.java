

import java.io.*;
import java.text.*;
import java.util.*;


class ToDoList {
	// ArrayList to store multiple tasks
	List<List<Object>> toDoList = new ArrayList<>();

	ArrayList<Date> dueRemainderDates = new ArrayList<>();

	private static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

	InputStreamReader ir = new InputStreamReader(System.in);

	BufferedReader br = new BufferedReader(ir);

	Scanner s = new Scanner(System.in);

	Date cDate = new Date(); // setting current date to cDate

	// task detail inputs
	String description;
	Date dueDate;
	int priorities;
	String isDone = "Not Completed";

	// method to add task
	public void add() {

		// ArrayList to store task details
		List<Object> task = new ArrayList<>();
		System.out.println(" \nEnter following detail of task");

		// Takink Description of task as a Input
		System.out.print("Description : \t");
		try {
			description = br.readLine();
			task.add(description);
			String duedate;
			// Takink Due Date of ask as a Input
			System.out.print("\nDue Date    : \t");
			duedate = s.next();
			
			try {
				dueDate = df.parse(duedate);
				if (dueDate.after(cDate) )  {
					task.add(dueDate);
					dueRemainderDates.add(dueDate);

					// Takink Priority of Task as a Input
					
					System.out.print("\nEnter Numerical Priority between (1 to 10)\nPriority :\t ");
					priorities = s.nextInt();
					if (priorities >= 1 && priorities <= 10) {

						task.add(priorities);
						task.add(isDone);
						System.out.println("\nCongrulations!!!\nTask Added Sucessfully...");
						toDoList.add(task);


					}
					else {
					System.out.println("\n\nEnter  Correct Priority in range ( 1 to 10 ).");
				}
					
					
				} else {
					System.out.println("\n\nEnter  Correct Due Dates of Future.");
				}
			} catch (Exception excep) {
				System.out.println("Enter Due Date Format as Shown dd-mm-yyyy.");
			}


		} catch (Exception excep) {
			System.out.println("Enter Valid Input......\n");
		}
	}

	public void mark() {
		
		
		if (toDoList.isEmpty()){
			System.out.println("\n\t----------------------------------------------------------------------\n");
			System.out.println("\t\t\t\t No Available Tasks\n");
			System.out.println("\t----------------------------------------------------------------------\n");
			System.out.println("Tasks are not there in To-Do List.");
		}
		else{
			System.out.println("\n\n\t----------------------------------------------------------------------\n");
			for (int i = 0; i < toDoList.size(); i++) {
				System.out.print("  |  " + (i + 1) + "  |  " + toDoList.get(i).get(0) + "  |  " + df.format((Date) toDoList.get(i).get(1))+ "  |  "+ toDoList.get(i).get(2)+ "  |  "+ toDoList.get(i).get(3)+ "  |  \n");
			}
			System.out.println("\n\n\t----------------------------------------------------------------------\n");
			System.out.print("Enter Serial No. To Mark Task As Completed\n\nEnter Sr. No. :  ");
			try {
				int no = s.nextInt();
				if (no > 0 && no <= toDoList.size() && toDoList.get(no - 1).get(3).equals("Not Completed")&& toDoList != null) {
					toDoList.get(no - 1).set(3, "Completed");
					System.out.println("Congrulations you have completed Your To-Do Task......\n\nIt's Time to Celebrate\n\nLets Celebrate!!!!!!");
				} else {
					System.out.println("Enter Correct Sr. No. ...");
				}
			} catch (Exception excep) {
				System.out.println("\n Enter vaild Input..\n ");
			}
		}
	}

	// method to Delete all Completed To-Do Tasks

	public void delete() {
		int flag = 0, x = 1;
		System.out.println("\n\n\t----------------------------------------------------------------------\n");
		for (int i = 0; i < toDoList.size();) {
			if (toDoList.get(i).get(3).equals("Completed")) {
				System.out.println("  |  " + x + "  |  " + toDoList.get(i).get(0) + "  |  " + df.format((Date) toDoList.get(i).get(1))+ "  |  "+ toDoList.get(i).get(2)+ "  |  "+ toDoList.get(i).get(3)+ "  |  ");
				toDoList.remove(i);
				flag = 1;
				x++;
			} else {
				i++;
			}
		}

		if (flag == 0) {
			System.out.println("\t\t\t\t No Available Tasks\n");
			System.out.println("\t----------------------------------------------------------------------\n");
			System.out.println("Completed tasks are not there in To-Do List");
		} else {
			System.out.println("\n\n\t----------------------------------------------------------------------\n");

			System.out.println("\nThis all above Tasks are Completed So it is Removed From To-Do List");
		}
	}


// method to view pending tasks
public void  pending() {
		int flag = 0;
		System.out.println("\n\t----------------------------------------------------------------------\n");
		for (int i = 0; i < toDoList.size();i++) {
			if (toDoList.get(i).get(3).equals("Not Completed")) {
				System.out.println("  |  " + i + "  |  " + toDoList.get(i).get(0) + "  |  " + df.format((Date) toDoList.get(i).get(1))+ "  |  "+ toDoList.get(i).get(2)+ "  |  "+ toDoList.get(i).get(3)+ "  |  ");
				flag=1;
			} 
		}
		if (flag == 0) {
			System.out.println("\t\t\t\t No Available Tasks\n");
			System.out.println("\t----------------------------------------------------------------------\n");
			System.out.println("Tasks are not there in To-Do List");
		} else {
			System.out.println("\n\n\t----------------------------------------------------------------------\n");
			System.out.println("\nThis all above Tasks are Not Completed \n");
		}

}


	// method to view all To-Do Tasks
	public void view() {
		int ch;
		List<List<Object>> temptoDoList = new ArrayList<>();
		if (toDoList.isEmpty()){
			System.out.println("\n\t----------------------------------------------------------------------\n");
			System.out.println("\t\t\t\t No Available Tasks\n");
			System.out.println("\t----------------------------------------------------------------------\n");
			System.out.println("Tasks are not there in To-Do List");
		}
		else{
				System.out.print("1. Sort by Priority\n2. Sort by Due Date\n3. Sort by Creation Date\n\nEnter Choice : ");
			ch = s.nextInt();
			temptoDoList = toDoList;
		
				//Sorting By Priority
			if (ch == 1) {
				
				System.out.println("\n\t\tTo-Do List Sorted by Priority\n\n");
				System.out.println("\n\n\t----------------------------------------------------------------------\n");
		
				
				toDoList.sort(Comparator.comparing(priorities -> (Integer) priorities.get(2)));

				for (int i = 0; i < toDoList.size(); i++) {
					System.out.println("  |  " + (i + 1) + "  |  " + toDoList.get(i).get(0) + "  |  "+ df.format((Date) toDoList.get(i).get(1))+ "  |  "+ toDoList.get(i).get(2)+ "  |  "+ toDoList.get(i).get(3)+ "  |  \n");
				}
				System.out.println("\n\t----------------------------------------------------------------------\n\n");
			} 
		
			//Sorting by Due Date
			else if (ch == 2) {
				System.out.println("\n\t\tTo-Do List Sorted by Due Date\n\n");
				System.out.println("\n\n\t----------------------------------------------------------------------\n");
				toDoList.sort(Comparator.comparing(dueDate -> (java.util.Date) dueDate.get(1)));
				for (int i = 0; i < toDoList.size(); i++) {
					System.out.println("  |  " + (i + 1) + "  |  " + toDoList.get(i).get(0) + "  |  "+ df.format((Date) toDoList.get(i).get(1))+ "  |  "+ toDoList.get(i).get(2)+ "  |  "+ toDoList.get(i).get(3)+ "  |  \n");
				}
				System.out.println("\n\t----------------------------------------------------------------------\n\n");
			} 
		
			//Sorting by Creation Order
			else if (ch == 3) {
				System.out.println("\n\t\tTo-Do List Sorted by Creation Date\n\n");
				System.out.println("\n\n\t----------------------------------------------------------------------\n");
				for (int i = 0; i < temptoDoList.size(); i++) {
					System.out.println("  |  " + (i + 1) + "  |  " + temptoDoList.get(i).get(0) + "  |  "+ df.format((Date) temptoDoList.get(i).get(1))+ "  |  "+ temptoDoList.get(i).get(2)+ "  |  "+ temptoDoList.get(i).get(3)+ "  |  \n");
				}
				System.out.println("\n\t----------------------------------------------------------------------\n\n");
			} 
			else {
			System.out.println("Enter Correct Choice......");
			}
		}
	}

// method for Remainder 
	public void remainder() {
		
		for (int i = 0; i < dueRemainderDates.size(); i++) {
	
			Date dDate = dueRemainderDates.get(i);
			toDoList.sort(Comparator.comparing(dueDate -> (java.util.Date) dueDate.get(1)));
			
			if (dDate.equals(cDate)) {
				
				System.out.println("\n\n\t\tRemainder!!!!!!!\n\n\t\tCheck your To-Do Taks List \n\t\tToday is Due Date Of task\n\n");
			
				
				System.out.println("  |  " + (i +1) + "  |  " + toDoList.get(i).get(0) + "  |  "+ df.format((Date) toDoList.get(i).get(1))+ "  |  "+ toDoList.get(i).get(2)+ "  |  "+ toDoList.get(i).get(3)+ "  |  \n");
			
			} 
		}
	}

}