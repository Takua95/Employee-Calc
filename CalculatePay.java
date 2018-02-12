
//Christian Brannon, ID: 1593881
//ITSE 2317-5001, 01.22.18
//Assignment: Pay Calculator

//Main File

/*
 *This program calculates the pay of an employee based on
 *skill level and whether he obtained overtime or not.  It also
 *adds the insurance deductions if the employee has enlisted
 *into those options.
 */

import java.io.*; 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculatePay
{
	//Constants
	final static double SKILL_ONE_PAY = 17.00;
	final static double SKILL_TWO_PAY = 20.00;
	final static double SKILL_THREE_PAY = 22.00;
	final static double INS_MED = 32.50;
	final static double INS_DENT = 20.00;
	final static double INS_DIS = 10.00;
	final static double OVERTIME_RATE = 1.5;
	final static double RETIREMENT_RATE = 0.03;
		
    public static void main(String[] args)
	{
		//Variables
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		int selection;
		ArrayList<Employee> Employees = new ArrayList<Employee>();
		
		while(!exit)
		{
			System.out.print(
			"\n\n---------- Payroll Calculator ----------"+
			"\n"+
			"1: Calculate Employee Pay\n"+
			"2: (Unavailable) Create Employee\n"+
			"3: (Unavailable) Remove Employee\n"+
			"4: (Unavailable) View Employees\n"+
			"5: (Unavailable) Search for Employee\n"+
			"6: Exit\n"+
			"\n->");
			selection = input.nextInt();
			switch (selection)
			{
				case 1:
					CreateEmployee(Employees);
					break;
				case 2:
					System.out.print("\nOption Not Available....\n");
					break;
				case 3:
					System.out.print("\nOption Not Available....\n");
					break;
				case 4:
					System.out.print("\nOption Not Available....\n");
					break;
				case 5:
					System.out.print("\nOption Not Available....\n");
					break;
				case 6:
					System.out.print("\nGoodbye!");
					exit = true;
					break;
				default:
					System.out.print("\nThat was an invalid option!");
					break;
			}
		}
	}
	
	public static void CreateEmployee(ArrayList<Employee> Employees)
	{
		/*Planned: 
		 *This was going to be in a try catch statement to make sure
		 *there wouldn't be any bad input...  The array list was going
		 *to be used as well.
		 */
		
		Scanner input = new Scanner(System.in);
		char placeholder;
		String name;
		int skill;
		double hours;
		boolean medical = false, dental = false, disability = false, retirement = false;
		int size = Employees.size();
		double gross, net = 0, overtimePay = 0, regularPay;
		
		System.out.print("\nPlease enter the employee's name: \n->");
		name = input.nextLine();
		System.out.print("\nPlease enter the employee's skill level (1, 2 or 3): \n->");
		skill = input.nextInt();
		System.out.print("\nPlease enter the employee's hours worked: \n->");
		hours = input.nextDouble();
		System.out.print("\nPlease enter whether the employee has enrolled in medical insurance (y/n): \n->");
		placeholder = input.next(".").charAt(0);
		if (placeholder == 'y')
			medical = true;
		else
			medical = false;
		System.out.print("\nPlease enter whether the employee has enrolled in dental insurance (y/n): \n->");
		placeholder = input.next(".").charAt(0);
		if (placeholder == 'y')
			dental = true;
		else
			medical = false;
		System.out.print("\nPlease enter whether the employee has enrolled in long-term disability insurance (y/n): \n->");
		placeholder = input.next(".").charAt(0);
		if (placeholder == 'y')
			disability = true;
		else
			medical = false;
		System.out.print("\nPlease enter whether the employee has enrolled in a retirement plan (y/n): \n->");
		placeholder = input.next(".").charAt(0);
		if (placeholder == 'y')
			retirement = true;
		else
			medical = false;
		
		System.out.print("\nIs this information correct? (y/n): \n->");
		placeholder = input.next(".").charAt(0);
		if (placeholder == 'y')
			Employee employee = new Employee(name, skill, hours, medical, dental, disability, retirement);
		else
			System.out.print("\nInfo not saved!");
		
		System.out.print("\n\n"+
		"Employee Name: " + employee.getName() + "\n" +
		"Employee skill: " + employee.getSkill() + "\n" +
		"Employee Total Hours: " + employee.getHours() + "\n");
		
		
		switch (employee.getSkill())
		{
			case 1:
				if (employee.getHours() > 40.0)
				{
					overtimePay = (employee.getHours() - 40) *  (SKILL_ONE_PAY * OVERTIME_RATE);
					employee.setHours(40);
				}
				System.out.print("Regular Pay: $" + (employee.getHours() * SKILL_ONE_PAY));
				System.out.print("\nOvertime Pay: $" + overtimePay);
				gross = (employee.getHours() * SKILL_ONE_PAY) + overtimePay;
				break;
			case 2:
				if (employee.getHours() > 40.0)
				{
					overtimePay = (employee.getHours() - 40) *  (SKILL_TWO_PAY * OVERTIME_RATE);
					employee.setHours(40);
				}
				System.out.print("Regular Pay: $" + (employee.getHours() * SKILL_TWO_PAY));
				System.out.print("\nOvertime Pay: $" + overtimePay);
				gross = (employee.getHours() * SKILL_TWO_PAY) + overtimePay;
				break;
			case 3:
				if (employee.getHours() > 40.0)
				{
					overtimePay = (employee.getHours() - 40) *  (SKILL_THREE_PAY * OVERTIME_RATE);
					employee.setHours(40);
				}
				System.out.print("Regular Pay: $" + (employee.getHours() * SKILL_THREE_PAY));
				System.out.print("\nOvertime Pay: $" + overtimePay);
				gross = (employee.getHours() * SKILL_THREE_PAY) + overtimePay;
				break;
			default:
				if (employee.getHours() > 40.0)
				{
					overtimePay = (employee.getHours() - 40) *  (SKILL_ONE_PAY * OVERTIME_RATE);
					employee.setHours(40);
				}
				System.out.print("Regular Pay: $" + (employee.getHours() * SKILL_ONE_PAY));
				System.out.print("\nOvertime Pay: $" + overtimePay);
				gross = (employee.getHours() * SKILL_ONE_PAY) + overtimePay;
				break;
		}
		
		net = gross;
		//I should have used a var to hold some of these sentences and used printf to modify them
		if (employee.getRetirement() == true)
		{
			System.out.print("\n" + "Retirement: Currently Enrolled\nCost: $" + (gross * RETIREMENT_RATE) + "\n\n");
			net -= (gross * RETIREMENT_RATE);
		} 
		else
			System.out.print("Retirement: Currently not Enrolled\n");
		if (employee.getMedical() == true)
		{
			System.out.print("Medical: Currently Enrolled\nCost: $" + INS_MED + "\n\n");
			net -= INS_MED;
		}
		else
			System.out.print("Medical: Currently not Enrolled\n");
		if (employee.getDental() == true)
		{
			net -= INS_DENT;
			System.out.print("Dental: Currently Enrolled\nCost: $" + INS_DENT + "\n\n");
		}
		else
			System.out.print("Dental: Currently not Enrolled\n");
		if (employee.getDisability() == true)
		{
			net -= INS_DIS;
			System.out.print("Disability: Currently Enrolled\nCost: $" + INS_DIS + "\n\n");
		}
		else
			System.out.print("Disability: Currently not Enrolled\n");

		System.out.print("\n" + "\n" + "Gross Pay: $" + gross);
		System.out.print("\n\nNet Pay: $" + net + "\n\n");
	}
}