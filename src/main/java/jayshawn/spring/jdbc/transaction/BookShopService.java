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
	 ������Ϊ	           ����
PROPAGATION_REQUIRED ��ʾ��ǰ����������һ����������������������У����пͻ����������ڽ��У���ô�����ö˽��ڸ����������У�����Ļ����¿���һ�����񡣣���������ö˷����쳣����ô���ö˺ͱ����ö����񶼽��ع���
PROPAGATION_SUPPORTS ��ʾ��ǰ����������Ҫ����һ�����������ģ����������һ������Ļ�����Ҳ�������������������
PROPAGATION_MANDATORY ��ʾ��ǰ����������һ�����������У����û�����񣬽��׳��쳣
PROPAGATION_NESTED ��ʾ�����ǰ��������һ�������������У���÷���Ӧ��������һ��Ƕ�������У���Ƕ�׵�������Զ����ڱ���װ�������н����ύ���߻ع��������װ������ڣ�������������׳��쳣�ع�����ô�ڲ��������ع�����֮���ڲ����񲢲�Ӱ��������������װ���񲻴��ڣ���ͬPROPAGATION_REQUIRED��һ��
PROPAGATION_NEVER ��ʾ��������Ӧ����һ�����������У��������һ���������׳��쳣
PROPAGATION_REQUIRES_NEW ��ʾ��ǰ�����������������Լ��������С�һ���µ��������������������һ�����е����������еĻ���������������������ڱ�����ֱ���µ������ύ���߻ع��Żָ�ִ�С�
PROPAGATION_NOT_SUPPORTED ��ʾ�÷�����Ӧ����һ�����������С������һ�������������У������������ڱ�����ֱ����������ύ���߻ع��Żָ�ִ��
 */

@Component
public class BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	@Autowired
	private AccountDao accountDao;
	
	//����Ĵ�����Ϊʹ��propagation�趨:����ǰ�����񷽷�������һ�����񷽷�����ʱ���ʹ������Ĭ��ȡֵREQUIRED����ʹ������һ������������,ע�⵽������������һ�����У����������á�
	//ʹ��REQUIRES_NEW��������˺ܶ౾�飬Ǯֻ����һ������ô��һ���Ṻ��ɹ�
	//ʹ��EQUIRED��������˺ܶ౾�飬Ǯֻ����һ������ôһ��Ҳ������
	//isolation=Isolation.READ_COMMITTED ���ڹ涨����ĸ��뼶�� READ_COMMITTED�����ύ�� 
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public void purchase(Integer id, String isbn){
		int price = bookShopDao.findPrice(isbn);
		bookShopDao.updateStock(isbn);
		accountDao.updateBalance(id, price);
	}
	
	
}
