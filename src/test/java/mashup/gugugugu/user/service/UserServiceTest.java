package mashup.gugugugu.user.service;

import mashup.gugugugu.user.dto.SignUpRequestDto;
import mashup.gugugugu.user.entity.User;
import mashup.gugugugu.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserServiceTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void SignUp(){
        SignUpRequestDto requestBody = new SignUpRequestDto("abcde12345", "test", "xptmxm", "test@gmail.com", true);
        System.out.println(requestBody.getEmail());

        User user = new User();
        user = user.from(requestBody);

        userRepository.save(user);

        List<User> getUsers = userRepository.findAll();

        for(User user1 : getUsers){
            assertThat(user1.getEmail(), is(equalTo("test@gmail.com")));
        }

    }
}
