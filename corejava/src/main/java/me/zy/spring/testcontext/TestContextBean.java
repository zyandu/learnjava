package me.zy.spring.testcontext;

public class TestContextBean {
    private String content;

    public TestContextBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
