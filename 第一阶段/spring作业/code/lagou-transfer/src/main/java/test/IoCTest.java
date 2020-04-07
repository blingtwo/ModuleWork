package test;
import com.lagou.edu.dao.AccountDao;
import com.lagou.edu.factory.BeanFactory;
import com.lagou.edu.factory.BeanFactoryAnnotation;
import com.lagou.edu.factory.ProxyFactory;
import com.lagou.edu.service.TransferService;
import org.junit.Test;

public class IoCTest {
    @Test
    public void testIoC() throws Exception {
        //ProxyFactory proxyFactory = (ProxyFactory) BeanFactory.getBean("proxyFactory");
        //TransferService transferService = (TransferService) proxyFactory.getJdkProxy(BeanFactory.getBean("transferService")) ;
        TransferService transferService = (TransferService) BeanFactoryAnnotation.getBean("transferService");
        transferService.transfer("6029621011000","6029621011001",100);
    }
}
