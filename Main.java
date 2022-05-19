package project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int totalAmount=0;
	static List<Product> items =  new ArrayList<>();
	Billing billing;
	Scanner sc = new Scanner(System.in);
	int productId;
	
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
	//Getting Customer Name As input
	public void getCustomerName() {
		System.out.print("Enter Your Name : ");
		billing= new Billing();
		billing.customerName=sc.nextLine();    												
		String  name=billing.customerName;

		if(checkCustomerBillFileAvailable(name)) { 																				//showcustomerBillifAvailable
			System.out.println("Hey Do you want to see Your Previous Bills Press S or N for Shopping");
			char choice = sc.next().charAt(0);
			if (choice =='S' || choice=='s') {
				billing.showCustomerBillFile();
				repeatProcess();
			}else {
				displayProducts();
			}
		}else {
			System.out.println(":-)Thanks for Entering Your Valuable Name\nThe Available Items Are");
			displayProducts();
		}
	}
	 
	//Checks the customerName with File 
	public boolean checkCustomerBillFileAvailable(String name){							
		File file = new File("C:\\Users\\Mohamed Jameel\\Desktop\\Store\\"+name+".txt"); 
		if(file.exists()) {
			return true;
		}
		return false;
	}
	
	//Displaying the Available Products in Store
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
				gettingRequiredQuantity();
			}else{
				System.out.println("Thank You for Visiting....");
			}		
		}else {
			System.out.println("Currently Your Payable Amount is "+totalAmount);
			char choice2 = sc.next().charAt(0);
			if(choice2=='s'||choice2=='S') {
				getProductId(); 
				gettingRequiredQuantity();
				
			}else{
				billing.printBill();													//printing Bill and Current Amount
				System.out.println("Thank You for Visiting....");
			}
		}
	}
	
	//Getting ProductId as a Input from Customer
	public void getProductId() {
		System.out.println("Choose the things whatever you Want by clicking on the id");		
		productId=sc.nextInt();
		if(productId>=1 && productId<=5)
		{
			return;
		}
		else
		{
			System.out.println("Enter the correct id matching to Your Item");
			getProductId();
		}
	}
		
	//Getting the Required Quantity as an Input.
	public void gettingRequiredQuantity() {
		System.out.println("Enter the number of "+items.get(productId-1).getProductName() +" You Want");
		int getRequiredQuantity=sc.nextInt();
		validateQuantity(getRequiredQuantity);
	}
	
	//Validating the RequiredQuantity with Available Stock
	public void validateQuantity(int requiredQuantity) {
		if(requiredQuantity<=items.get(productId-1).getupdatedQuantity()) {
			calculateTotalAmount(requiredQuantity);
			updateStock(requiredQuantity);
			repeatProcess();
			}
		else {
			System.out.println("Sorry we only have "+items.get(productId-1).getQuantity()+"pieces Please Enter a Valid Quantity");
			getProductId();
		}
	}
	//Updating the Quantity of the Stock.
	public void updateStock(int quantity) {
		items.get(productId-1).updateQuantity(quantity);
		addToBill(productId, quantity);
	}
	//Calculating the Total Amount for Bill
	public void calculateTotalAmount(int quantity) {
		totalAmount=totalAmount+(quantity*items.get(productId-1).getPrice());
	}
	//Adding the Customer bought Products to Bill
	public void addToBill(int productId,int purchasedQuantity)	
	{
		ProductBill billList = new ProductBill(productId, items.get(productId-1).getProductName(),purchasedQuantity,items.get(productId-1).getPrice() ,purchasedQuantity*items.get(productId-1).getPrice());
		billing.bill.add(billList);
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
				gettingRequiredQuantity();
			}else if(continueProcess=='d'||continueProcess=='D'){
				displayProducts();
			}else if(totalAmount>0) {
				billing.printBill();
			} else {    
				System.out.println("You havent purchased Anything for Billing");
			}
		}
	}
}