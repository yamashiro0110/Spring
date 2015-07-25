package test.aop;

/**
 * Created by yamashiro-r on 15/07/25.
 */
public class TestAopBean {
    private String message;

    public TestAopBean() {
    }

    public TestAopBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage1() {
        System.out.println("message1:" + message);
    }

    public void printMessage2() {
        System.out.println("message2:" + message);
    }

    @Override
    public String toString() {
        return "message is " + message;
    }
}
