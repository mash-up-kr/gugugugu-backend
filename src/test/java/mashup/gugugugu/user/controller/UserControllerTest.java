package mashup.gugugugu.user.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mockMvc;

    @MockBean
    UserController userController;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
//
//    @Test
//    public void signUpTest() throws Exception{
//        given(this.userController.signUp(new SignUpRequestDto("abcde12345", "test", "xptmxm", "test@gmail.com", true))
//                .willReturn()
//        );
//
//
//        mockMvc.perform(post);
//
//    }
}
