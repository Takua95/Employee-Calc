
//Christian Brannon, ID: 1593881
//ITSE 2317-5001, 01.22.18
//Assignment: Pay Calculator

//Main File

/*
	This program calculates the pay of an employee based on
skill level and wether he obtained overtime or not.  It also
adds the insurance deductions if the employee has enlisted
into those options.
*/

import java.io.*; 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CalculatePay
{
    public static void main(String[] args)
	{
		//Constants
		final double SKILL_ONE_PAY = 17.00;
		final double SKILL_TWO_PAY = 20.00;
		final double SKILL_THREE_PAY = 22.00;
		final double INS_MED = 32.50;
		final double INS_DENT = 20.00;
		final double INS_DIS = 10.00;
		final double OVERTIME_RATE = 1.5;
		final double RETIREMENT_RATE = 0.03;
		
		//Variables
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		int selection;
		ArrayList<Employee> Employees = new ArrayList<Employee>(1);
		
		while(!exit)
		{
			System.out.print(
			"---------- Payroll Calculator ----------"+
			"\n"+
			"1: Create Employee\n"+
			"2: Remove Employee\n"+
			"3: View Employees\n"+
			"4: Search for Employee\n"+
			"5: Exit\n"+
			"\n->");
			selection = input.nextInt();
			switch (selection)
			{
				case 1:
					CreateEmployee(Employees);
					break;
				case 2:
					System.out.print(Employees.get(0).getName());
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					break;
			}
		}
	}
	
	public static void CreateEmployee(ArrayList<Employee> Employees)
	{
		int size = Employees.size();
		System.out.print(size);
		System.out.print("\nPlease enter the employee's name: \n->");
		String name = "NULL";
		int skill = 0;
		double hours = 0.0;
		boolean medical = false;
		boolean dental = false;
		boolean disability = false;
		boolean retirement = false;
		Employees.add(new Employee());
		System.out.print(Employees.get(size).getName());
	}
}