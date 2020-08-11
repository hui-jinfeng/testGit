package aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class UserProxy2 {
    @Before("execution(* aopanno.User.add(..))")
    public void befor(){
        System.out.println("UserProxy2前置通知(多个增强类增强同一个方法，以@Order注解区分执行先后顺序，值越小越先执行)");
    }
}
