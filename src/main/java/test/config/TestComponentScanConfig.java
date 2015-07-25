package test.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import test.SampleTestBean;
import test.TestBean;

/**
 * Created by yamashiro-r on 15/07/25.
 */
@Configurable
@ComponentScan("test")
public class TestComponentScanConfig {

    @Bean
    public TestBean getTestBean() {
        return new SampleTestBean(TestComponentScanConfig.class.getSimpleName() + " Bean!");
    }

}
