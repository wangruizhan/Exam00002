package dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import entity.Address;
import entity.AddressMapper;
import entity.Customer;
import entity.CustomerMapper;

public class CustomerDaoImpl implements ICustomerDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	public void create(Integer store_id,String first_name,String last_name,String email,Integer address_id,Date create_date) {
		String SQL = "insert into Customer(store_id,first_name,last_name,email,address_id,create_date) values(?,?,?,?,?,?)";
		jdbcTemplateObject.update(SQL,store_id,first_name,last_name,email,address_id,create_date);
		//System.out.println("Created Record Name = "+name+"Age="+age);
		return;
		
	}

	public Customer getCustomer(Integer Customer_id) {
		String SQL = "select * from Customer where Customer_id = ?";
		Customer customer = null;
		try{
		customer = jdbcTemplateObject.queryForObject(SQL, new Object[]{Customer_id},new CustomerMapper());
		}catch(Exception e){
			e.getMessage();
		}
		
		return customer;
	}

	public List<Customer> listCustomers() {
		String SQL = "select * from Customer";
		List<Customer> Customers = jdbcTemplateObject.query(SQL, new CustomerMapper());
		return Customers;
	}

	public void delete(Integer id) {
		String SQL = "delete from Customer where customer_id= ?";
		try{
		jdbcTemplateObject.update(SQL, id);
		//System.out.println("Deleted Record with ID = " +id);
		}catch(Exception e){
			e.getMessage();
		}
		return;
		
	}

	public void update(Integer id, Integer age) {
		String SQL = "update Customer set age = ? where id=?";
		jdbcTemplateObject.update(SQL,age,id);
		System.out.println("Update Record with ID = " + id);
		return;
		
	}

	public Customer find(String first_name) {
		String SQL = "select * from Customer where first_name=?";
		Customer customer = null;
		try{
		 customer = jdbcTemplateObject.queryForObject(SQL, new Object[]{first_name},new CustomerMapper());
		}catch(Exception e){
			e.getMessage();
		}
		return customer;
	}

	public Address query(Integer address_id) {
		String SQL = "select * from Address where address_id = ?";
		Address address = null;
		try{
		 address = jdbcTemplateObject.queryForObject(SQL, new Object[]{address_id},new AddressMapper());
		
		}catch(Exception e){
			
			e.getMessage();
			//System.out.println();
		}
		return address;
		
	}
	
	

}
