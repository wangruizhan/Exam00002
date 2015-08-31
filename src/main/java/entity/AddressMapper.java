package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AddressMapper implements RowMapper<Address>{

	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address ad = new Address();
		ad.setAddress(rs.getString("address"));
		ad.setAddress_id(rs.getInt("address_id"));
		return ad;
	}
	

}
