package test.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

import static java.lang.String.format;
import static java.lang.System.out;

/**
 * メソッドの実行前、実行後に実行する処理を定義
 */
public class TestAopAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        out.println(format("after method:%s, target:%s", method.getName(), target));
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        out.println(format("before method:%s, target:%s", method.getName(), target));
    }
}
