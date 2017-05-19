package jayshawn.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookShopDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void updateStock(String isbn){
		String sql = "SELECT count FROM bookstock WHERE isbn = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, 1);
		if(count==0){
			throw new RuntimeException("¿â´æ²»×ã");
		}
		
		String sql2 = "UPDATE bookstock SET count = ? WHERE isbn = ?";
		jdbcTemplate.update(sql2, count-1,isbn);
	}
	
	public int findPrice(String isbn){
		String sql = "SELECT price FROM book WHERE isbn = ?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}
}
