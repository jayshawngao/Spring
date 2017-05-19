package jayshawn.spring.jdbc.beans;

public class Employee {
	private Integer id;
	private String last_name;
	private String email;
	private Integer dept_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", last_name=" + last_name + ", email=" + email + ", dept_id=" + dept_id + "]";
	}
	
	
}
