package aprication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);	
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name=sc.nextLine();
		System.out.print("Email: ");
		String email=sc.nextLine();
		System.out.println("Birth Date (dd/MM/yyyy): ");
		String birthDate=sc.nextLine();
		
		Date date=sdf.parse(birthDate);
		
		Cliente cliente=new Cliente(name,email,date);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status=OrderStatus.valueOf(sc.nextLine());
		
		Order order=new Order(new Date(),status,cliente);
		
		System.out.print("How many items to this order? ");
		int n=sc.nextInt();
		
		
			for(int i=1;i<=n;i++) {
				sc.nextLine();
				System.out.println("Enter #"+i+" item data:");
				System.out.print("Product name: ");
				String productName=sc.nextLine();
				System.out.print("Product price: ");
				Double productPrice=sc.nextDouble();
				
				Product product=new Product(productName,productPrice);
				
				System.out.print("Quantity: ");
				int quantity=sc.nextInt();
			
				
				OrderItem orderItem=new OrderItem(quantity,product.getPrice(),product);
				
				order.addItem(orderItem);			
			}
			System.out.println("\n");
		
		System.out.println("Order Summary:");
		
		
		System.out.println(order);

		sc.close();
	}

}
