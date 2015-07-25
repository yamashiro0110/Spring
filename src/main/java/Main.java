import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.SampleTestBean;
import test.TestBean;
import test.component.TestComponent;
import test.config.TestBeanConfig;
import test.config.TestComponentScanConfig;

/**
 * Created by yamashiro-r on 15/07/25.
 */
public class Main {
    public static void main(String[] args) {
        testXmlBean();
        testConfigBean();
        testComponent();
    }

    private static void testXmlBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        SampleTestBean bean1 = (SampleTestBean) context.getBean("bean1");
        System.out.println("bean1:" + bean1.getMessage());

        SampleTestBean bean2 = (SampleTestBean) context.getBean("bean2");
        System.out.println("bean2:" + bean2.getMessage());
    }

    private static void testConfigBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestBeanConfig.class);
        TestBean bean = context.getBean(TestBean.class);
        System.out.println("bean:" + bean.getMessage());
    }

    private  static void testComponent() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestComponentScanConfig.class);
        TestComponent component = context.getBean(TestComponent.class);
        System.out.println("component:" + component.message());
    }

}
