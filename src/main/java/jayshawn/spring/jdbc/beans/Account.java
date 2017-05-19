package jayshawn.spring.jdbc.beans;

public class Account {
	private Integer userID;
	private String userName;
	private Integer balance;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [userID=" + userID + ", userName=" + userName + ", balance=" + balance + "]";
	}
	
	
}
