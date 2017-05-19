package jayshawn.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jayshawn.spring.jdbc.beans.Account;

@Component
public class AccountDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Account findAccountByUserID(Integer id){
		String sql = "SELECT userID, userName, balance FROM account WHERE userID = ?";
		RowMapper rowMapper = new BeanPropertyRowMapper<>(Account.class);
		Account account = (Account) jdbcTemplate.queryForObject(sql, rowMapper, 1);
		return account;
	}
	
	public void updateBalance(Integer id, Integer price){
		int balance = findBalance(id);
		if(balance<price){
			throw new RuntimeException("Óà¶î²»×ã£¡");
		}
		String sql = "UPDATE account SET balance = ? WHERE userID = ?";
		jdbcTemplate.update(sql, balance-price, id);
	}
	
	public int findBalance(Integer id){
		String sql = "SELECT balance FROM account WHERE userID = ?";
		int balance = jdbcTemplate.queryForObject(sql, Integer.class, id);
		return balance;
	}
}
