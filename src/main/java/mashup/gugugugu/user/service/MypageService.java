package mashup.gugugugu.user.service;

import mashup.gugugugu.exception.BaseException;
import mashup.gugugugu.exception.ErrorModel;
import mashup.gugugugu.user.dto.*;
import mashup.gugugugu.user.entity.User;
import mashup.gugugugu.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class MypageService {
    private final UserRepository userRepository;

    public MypageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MypageResponseDto get(MypageRequestDto requestBody){
        User user = userRepository.findByUserId(requestBody.getUserId()).orElseThrow(() -> new BaseException(ErrorModel.builder().build()));

        return MypageResponseDto
                .builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .subscribe(user.getSubscribe())
                .build();
    }

    public SubSettingResponseDto setSubscribe(SubSettingRequestDto requestBody) {
        User user = userRepository.findByUserId(requestBody.getUserId()).orElseThrow(() -> new BaseException(ErrorModel.builder().build()));
        user.setSubscribe(requestBody.getSubscribe());
        user = userRepository.save(user);

        return new SubSettingResponseDto(user.getSubscribe());
    }

    public UpdateNicknameResponseDto updateNickname(UpdateNicknameRequestDto requestBody){
        User user = userRepository.findByUserId(requestBody.getUserId()).orElseThrow(() -> new BaseException(ErrorModel.builder().build()));
        user.updateNickname(requestBody.getNickname());
        user = userRepository.save(user);

        return new UpdateNicknameResponseDto(user.getNickname());
    }
}
