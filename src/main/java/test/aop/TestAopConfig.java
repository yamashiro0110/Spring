package test.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AOPの設定クラス
 *
 * コンテキストからインスタンス取得の際の名前は、
 * メソッド名と一致する必要がある
 *
 * Created by yamashiro-r on 15/07/25.
 */
@Configuration
public class TestAopConfig {

    private TestAopBean testAopBean = new TestAopBean("this is TestAopConfig message bean.");
    private TestAopAdvice testAopAdvice = new TestAopAdvice();

    @Bean
    TestAopBean testAopBean() {
        return testAopBean;
    }

    @Bean
    TestAopAdvice testAopAdvice() {
        return testAopAdvice;
    }

    @Bean
    ProxyFactoryBean proxyFactoryBean() {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(testAopBean);
        proxyFactoryBean.setInterceptorNames("testAopAdvice");
        return proxyFactoryBean;
    }
}
