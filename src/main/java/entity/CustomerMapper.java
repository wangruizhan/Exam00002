package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer cs = new Customer();
		//cs.setStore_id(1);
		cs.setCustomer_id(rs.getInt("customer_id"));
		cs.setFirst_name(rs.getString("first_name"));
		cs.setLast_name(rs.getString("last_name"));
		cs.setEmail(rs.getString("email"));
		cs.setAddress_id(rs.getInt("address_id"));
		cs.setCreate_date(rs.getString("create_date"));
		return cs;
	}

}
