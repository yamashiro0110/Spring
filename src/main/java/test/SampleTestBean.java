package test;

/**
 * Created by yamashiro-r on 15/07/25.
 */
public class SampleTestBean implements TestBean {
    private String message;

    public SampleTestBean() {}

    public SampleTestBean(String message) {
        this.message = message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
