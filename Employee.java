
//Christian Brannon, ID: 1593881
//ITSE 2317-5001, 01.22.18
//Assignment: Pay Calculator

//Employee Class File

/*
	This program calculates the pay of an employee based on
skill level and whether he obtained overtime or not.  It also
adds the insurance deductions if the employee has enlisted
into those options.
*/



public class Employee
{
	private String name;
	private int skill;
	private double hours;
	private boolean medical;
	private boolean dental;
	private boolean disability;
	private boolean retirement;
	
	public Employee()
	{
		name = "NULL";
		skill = 0;
		hours = 0.0;
		medical = false;
		dental = false;
		disability = false;
		retirement = false;
	}
	
	public Employee(String name, int skill, double hours, boolean medical, boolean dental, boolean disability, boolean retirement)
	{
		this.name = name;
		this.skill = skill;
		this.hours = hours;
		this.medical = medical;
		this.dental = dental;
		this.disability = disability;
		this.retirement = retirement;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setSkill(int skill)
	{
		this.skill = skill;
	}
	
	public void setHours(double hours)
	{
		this.hours = hours;
	}
	
	public void setMedical(boolean medical)
	{
		this.medical = medical;
	}
	
	public void setDental(boolean dental)
	{
		this.dental = dental;
	}
	
	public void setdisability(boolean disability)
	{
		this.disability = disability;
	}
	
	public void setRetirement(boolean retirement)
	{
		this.retirement = retirement;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSkill()
	{
		return skill;
	}
	
	public double getHours()
	{
		return hours;
	}
	
	public boolean getMedical()
	{
		return medical;
	}
	
	public boolean getDental()
	{
		return dental;
	}
	
	public boolean getDisability()
	{
		return disability;
	}
	
	public boolean getRetirement()
	{
		return retirement;
	}
}