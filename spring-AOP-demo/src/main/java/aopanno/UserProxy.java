package aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class UserProxy {


    /*抽取相同的公共切入点*/
    @Pointcut("execution(* aopanno.User.add(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before() {
        System.out.println("前置通知...");
    }


    @Around("execution(* aopanno.User.add(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知前...");
        pjp.proceed();
        System.out.println("环绕通知前后...");
    }

    @AfterThrowing("execution(* aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("异常通知...");
    }

    @AfterReturning("execution(* aopanno.User.add(..))")
    public void afterReturning() {//若被增强方法抛出异常，则此方法不执行
        System.out.println("后置通知（返回通知）...");
    }

    @After("execution(* aopanno.User.add(..))")
    public void after() {//无论是否抛出异常都会执行
        System.out.println("最终通知...");
    }
}
