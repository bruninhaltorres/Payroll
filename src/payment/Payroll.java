package src.payment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DayOfWeek;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

import src.employees.Employees;

public class Payroll{

	public static void payEmployees(ArrayList<Employees> listEmployee, Payroll payroll) {
		Scanner input = new Scanner(System.in);
		printEmployees(listEmployee);
		LocalDate today = LocalDate.now();
		List<Employee> employeesToPay = new ArrayList<Employee>();
		int size = listEmployee.size();
		int i;

		if(today.getDayOfMonth() == 27 || today.getDayOfMonth() == 29 || today.getDayOfMonth() == 30 ||today.getDayOfMonth() == 31){
			// pay salaried
			System.out.println("Today is " + today.getDayOfMonth() + " of " + today.getMonth() + ". It's time to pay salaried employees.\n");
			System.out.println("These are the employees that got paid today:\n");
			for(i = 0; i < size; i++){
				if(employeesList.get(i).getPaymentDay() == "Monthly - Last day of the month"){
					employeesToPay.add(employeesList.get(i));
					System.out.println(employeesList.get(i).getName());
					System.out.println("\n");
				}
			}
		}
		else if(today.getDayOfWeek() == DayOfWeek.FRIDAY){
			// pay hourly
			System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay Hourly employees.\n");
			System.out.println("These are the employees that got paid today:\n");
			for(i = 0; i < size; i++){
				if(employeesList.get(i).getPaymentDay() == "Weekly - Every friday"){
					employeesToPay.add(employeesList.get(i));
					System.out.println(employeesList.get(i).getName());
					System.out.println("\n");
				}
			}
			int fridays = 0;



			if(fridays % 2 == 0){
				// pay commissioned
				System.out.println("Today is " + today.getDayOfWeek() + ". It's time to pay commissioned employees.\n");
				System.out.println("These are the employees that got paid today:\n");
				for(i = 0; i < size; i++){
					if(employeesList.get(i).getPaymentDay() == "Bi-weekly - Friday"){
						employeesToPay.add(employeesList.get(i));
						System.out.println(employeesList.get(i).getName());
						System.out.println("\n");
					}
				}
			}
			fridays++;
		} else System.out.println("The company don't have any employees to pay today.\n");
	}
}
