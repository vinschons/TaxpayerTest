package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Taxpayer;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ArrayList<Taxpayer> list = new ArrayList<Taxpayer>();

		System.out.print("Enter the number of taxpayers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n ; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			String t = sc.next();
			Character type = t.charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if(type == 'i') {
				System.out.print("Healt expenditures: ");
				double healtcareExpenses = sc.nextDouble();
				Taxpayer tp = new Individual(name, annualIncome, healtcareExpenses);
				list.add(tp);
			}
			else {
				System.out.print("Number of employees: ");
				int employeeNumber = sc.nextInt();
				Taxpayer tp = new Company(name, annualIncome, employeeNumber);
				list.add(tp);
			}
		}
		
		System.out.println();
		
		System.out.println("TAXES PAID:");
		double totalTaxes = 0.00;
		for(Taxpayer tp : list) {
			totalTaxes += tp.totalTaxes();
			System.out.println(tp.toString());
		}
		
		System.out.println();
		
		System.out.print("TOTAL TAXES: $ " + totalTaxes);
		
		
		sc.close();
	}

}
