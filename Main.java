package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int TotalAmount=0;
	static Scanner sc = new Scanner(System.in);
	static List<Stationary> things =  new ArrayList<>();
	static List<Billing> Bill = new ArrayList<>();
	static String name;

	public static void main(String[] args) {
		Stationary Pencil   = new Stationary(1,"Pencil",3,30);
		Stationary Pen      = new Stationary(2,"Pen",5,20);
		Stationary Rubber    = new Stationary(3,"Rubber",2,10);
		Stationary InkBottle = new Stationary(4,"InkBottle",25,5);
		Stationary Gelpen    = new Stationary(5,"GelPen",10,4);
	
		things.add(Pencil);
		things.add(Pen);
		things.add(Rubber);
		things.add(InkBottle);
		things.add(Gelpen);
		System.out.println("Welcome to Stationary");
		System.out.println("Enter Your Name:");
		name = sc.nextLine();
		System.out.println("Enter Y to display All Available Things");
		char choice = sc.next().charAt(0);
		if(choice=='Y'||choice=='y') {
			displayThings();
		}else {
			System.out.println("Oops Okay:-(\nBYEeeee");
		}
	}
	public static void order() {
		
		System.out.println("Choose the things whatever you Want by clicking on the id");
		int Buyid=sc.nextInt();
		char again;
		switch(Buyid) {
		case 1:
			System.out.println("Enter the number of Pencils You Want");
			int pencilQuantity=sc.nextInt();		
			if(pencilQuantity<=things.get(0).getupdatedQuantity()) {
				TotalAmount=TotalAmount+(pencilQuantity*3);
				things.get(0).updateQuantity(pencilQuantity);
				Billing PencilBill = new Billing("Pencil",pencilQuantity, pencilQuantity*3);
				Bill.add(PencilBill);
				System.out.println("For to continue order press S or B for PayAmount & Bill or D to display the Menu");
				again=sc.next().charAt(0);
				if(again=='S'||again=='s') {
					order();
				}else if(again=='d'||again=='D'){
					displayThings();
				}else {
					printBill();
					System.out.println("Your Total Amount is "+TotalAmount);
				}}
			else {
				System.out.println("Sorry we only have "+things.get(0).getQuantity()+"pieces"+"Enter below the stock level");
				order();
			}
			break;
						
		case 2:
			System.out.println("Enter the number of Pen You Want");
			int penQuantity=sc.nextInt();
			if(penQuantity<=things.get(1).getupdatedQuantity()) {
				things.get(1).updateQuantity(penQuantity);
				TotalAmount=TotalAmount+(penQuantity*5);
				Billing PenBill = new Billing("PEN", penQuantity, penQuantity*5);
				Bill.add(PenBill);
				System.out.println("For to continue order press S or B for PayAmount & Bill D to display the Menu");
				again=sc.next().charAt(0);
				if(again=='S'||again=='s') {
					order();
				}else if(again=='d'||again=='D'){
					displayThings();
				}else {
					printBill();
					System.out.println("Your Total Amount is "+TotalAmount);
				}
			}else {
				System.out.println("Sorry we only have "+things.get(1).getQuantity()+"pieces"+"Enter below the stock level");
				order();
			}
			break;
		case 3:
			System.out.println("Enter the number of Rubber  You Want");
			int RubberQuantity=sc.nextInt();
			if(RubberQuantity<=things.get(2).getupdatedQuantity()) {
				things.get(2).updateQuantity(RubberQuantity);
				TotalAmount=TotalAmount+(RubberQuantity*2);
				Billing RubberBill = new Billing("RUBBER", RubberQuantity, RubberQuantity*2);
				Bill.add(RubberBill);
				System.out.println("For to continue order press S or B for PayAmount & Bill or D to display the Menu");
				again=sc.next().charAt(0);			
				if(again=='S'||again=='s') {
					order();
				}else if(again=='d'||again=='D'){
					displayThings();
				}else {
					printBill();
					System.out.println("Your Total Amount is "+TotalAmount);
				}
			}else {
				System.out.println("Sorry we only have "+things.get(2).getQuantity()+"pieces"+"Enter below the stock level");
				order();
			}
			break;
		case 4:
			System.out.println("Enter the number of InkBottle You Want");
			int InkQuantity=sc.nextInt();
			if(InkQuantity<=things.get(3).getupdatedQuantity()) {
				things.get(3).updateQuantity(InkQuantity);
				TotalAmount=TotalAmount+(InkQuantity*25);
				Billing InkBill = new Billing("INKBOTTLE", InkQuantity, InkQuantity*25);
				Bill.add(InkBill);
				System.out.println("For to continue order press S or B for PayAmount & Bill or D to display the Menu");
				again=sc.next().charAt(0);
				if(again=='S'||again=='s') {
					order();
				}else if(again=='d'||again=='D'){
					displayThings();
				}else {
					printBill();
					System.out.println("Your Total Amount is "+TotalAmount);
					
				}
			}else {
				System.out.println("Sorry we only have "+things.get(3).getQuantity()+"pieces"+"Enter below the stock level");
				order();
			}break;
		case 5:
			System.out.println("Enter the number of GelPen You Want");
			int GelPenQuantity=sc.nextInt();
			if(GelPenQuantity<=things.get(4).getupdatedQuantity()) {
				things.get(4).updateQuantity(GelPenQuantity);
				TotalAmount=TotalAmount+(GelPenQuantity*10);
				Billing GelPenBill = new Billing("GELPEN", GelPenQuantity, GelPenQuantity*10);
				Bill.add(GelPenBill);
				System.out.println("For to continue order press S or B for PayAmount&Bill or D to display the Menu");
				again=sc.next().charAt(0);
				if(again=='S'||again=='s') {
					order();
				}else if(again=='d'||again=='D'){
					displayThings();
				}else {
					printBill();
					System.out.println("Your Total Amount is "+TotalAmount);
				}
			}else {
				System.out.println("Sorry we only have "+things.get(4).getQuantity()+"pieces"+"Enter below the stock level");
				order();
			}
			break;
		default :
			System.out.println("Enter the correct id matching to Your Item");
			order();
		}
	}
	public static void displayThings() {
		
//		Iterator<Stationary> itr = things.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		for(Stationary s:things) {
			System.out.println(s);
		}
		System.out.println("For to Buy things press S or press Anyother to Exit:-)");
		System.out.println("Currently Your Payable Amount is "+TotalAmount);
		char choice2 = sc.next().charAt(0);
		if(choice2=='s'||choice2=='S') {
			order();  
		}else{
			System.out.println("Thank You for Visiting....");
		}		
	}
	public static void printBill() {
		Iterator<Billing> iter =Bill.iterator();
		 LocalDateTime now = LocalDateTime.now();  
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	     String formatDateTime = now.format(format); 
	     System.out.println("******Stationary Store********");
	     System.out.println("Customer Name is:"+name);
	     System.out.println("Purchased on:"+formatDateTime);
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}System.out.println("****Thank You For Shopping:-)*****");
	}
}

