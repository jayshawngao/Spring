package jayshawn.spring.jdbc.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jayshawn.spring.jdbc.dao.AccountDao;
import jayshawn.spring.jdbc.dao.BookShopDao;
/**
	 传播行为	           含义
PROPAGATION_REQUIRED 表示当前方法必须在一个具有事务的上下文中运行，如有客户端有事务在进行，那么被调用端将在该事务中运行，否则的话重新开启一个事务。（如果被调用端发生异常，那么调用端和被调用端事务都将回滚）
PROPAGATION_SUPPORTS 表示当前方法不必需要具有一个事务上下文，但是如果有一个事务的话，它也可以在这个事务中运行
PROPAGATION_MANDATORY 表示当前方法必须在一个事务中运行，如果没有事务，将抛出异常
PROPAGATION_NESTED 表示如果当前方法正有一个事务在运行中，则该方法应该运行在一个嵌套事务中，被嵌套的事务可以独立于被封装的事务中进行提交或者回滚。如果封装事务存在，并且外层事务抛出异常回滚，那么内层事务必须回滚，反之，内层事务并不影响外层事务。如果封装事务不存在，则同PROPAGATION_REQUIRED的一样
PROPAGATION_NEVER 表示当方法务不应该在一个事务中运行，如果存在一个事务，则抛出异常
PROPAGATION_REQUIRES_NEW 表示当前方法必须运行在它自己的事务中。一个新的事务将启动，而且如果有一个现有的事务在运行的话，则这个方法将在运行期被挂起，直到新的事务提交或者回滚才恢复执行。
PROPAGATION_NOT_SUPPORTED 表示该方法不应该在一个事务中运行。如果有一个事务正在运行，他将在运行期被挂起，直到这个事务提交或者回滚才恢复执行
 */

@Component
public class BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	@Autowired
	private AccountDao accountDao;
	
	//事务的传播行为使用propagation设定:即当前的事务方法被另外一个事务方法调用时如何使用事务，默认取值REQUIRED，即使用另外一个方法的事务,注意到两个事务不能在一个类中，否则不起作用。
	//使用REQUIRES_NEW，如果买了很多本书，钱只够买一本，那么第一本会购买成功
	//使用EQUIRED，如果买了很多本书，钱只够买一本，那么一本也不会买
	//isolation=Isolation.READ_COMMITTED 用于规定事务的隔离级别 READ_COMMITTED读已提交吧 
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public void purchase(Integer id, String isbn){
		int price = bookShopDao.findPrice(isbn);
		bookShopDao.updateStock(isbn);
		accountDao.updateBalance(id, price);
	}
	
	
}
