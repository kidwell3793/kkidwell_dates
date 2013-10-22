import java.util.*;

public class Main
{
	public Scanner scan = new Scanner(System.in);
	public int month, day, year;
	
	public void startup()
	{
		System.out.println("Press 1. Age Calculator \n2. Anniversary Calculator \n3. Age Difference Calculator");
		String choice = scan.nextLine();
		switch(choice)
		{
		case "1":
			ageCalculator();
			break;
		case "2":
			anniversaryCalculator();
			break;
		case "3":
			ageDifferenceCalculator();
			break;
		default:
			System.out.println("Not a valid choice. Try again.");
			startup();
			break;
		}
	}
	
	public void dateInput()
	{
		System.out.println("Enter the month (1-12)");
		month = scan.nextInt();
		System.out.println("Enter the day (1-31)");
		day = scan.nextInt();
		System.out.println("Enter the year");
		year = scan.nextInt();
	}
	
	public void ageCalculator()
	{
		dateInput();
		printYMD(dateDifference(new GregorianCalendar(year, month-1, day), new GregorianCalendar()));
	}
	
	public void anniversaryCalculator()
	{
		dateInput();
		printDHMS(dateDifference(new GregorianCalendar(), new GregorianCalendar(year + 1, month-1, day)));
	}
	
	public void ageDifferenceCalculator()
	{
		dateInput();
		GregorianCalendar date1 = new GregorianCalendar(year, month-1, day);
		dateInput();
		GregorianCalendar date2 = new GregorianCalendar(year, month-1, day);
		
		printYMD(dateDifference(date1, date2));
	}
	
	public GregorianCalendar dateDifference(GregorianCalendar date1, GregorianCalendar date2) 
	{
		date2.add(Calendar.YEAR, -date1.get(Calendar.YEAR));
		date2.add(Calendar.MONTH, -date1.get(Calendar.MONTH));
		date2.add(Calendar.DAY_OF_MONTH, -date1.get(Calendar.DAY_OF_MONTH));
		date2.add(Calendar.HOUR, -date1.get(Calendar.HOUR));
		date2.add(Calendar.MINUTE, -date1.get(Calendar.MINUTE));
		date2.add(Calendar.SECOND, -date1.get(Calendar.SECOND));
		
		return date2;
	}
	
	public void printYMD(GregorianCalendar date)
	{
		System.out.println("Difference between dates \nYears: " + date.get(Calendar.YEAR) + 
				" Months: " + date.get(Calendar.MONTH) + 
				" Days: " + (date.get(Calendar.DAY_OF_MONTH) - 1));
	}
	
	public void printDHMS(GregorianCalendar date)
	{
		System.out.println("Difference between dates \nDays: " + date.get(Calendar.DAY_OF_MONTH) + 
				" Hours: " + date.get(Calendar.HOUR) + 
				" Minutes: " + date.get(Calendar.MINUTE) + 
				" Seconds: " + date.get(Calendar.SECOND));
	}
	
	public static void main(String[] args) 
	{
		Main calendar = new Main();
		calendar.startup();
	}
}