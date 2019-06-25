package me.zy.spring.testcontext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestContextConfig.class})
@ActiveProfiles("dev")
public class TestContextMain {
    @Autowired
    private TestContextBean contextBean;

    @Test
    public void devBeanShouldInject(){
        String expected = "from development profile.";
        String actual = contextBean.getContent();
        Assert.assertEquals(expected,actual);
    }


}
