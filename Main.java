package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int totalAmount=0;
	static Scanner sc = new Scanner(System.in);
	static List<Stationary> stationaryThings =  new ArrayList<>();
	static List<Billing> bill = new ArrayList<>();
	static String customerName;
	
	public static void main(String[] args) {
		Stationary pencil   = new Stationary(1,"Pencil\t",3,30);
		Stationary pen      = new Stationary(2,"Pen\t",5,20);
		Stationary rubber    = new Stationary(3,"Rubber\t",2,10);
		Stationary inkBottle = new Stationary(4,"InkBottle",25,5);
		Stationary gelpen    = new Stationary(5,"GelPen\t",10,4);
	
		stationaryThings.add(pencil);
		stationaryThings.add(pen);
		stationaryThings.add(rubber);
		stationaryThings.add(inkBottle);
		stationaryThings.add(gelpen);
		Main main = new Main();
		System.out.println("\t*****Welcome to Stationary*****");
		main.inputMenu();
	}
	public void inputMenu() {
		System.out.print("Enter Your Name : ");
//		String namePattern = "[^\\p{P}|^\\d+]+";
//		true if name contains only alphabets, false - otherwise
//		boolean result =name.matches(namePattern);
		
		customerName = sc.nextLine();
		System.out.println(":-)Thank You for Entering Your Valuable Name\nThe Available Things Are");
		displayThings();
		
	}
	public void order() {
		
		System.out.println("Choose the things whatever you Want by clicking on the id");
		
		int buyId=sc.nextInt();
		if(buyId>=1 && buyId<=5)
		{
			process(buyId);
		}
		else
		{
			System.out.println("Enter the correct id matching to Your Item");
			order();
		}
	}

	public void displayThings() {
		System.out.println("Productid"+"\tProductname"+"\tPrice"+"\tQuantity");
		for(Stationary printStationaryThings:stationaryThings) {
			System.out.println(printStationaryThings);
		}
		System.out.println("For to Buy things press S or press Anyother to Exit:-)");
//		System.out.println("Currently Your Payable Amount is "+totalAmount);
		char choice2 = sc.next().charAt(0);
		if(choice2=='s'||choice2=='S') {
			order();  
		}else{
			System.out.println("Thank You for Visiting....");
		}		
	}
	public  void process(int buyid) {
		char continueProcess;
		System.out.println("Enter the number of "+stationaryThings.get(buyid-1).getProductName() +" You Want");
		int requiredQuantity=sc.nextInt();
		if(requiredQuantity<=stationaryThings.get(buyid-1).getupdatedQuantity()) {
			totalAmount=totalAmount+(requiredQuantity*stationaryThings.get(buyid-1).getPrice());
			stationaryThings.get(buyid-1).updateQuantity(requiredQuantity);
			Billing Billlist = new Billing(buyid, stationaryThings.get(buyid-1).getProductName(),requiredQuantity, requiredQuantity*stationaryThings.get(buyid-1).getPrice());
			bill.add(Billlist);
			System.out.println("For to continue order press S or B for PayAmount & Bill or D to display the Menu");
			continueProcess=sc.next().charAt(0);
			if(continueProcess=='S'||continueProcess=='s') {
				order();
			}else if(continueProcess=='d'||continueProcess=='D'){
				displayThings();
			}else {
				printBill();
			}}
		else {
			System.out.println("Sorry we only have "+stationaryThings.get(buyid-1).getQuantity()+"pieces Please Enter a Valid Quantity");
			order();
		}
	}
	public void printBill() {
		 Iterator<Billing> iterate =bill.iterator();
		 LocalDateTime now = LocalDateTime.now();  
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	     String formatDateTime = now.format(format); 
	     System.out.println("\t\t******Stationary Store********");
	     System.out.println("Customer Name : "+customerName);
	     System.out.println("Date & Time:"+formatDateTime);
	     System.out.println("Productid\t"+"Productname"+"\tQuantity"+"\tPrice");
		 while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}System.out.println("\tYour Total Payable Amount is Rupees : "+totalAmount);
		 System.out.println("****Thank You For Shopping:-)*****");
	}
}