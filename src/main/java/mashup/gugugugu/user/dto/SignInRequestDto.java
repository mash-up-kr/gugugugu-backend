package mashup.gugugugu.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class SignInRequestDto {
    private String tokenId;
    private String email;
}
