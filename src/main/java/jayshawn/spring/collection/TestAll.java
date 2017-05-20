package jayshawn.spring.collection;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jayshawn.spring.jdbc.beans.Account;
import jayshawn.spring.jdbc.beans.Employee;
import jayshawn.spring.jdbc.config.Config;
import jayshawn.spring.jdbc.dao.AccountDao;
import jayshawn.spring.jdbc.dao.BookShopDao;
import jayshawn.spring.jdbc.dao.EmployeeDao;
import jayshawn.spring.jdbc.transaction.BookShopService;
import jayshawn.spring.jdbc.transaction.Cashier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-collection.xml"})
public class TestAll {
	@Autowired
	private Department department;
	
	@Test
	public void test(){
		System.out.println(department);
	}
}
