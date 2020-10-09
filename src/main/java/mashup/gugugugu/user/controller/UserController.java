package mashup.gugugugu.user.controller;

import mashup.gugugugu.user.dto.SignInRequestDto;
import mashup.gugugugu.user.dto.SignUpRequestDto;
import mashup.gugugugu.user.service.JwtService;
import mashup.gugugugu.user.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpRequestDto requestBody){
        userService.signUp(requestBody);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity signIn(@RequestBody SignInRequestDto requestBody){
        if(userService.isExisted(requestBody.getTokenId(), requestBody.getEmail())){
            String jws = jwtService.create(requestBody);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", jws);

            // TODO : 편지함으로 이동
            return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
