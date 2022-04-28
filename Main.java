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
	static List<Product> items =  new ArrayList<>();
	static List<ProductBill> bill = new ArrayList<>();
	static String customerName;
	
	public static void main(String[] args) {
		Product pencil   = new Product(1,"Pencil\t",3,30);
		Product pen      = new Product(2,"Pen\t",5,20);
		Product rubber    = new Product(3,"Rubber\t",2,10);
		Product inkBottle = new Product(4,"InkBottle",25,5);
		Product gelpen    = new Product(5,"GelPen\t",10,4);
	
		items.add(pencil);
		items.add(pen);
		items.add(rubber);
		items.add(inkBottle);
		items.add(gelpen);
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
		System.out.println(":-)Thank You for Entering Your Valuable Name\nThe Available Items Are");
		initialDisplayItem();	
	}
	public void gettingProductId() {
		System.out.println("Choose the things whatever you Want by clicking on the id");		
		int productId=sc.nextInt();
		if(productId>=1 && productId<=5)
		{
			gettingRequiredQuantity(productId);
		}
		else
		{
			System.out.println("Enter the correct id matching to Your Item");
			gettingProductId();
		}
	}
	public void displayInput() {
		System.out.println("Productid"+"\tProductname"+"\tPrice"+"\tQuantity");
		for(Product printStationaryThings:items) {
			System.out.println(printStationaryThings);
		}
		System.out.println("To Buy things press S or press Anyother to Exit:-)");
	}
	public void initialDisplayItem() {
		displayInput();
		char choice2 = sc.next().charAt(0);
		if(choice2=='s'||choice2=='S') {
			gettingProductId();  
		}else{
			System.out.println("Thank You for Visiting....");
		}		
	}
	public void displayItemsAgain() {
		displayInput();
		System.out.println("Currently Your Payable Amount is "+totalAmount);
		char choice2 = sc.next().charAt(0);
		if(choice2=='s'||choice2=='S') {
			gettingProductId();  
		}else{
			printBill();													//printing Bill and Current Amount
			System.out.println("Thank You for Visiting....");
		}		
	}
	public void gettingRequiredQuantity(int productBuyId) {
		System.out.println("Enter the number of "+items.get(productBuyId-1).getProductName() +" You Want");
		int getRequiredQuantity=sc.nextInt();
		process(productBuyId,getRequiredQuantity);
	}
	public void process(int productBuyid,int requiredQuantity) {
		if(requiredQuantity<=items.get(productBuyid-1).getupdatedQuantity()) {
			calculateTotalAmount(productBuyid, requiredQuantity);
			updateStock(productBuyid, requiredQuantity);
			repeatProcess();
			}
		else {
			System.out.println("Sorry we only have "+items.get(productBuyid-1).getQuantity()+"pieces Please Enter a Valid Quantity");
			gettingProductId();
		}
	}
	public void updateStock(int productId,int quantity) {
		items.get(productId-1).updateQuantity(quantity);
		addToBill(productId, quantity);
	}
	public void calculateTotalAmount(int productId,int quantity) {
		totalAmount=totalAmount+(quantity*items.get(productId-1).getPrice());
	}
	public void addToBill(int productId,int purchasedQuantity)	
	{
		ProductBill Billlist = new ProductBill(productId, items.get(productId-1).getProductName(),purchasedQuantity,items.get(productId-1).getPrice() ,purchasedQuantity*items.get(productId-1).getPrice());
		bill.add(Billlist);
	}
	public void repeatProcess() {
		char continueProcess;
		System.out.println("For to continue order press S or B for PayAmount & Bill or D to display the Menu");
		continueProcess=sc.next().charAt(0);
		if(continueProcess=='S'||continueProcess=='s') {
			gettingProductId();
		}else if(continueProcess=='d'||continueProcess=='D'){
			displayItemsAgain();
		}else {
			printBill();
		}
	}
	public void printBill(){
		 Iterator<ProductBill> iterate =bill.iterator();
		 LocalDateTime now = LocalDateTime.now();  
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	     String formatDateTime = now.format(format); 
	     System.out.println("\t\t******Stationary Store********");
	     System.out.println("Customer Name : "+customerName);
	     System.out.println("Date & Time:"+formatDateTime);
	     System.out.println("Productid\t"+"Productname"+"\tQuantity(Q)"+"\tPrice/(Q)"+"\tPrice");
		 while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}System.out.println("\tYour Total Payable Amount is Rupees : "+totalAmount);
		 System.out.println("\t****Thank You For Shopping Visit Again:-)*****");
	}
}