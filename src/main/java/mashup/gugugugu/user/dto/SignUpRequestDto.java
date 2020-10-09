package mashup.gugugugu.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {
    private String tokenId;
    private String name;
    private String nickname;
    private String email;
    private Boolean subscribe;
}
