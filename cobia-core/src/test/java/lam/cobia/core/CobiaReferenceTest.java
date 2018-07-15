package lam.cobia.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import lam.cobia.config.spring.CobiaReference;
import lam.cobia.core.constant.Constant;
import lam.cobia.core.exception.CobiaException;
import lam.cobia.core.service.IMyService;
import lam.cobia.core.service.IYourService;
import lam.cobia.log.Console;

/**
* <p>
* TODO
* </p>
* @author linanmiao
* @date 2017年12月19日
* @version 1.0
*/
public class CobiaReferenceTest {

	public static void main(String[] args) {
		System.setProperty(Constant.KEY_SERVER_HOST, "127.0.0.1");
		System.setProperty(Constant.KEY_PORT, "4325");
		System.setProperty(Constant.KEY_CLIENT_IS_SHARE, Boolean.TRUE.toString());
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-customer.xml"});
		context.start();
		
		IMyService myService = context.getBean("myService", IMyService.class);
		System.out.println(System.identityHashCode(myService));
		
		String result = myService.doIt("lam");
		System.out.println(result);
		
		IYourService yourService = context.getBean("yourService", IYourService.class);
		/*int r = yourService.doYourself(2);
		System.out.println(r);*/
		/*result = yourService.gogo((byte)1);
		System.out.println(result);*/
		
		result = yourService.doString("aa");
		System.out.println(result);
		
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		context.close();
		System.exit(0);
	}
	
	public interface Test{
		public String doIt(String[] ss);
	}

}
