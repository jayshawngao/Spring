package jayshawn.spring.jdbc.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class Cashier {

	@Autowired
	private BookShopService bookShopService;
	
	@Transactional
	public void checkout(Integer id, List<String> isbns){
		for(String isbn:isbns){
			bookShopService.purchase(id, isbn);
		}
	}
	
}
