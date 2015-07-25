package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.SampleTestBean;
import test.TestBean;

/**
 * Created by yamashiro-r on 15/07/25.
 */
@Configuration
public class TestBeanConfig {

    @Bean
    public TestBean getTestBean() {
        return new SampleTestBean("config testBean!!");
    }
}
