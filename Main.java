package project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int totalAmount=0;
	static Scanner sc = new Scanner(System.in);
	static List<Product> items =  new ArrayList<>();
	static List<ProductBill> bill = new ArrayList<>();
	static String customerName;
	
	Billing Billing = new Billing();
	
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
		main.getCustomerName();
	}
//	public void getCustomerName() {
//		System.out.print("Enter Your Name : ");
//		customerName = sc.nextLine();
//		System.out.println(":-)Thanks for Entering Your Valuable Name\nThe Available Items Are");
//		displayProducts();	
//	}
	public void getCustomerName() {
		System.out.print("Enter Your Name : ");
		customerName=sc.nextLine();
		File file = new File("C:\\Users\\Mohamed Jameel\\Desktop\\Store\\"+customerName+".txt");
		if(file.exists()) {
			System.out.println("Hey Do you want to see Your Previous Bills Press S or N for Shopping");
			char choice = sc.next().charAt(0);
			if (choice =='S' || choice=='s') {
				Billing.showCustomerFileList();
			}else {
				displayProducts();
			}
		}else {
			System.out.println(":-)Thanks for Entering Your Valuable Name\nThe Available Items Are");
			displayProducts();
		}
	}
//	public static boolean isValidUserName(String customerName) {
//		String namePattern="^[A-Za-z]\\w{5,29}$";
//		Pattern p = Pattern.compile(namePattern);
//		if(customerName == null) {
//			return false;
//		}
//		Matcher m = p.matcher(customerName);
//		return m.matches();
//	}
	
	public void displayProducts() {
		System.out.println("Productid"+"\tProductname"+"\tPrice"+"\tQuantity");
		for(Product printStationaryThings:items) {
			System.out.println(printStationaryThings);
		}
		System.out.println("To Buy things press S or press Anyother to Exit:-)");
		
		if(totalAmount==0) {
			char choice = sc.next().charAt(0);
			if(choice=='s'||choice=='S') {
				getProductId();  
			}else{
				System.out.println("Thank You for Visiting....");
			}		
		}else {
			System.out.println("Currently Your Payable Amount is "+totalAmount);
			char choice2 = sc.next().charAt(0);
			if(choice2=='s'||choice2=='S') {
				getProductId();  
			}else{
				Billing.printBill();													//printing Bill and Current Amount
				System.out.println("Thank You for Visiting....");
			}
		}
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
		if(totalAmount==0) {
			System.out.println("For Shopping press S ");
			displayProducts();
		}else {
			System.out.println("\nTo continue order press S or B for PayAmount & Bill or D to display the Menu");
			continueProcess=sc.next().charAt(0);
			if(continueProcess=='S'||continueProcess=='s') {
				getProductId();
			}else if(continueProcess=='d'||continueProcess=='D'){
				displayProducts();
			}else if(totalAmount>0) {
				Billing.printBill();
			} else {    
				System.out.println("You havent purchased Anything for Billing");
			}
		}
	}
}