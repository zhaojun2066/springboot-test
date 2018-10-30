import com.jufeng.springboot.mvc.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/30
 * \* Time: 13:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= MockServletContext.class)//MockServletContext.class
@WebAppConfiguration
public class UserControllerTest extends MockMvcResultMatchers {
    //模拟mvc对象类.

    private MockMvc mvc;

    @Before
    public void setup(){
        /*
         * MockMvcBuilders使用构建MockMvc对象.
         */
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception{
        RequestBuilder request = null;
        //1. get 以下user列表，应该为空》
        //1、构建一个get请求.
        request = MockMvcRequestBuilders.get("/users/getUserList");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));

        System.out.println("UserControllerTest.testUserController().getUserList");

        request = MockMvcRequestBuilders.post("/users/addUser")
                .param("id","1")
                .param("name","林峰")
                .param("age","20");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("success"));
        request = MockMvcRequestBuilders.get("/users/getUserList");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("[{\"id\":1,\"name\":\"林峰\",\"age\":20}]"));



        request = MockMvcRequestBuilders.delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string("success"));
    }

}