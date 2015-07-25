package test.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by yamashiro-r on 15/07/25.
 */
@Configuration
@EnableAspectJAutoProxy
public class TestAspectConfig {

    private TestAopBean testAopBean = new TestAopBean("TestAspectConfig Bean!");
    private TestAspect testAspect = new TestAspect();

    @Bean
    TestAopBean testAopBean() {
        return testAopBean;
    }

    @Bean
    TestAspect testAspect() {
        return testAspect;
    }
}
