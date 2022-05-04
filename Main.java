package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		customerName = sc.nextLine();
		System.out.println(":-)Thank You for Entering Your Valuable Name\nThe Available Items Are");
		initialDisplayItem();	
	}
	public void getProductId() {
		System.out.println("Choose the things whatever you Want by clicking on the id");		
		int productId=sc.nextInt();
		if(productId>=1 && productId<=5)
		{
			gettingRequiredQuantity(productId);
		}
		else
		{
			System.out.println("Enter the correct id matching to Your Item");
			getProductId();
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
			getProductId();  
		}else{
			System.out.println("Thank You for Visiting....");
		}		
	}
	public void displayItemsAgain() {
		displayInput();
		System.out.println("Currently Your Payable Amount is "+totalAmount);
		char choice2 = sc.next().charAt(0);
		if(choice2=='s'||choice2=='S') {
			getProductId();  
		}else{
			printBill();													//printing Bill and Current Amount
			System.out.println("Thank You for Visiting....");
		}		
	}
	public void gettingRequiredQuantity(int productBuyId) {
		System.out.println("Enter the number of "+items.get(productBuyId-1).getProductName() +" You Want");
		int getRequiredQuantity=sc.nextInt();
		validateQuantity(productBuyId,getRequiredQuantity);
	}
	public void validateQuantity(int productBuyid,int requiredQuantity) {
		if(requiredQuantity<=items.get(productBuyid-1).getupdatedQuantity()) {
			calculateTotalAmount(productBuyid, requiredQuantity);
			updateStock(productBuyid, requiredQuantity);
			repeatProcess();
			}
		else {
			System.out.println("Sorry we only have "+items.get(productBuyid-1).getQuantity()+"pieces Please Enter a Valid Quantity");
			getProductId();
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
			getProductId();
		}else if(continueProcess=='d'||continueProcess=='D'){
			displayItemsAgain();
		}else {
			printBill();;
		}     
	}
	public void printBill(){
		
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = now.format(format); 
		System.out.println("\t\t******Stationary Store********");
	    System.out.println("Customer Name : "+customerName);
	    System.out.println("Date & Time:"+formatDateTime);
	    System.out.println("\nProductid\t"+"Productname"+"\tQuantity(Q)"+"\tPrice/(Q)"+"\tPrice");
	    Iterator<ProductBill> iterate =bill.iterator();
	    while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
	    System.out.println("\tYour Total Payable Amount is Rupees : "+totalAmount);
		System.out.println("\t*****Thank You For Shopping Visit Again:-)*****");
		saveFile();
		System.out.println("To see Customer Details Press Y or Anyother to exit");
		char ch= sc.next().charAt(0);
		if(ch=='Y'||ch=='y') {
			showCustomerFileList();
		}else {
			return;
		}
	}
	public void saveFile()
	{
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = now.format(format); 
		File file = new File("C:\\Users\\Mohamed Jameel\\Desktop\\Store\\CustomerBill.txt");
		try {
			FileWriter wr = new FileWriter(file, true);
			file.createNewFile();
//			FileWriter wr = new FileWriter(file);
			wr.write("\n\t******Stationary Store********"+"\nCustomer Name : "+customerName
					+ "\nDate & Time : "+formatDateTime);
			wr.write("\nProductid\t"+"Productname"+"\tQuantity(Q)"+"\tPrice/(Q)"+"\tPrice");
			Iterator<ProductBill> iterate =bill.iterator();
			while(iterate.hasNext()) {	
				 ProductBill a= iterate.next();
					wr.write("\n\t"+a.getProductId()+"\t" +a.getProductName()+"\t"+a.getQuantity()+"\t\t"+a.getPiecePrice()+"\t\t"+a.getPrice());
			 }
			wr.write("\nYour Total Payable Amount is Rupees : "+totalAmount);
			wr.write("\n\t*****Thank You For Shopping Visit Again:-)*****");
			wr.flush();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void showCustomerFileList() {
		File file = new File("C:\\Users\\Mohamed Jameel\\Desktop\\Store\\CustomerBill.txt");
		FileReader rd;
		try {
			rd = new FileReader(file);
			int output = rd.read();
			while(output!=-1) {
				System.out.print((char)output);
				output=rd.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}