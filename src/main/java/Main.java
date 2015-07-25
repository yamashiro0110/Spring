import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.SampleTestBean;
import test.TestBean;
import test.aop.TestAopBean;
import test.aop.TestAopConfig;
import test.aop.TestAspectConfig;
import test.component.TestComponent;
import test.config.TestBeanConfig;
import test.config.TestComponentScanConfig;

/**
 * Created by yamashiro-r on 15/07/25.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("***** testXmlBean *****");
        testXmlBean();

        System.out.println("***** testConfigBean *****");
        testConfigBean();

        System.out.println("***** testComponent *****");
        testComponent();

        System.out.println("***** testAop *****");
        testAop();

        System.out.println("***** testAop *****");
        testAopConfig();

        System.out.println("***** testAspectJ+XML *****");
        testAspectJXml();

        System.out.println("***** testAspectJ+Config *****");
        testAspextJConfig();
    }

    /**
     * XMLファイルからDIしたインスタンスを出力する
     */
    private static void testXmlBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        SampleTestBean bean1 = (SampleTestBean) context.getBean("bean1");
        System.out.println("bean1:" + bean1.getMessage());

        SampleTestBean bean2 = (SampleTestBean) context.getBean("bean2");
        System.out.println("bean2:" + bean2.getMessage());
    }

    /**
     * アノテーションによってDIしたインスタンスを出力する
     */
    private static void testConfigBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestBeanConfig.class);
        TestBean bean = context.getBean(TestBean.class);
        System.out.println("bean:" + bean.getMessage());
    }

    /**
     * フィールドをアノテーションによってDIしたcomponentのメソッドを実行する
     */
    private static void testComponent() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestComponentScanConfig.class);
        TestComponent component = context.getBean(TestComponent.class);
        System.out.println("component:" + component.message());
    }

    /**
     * XMLによるAOPのテスト
     */
    private static void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        TestAopBean bean1 = (TestAopBean) context.getBean("testAopBean");
        bean1.printMessage1();
        System.out.println();

        TestAopBean bean2 = (TestAopBean) context.getBean("proxyFactoryBean");
        bean2.printMessage1();
        System.out.println();

        bean2.printMessage2();
        System.out.println();
    }

    /**
     * 設定クラスによるAOPのテスト
     */
    private static void testAopConfig() {
        ApplicationContext aopContext = new AnnotationConfigApplicationContext(TestAopConfig.class);
        TestAopBean bean3 = (TestAopBean) aopContext.getBean("proxyFactoryBean");
        bean3.printMessage1();
        System.out.println();
    }

    /**
     * AspectJ+XMLによるAOPのテスト
     */
    private static void testAspectJXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop-bean.xml");
        TestAopBean bean = (TestAopBean) context.getBean("TestAopBean");
        bean.printMessage1();

        String msg = "<<" + bean.getMessage() + ">>";
        bean.setMessage(msg);
        bean.printMessage1();
    }

    /**
     * AspectJ+設定クラスによるAOPのテスト
     */
    private static void testAspextJConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestAspectConfig.class);
        TestAopBean bean = (TestAopBean) context.getBean("testAopBean");
        bean.printMessage1();
    }

}
