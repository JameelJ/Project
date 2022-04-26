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
	static List<Stationary> Stationaythings =  new ArrayList<>();
	static List<Billing> Bill = new ArrayList<>();
	static String name;
	int Buyid;
	

	public static void main(String[] args) {
		Stationary pencil   = new Stationary(1,"Pencil\t",3,30);
		Stationary pen      = new Stationary(2,"Pen\t",5,20);
		Stationary rubber    = new Stationary(3,"Rubber\t",2,10);
		Stationary inkBottle = new Stationary(4,"InkBottle",25,5);
		Stationary gelpen    = new Stationary(5,"GelPen\t",10,4);
	
		Stationaythings.add(pencil);
		Stationaythings.add(pen);
		Stationaythings.add(rubber);
		Stationaythings.add(inkBottle);
		Stationaythings.add(gelpen);
		Main main = new Main();
		System.out.println("*****Welcome to Stationary*****");
		main.inputMenu();
	}
	public void inputMenu() {
		System.out.println("Enter Your Name:");
		String namePattern = "[^\\p{P}|^\\d+]+";
		//true if name contains only alphabets, false - otherwise
		name = sc.next();
		boolean result =name.matches(namePattern);
		if(result==true) {
			System.out.println("Enter Y to display All Available Things");
			char choice = sc.next().charAt(0);
			if(choice=='Y'||choice=='y') {
				displayThings();
			}else {
				System.out.println("Oops Okay:-(\nBYEeeee");
			}
		}else {
			System.out.println("Please Enter a ProperName");
			main(null);
		}
	}
	public void order() {
		
		System.out.println("Choose the things whatever you Want by clicking on the id");
		int Buyid=sc.nextInt();
		if(Buyid>=1 && Buyid<=5)
		{
			process(Buyid);
		}
		else
		{
			System.out.println("Enter the correct id matching to Your Item");
			order();
		}
	}

	public void displayThings() {
		System.out.println("Productid"+"\tProductname"+"\tPrice"+"\tQuantity");
		for(Stationary s:Stationaythings) {
			System.out.println(s);
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
		char again;
		System.out.println("Enter the number of "+Stationaythings.get(buyid-1).getProductName() +" You Want");
		int quantity=sc.nextInt();
		if(quantity<=Stationaythings.get(buyid-1).getupdatedQuantity()) {
			totalAmount=totalAmount+(quantity*Stationaythings.get(buyid-1).getPrice());
			Stationaythings.get(buyid-1).updateQuantity(quantity);
			Billing Billlist = new Billing(buyid, Stationaythings.get(buyid-1).getProductName(),quantity, quantity*Stationaythings.get(buyid-1).getPrice());
			Bill.add(Billlist);
			System.out.println("For to continue order press S or B for PayAmount & Bill or D to display the Menu");
			again=sc.next().charAt(0);
			if(again=='S'||again=='s') {
				order();
			}else if(again=='d'||again=='D'){
				displayThings();
			}else {
				printBill();
			}}
		else {
			System.out.println("Sorry we only have "+Stationaythings.get(buyid-1).getQuantity()+"pieces"+"Enter below the stock level");
			order();
		}
	}
	public void printBill() {
		 Iterator<Billing> iter =Bill.iterator();
		 LocalDateTime now = LocalDateTime.now();  
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	     String formatDateTime = now.format(format); 
	     System.out.println("\t\t******Stationary Store********");
	     System.out.println("Customer Name : "+name);
	     System.out.println("Date & Time:"+formatDateTime);
	     System.out.println("Productid\t"+"Productname"+"\tPrice"+"\tQuantity");
		 while(iter.hasNext()) {
			System.out.println(iter.next());
		}System.out.println("\tYour Total Amount is "+totalAmount);
		 System.out.println("****Thank You For Shopping:-)*****");
	}
}