package jayshawn.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import jayshawn.spring.jdbc.beans.Employee;

@Component(value="employeeDao")
public class EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Employee get(Integer id){
		String sql = "SELECT id, last_name, email, dept_id FROM employees WHERE id = ?";
		RowMapper rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employees = (Employee) jdbcTemplate.queryForObject(sql, rowMapper,id);
		return employees;
	}


	

}
