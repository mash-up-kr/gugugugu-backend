package mashup.gugugugu.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mashup.gugugugu.user.dto.SignUpRequestDto;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String tokenId;
    private String name;
    private String nickname;
    private String email;
    private Boolean subscribe;

    private User(SignUpRequestDto requestBody) {
        this.tokenId = requestBody.getTokenId();
        this.name = requestBody.getName();
        this.nickname = requestBody.getNickname();
        this.email = requestBody.getEmail();
        this.subscribe = requestBody.getSubscribe();
    }

    public static User from(SignUpRequestDto requestBody){
        return new User(requestBody);
    }

    public void setSubscribe(Boolean subscribe){
        this.subscribe = subscribe;
    }

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }
}