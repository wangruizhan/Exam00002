package dao;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Address;
import entity.Customer;



public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerDaoImpl customerDaoImpl = 
			(CustomerDaoImpl)context.getBean("customerDaoImpl");
		Scanner sn = new Scanner(System.in);
		System.out.println("请输入first_name：");
		String first_name = sn.next();
		System.out.println("请输入last_name：");
		String last_name = sn.next();
		System.out.println("请输入email:");
		String email = sn.next();
		System.out.println("请输入address_id:");
		Integer address_id = sn.nextInt();
		Address ad = customerDaoImpl.query(address_id);
		int id;
		if(ad!= null){

		customerDaoImpl.create(1, first_name, last_name, email, address_id, new Date());
		id = address_id;
			
		}else{
			System.out.println("你输入的Address ID不存在，请重新输入:");
			Integer address_id1 = sn.nextInt();
			customerDaoImpl.create(1, first_name, last_name, email, address_id1, new Date());
			id=address_id1;
			
		}
		
		//customerDaoImpl.create(1, first_name, last_name, email, address_id, new Date());
//		System.out.println("Before Save");
	    System.out.println("已经保存的数据如下:");
		
		
		Customer customer = customerDaoImpl.find(first_name);
		Address address = customerDaoImpl.query(id);
		
		//System.out.println(customer);
		//System.out.println("ID:"+customer.getCustomer_id());
		System.out.println("first_name:"+customer.getFirst_name());
		System.out.println("last_name:"+customer.getLast_name());
		System.out.println("email:"+customer.getEmail());
		
		System.out.println("address:"+address.getAddress());
		
		System.out.println("create_date:"+customer.getCreate_date());
		
		
		System.out.println("请输入要删除的customer的ID:");
		Integer customer_id = sn.nextInt();
		Customer customer1 = customerDaoImpl.getCustomer(customer_id);
		int b=0;
		if(customer1!=null){
		
		System.out.println("你输入的ID为"+customer_id+"的customer已经删除");
		b = customer_id;
		}else{
			System.out.println("你输入的customerID不存在，请重新输入:");
		Integer customer_id1=sn.nextInt();
		b=customer_id1;
			
		}
		customerDaoImpl.delete(b);
		System.out.println("你输入的ID为"+b+"的Customer已经删除");
	}

}
