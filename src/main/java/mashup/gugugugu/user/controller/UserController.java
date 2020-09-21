package mashup.gugugugu.user.controller;

import mashup.gugugugu.user.dto.SignInRequestDto;
import mashup.gugugugu.user.dto.SignUpRequestDto;
import mashup.gugugugu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpRequestDto requestBody){
        userService.signUp(requestBody);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity signIn(@RequestBody SignInRequestDto requestBody){
        if(userService.isExisted(requestBody.getTokenId(), requestBody.getEmail())){
            // TODO : jws 생성후 header에 넣어줘야 함
            HttpHeaders headers = new HttpHeaders();

            // TODO : 편지함으로 이동
            return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
