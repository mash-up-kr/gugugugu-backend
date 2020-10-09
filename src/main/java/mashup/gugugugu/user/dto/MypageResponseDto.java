package mashup.gugugugu.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MypageResponseDto {
    private Long userId;
    private String name;
    private String nickname;
    private String email;
    private Boolean subscribe;
}

