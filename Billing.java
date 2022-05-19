package project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Billing {
	Scanner input = new Scanner(System.in);
	List<ProductBill> bill = new ArrayList<>();
	String customerName;

	//Prints CustomerBill after Purchase
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
	    System.out.println("\tYour Total Payable Amount is Rupees : "+Main.totalAmount);
		System.out.println("\t*****Thank You For Shopping Visit Again:-)*****");
		saveBillToFile();
		System.out.println("To see Customer Details Press Y or Anyother to exit");
		char ch= input.next().charAt(0);
		if(ch=='Y'||ch=='y') {
			showCustomerBillFile(); 
		}else {
			return;
		}
	}

	//Saves the CustomerBill to File.
	public void saveBillToFile()
	{
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = now.format(format); 
		String filePath = "C:\\Users\\Mohamed Jameel\\Desktop\\Store\\"+customerName+".txt"; 
		
		File file = new File(filePath);
		try {
			FileWriter wr = new FileWriter(file, true);
			file.createNewFile();
			wr.write("\n\t******Stationary Store********"+"\nCustomer Name : "+customerName
					+ "\nDate & Time : "+formatDateTime);
			wr.write("\nProductid\t"+"Productname"+"\tQuantity(Q)"+"\tPrice/(Q)"+"\tPrice");
			Iterator<ProductBill> iterate =bill.iterator();
			while(iterate.hasNext()) {	
				 ProductBill a= iterate.next();
					wr.write("\n\t"+a.getProductId()+"\t" +a.getProductName()+"\t"+a.getQuantity()+"\t\t"+a.getPiecePrice()+"\t\t"+a.getPrice());
			 }
			wr.write("\nYour Total Payable Amount is Rupees : "+Main.totalAmount);
			wr.write("\n\t***********************************");
			wr.flush();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Prints the CustomersBill from File.
	public void showCustomerBillFile() {
		File file = new File("C:\\Users\\Mohamed Jameel\\Desktop\\Store\\"+customerName+".txt");
		FileReader rd;
		try {
			rd = new FileReader(file);
			int output = rd.read();
			while(output!=-1) {
				System.out.print((char)output);
				output=rd.read();
			}
		} catch (Exception e) {				
			System.out.println("File Not Found due to Some Error with System");
			e.printStackTrace();
			return;
		}
	}
}
