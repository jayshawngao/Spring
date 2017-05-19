package jayshawn.spring.jdbc;

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
//@ContextConfiguration(locations={"classpath:applicationContext-jdbc.xml"})
@ContextConfiguration(classes={Config.class})
public class JdbcTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	@Qualifier("employeeDao")
	private EmployeeDao employeeDao;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private BookShopDao bookShopDao;
	@Autowired
	private BookShopService bookShopService;
	@Autowired
	private Cashier cashier;

	
	@Test
	public void test() throws Exception {
		System.out.println(dataSource.getConnection());
	}
	
	//ִ��insert update delete
	@Test
	public void testUpdate(){
		String sql = "INSERT INTO employees (LAST_NAME, EMAIL, DEPT_ID) VALUES(?,?,?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{"AA","aa@163.com",1});
		list.add(new Object[]{"BB","bb@163.com",1});
		jdbcTemplate.batchUpdate(sql, list);
	}
	
	//�����ݿ��ȡһ����¼
	//JdbcTemplateֻ��һ��С���ߣ���֧�ּ���ӳ�䣬������Ҫʹ��hibernate��ʲô�Ǽ���ӳ�䣬����˵�����½�һ����Department����employee���е�DEPT_ID����Department.id�ٽ��в�ѯ���ǲ��ܽ����Զ�ӳ��ġ�
	@Test
	public void testQueryForObject(){
		String sql="SELECT id, last_name, email, dept_id FROM employees WHERE id = ?";
		RowMapper rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = (Employee) jdbcTemplate.queryForObject(sql, rowMapper,2);
		System.out.println(employee);
	}
	
	@Test
	public void testemployeeDao(){
		System.out.println(employeeDao.get(2));
	}
	
	//NamedParameterJdbcTempalte ���Դ���һ������Ȼ��ֱ�ӱ��浽���ݿ⡣
	@Test
	public void testNamedParameterJdbcTemplate(){
		String sql = "INSERT INTO employees (LAST_NAME, EMAIL, DEPT_ID) VALUES(:last_name, :email, :dept_id)";
		Employee object = new Employee();
		object.setLast_name("CC");
		object.setEmail("cc@163.com");
		object.setDept_id(1);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(object);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	//ע�⵽SqlParameterSource���÷�������ȡ�ú�������һ��Beanʵ����ΪSql���Ĳ�����
	@Test
	public void testNamedParameterJdbcTemplate2(){
		String sql="SELECT id, last_name, email, dept_id FROM employees WHERE id = :id";
		Employee object = new Employee();
		object.setId(2);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(object);
		RowMapper rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		object = (Employee) namedParameterJdbcTemplate.queryForObject(sql, parameterSource, rowMapper);
		System.out.println(object);
	}
	
	@Test
	public void testAccountDao(){
//		System.out.println(accountDao.findAccountByUserID(1));
		accountDao.updateBalance(1, 80);
	}
	
	@Test
	public void testBookShopDao(){
		bookShopDao.updateStock("1");
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase(1, "1");
	}
	
	@Test
	public void testCashier(){
		List<String> list = new ArrayList<>(Arrays.asList("1","1"));
		cashier.checkout(1, list);
	}


}
