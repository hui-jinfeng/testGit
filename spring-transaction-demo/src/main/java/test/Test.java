package test;

import config.TXConfig;
import entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;

public class Test {
    @org.junit.Test
    public void testGetAccount() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
        AccountService accountService = (AccountService) context.getBean("accountServiceImpl");
        Account account = accountService.getAccount("1");
        System.out.println(account);
    }

    @org.junit.Test
    public void testTransfer() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
        AccountService accountService = (AccountService) context.getBean("accountServiceImpl");
        accountService.transfer("1","2",100);
    }

    @org.junit.Test
    public void testAnno(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(TXConfig.class);
        AccountService service = (AccountService) context.getBean("accountServiceImpl");
        Account account = service.getAccount("1");
        System.out.println(account);
    }
}
