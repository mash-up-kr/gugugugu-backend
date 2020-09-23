package mashup.gugugugu.user.service;

import mashup.gugugugu.exception.BaseException;
import mashup.gugugugu.exception.ErrorModel;
import mashup.gugugugu.user.dto.SignUpRequestDto;
import mashup.gugugugu.user.entity.User;
import mashup.gugugugu.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isExisted(String tokenId, String email){
        return userRepository.findByTokenId(tokenId).filter(user -> user.getEmail().equals(email)).isPresent();
    }

    @Transactional
    public void signUp(SignUpRequestDto requestBody){
        if (isExisted(requestBody.getTokenId(), requestBody.getEmail())){
            throw new BaseException(ErrorModel.builder().build());
        }

        User user = User.from(requestBody);

        userRepository.save(user);
    }

}
