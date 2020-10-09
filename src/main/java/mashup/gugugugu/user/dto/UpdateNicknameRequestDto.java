package mashup.gugugugu.user.dto;

import lombok.Getter;

@Getter
public class UpdateNicknameRequestDto {
    private Long userId;
    private String nickname;
}
