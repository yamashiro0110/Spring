package test.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.TestBean;

/**
 * Created by yamashiro-r on 15/07/25.
 */
@Component
public class TestComponent {

    @Autowired
    private TestBean bean;

    public String message() {
        return bean.getMessage();
    }
}
