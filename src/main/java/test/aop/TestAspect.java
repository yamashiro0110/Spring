package test.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by yamashiro-r on 15/07/25.
 */
@Aspect
public class TestAspect {

    @Before("execution(* test.aop.TestAopBean.*(..))")
    public void before() {
        System.out.println("before ***************");
    }

    @After("execution(* test.aop.TestAopBean.*(..))")
    public void after() {
        System.out.println("after ***************");
    }

}
