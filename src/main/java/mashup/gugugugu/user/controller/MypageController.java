package mashup.gugugugu.user.controller;

import mashup.gugugugu.user.dto.MypageRequestDto;
import mashup.gugugugu.user.dto.SubSettingRequestDto;
import mashup.gugugugu.user.dto.UpdateNicknameRequestDto;
import mashup.gugugugu.user.service.MypageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("mypage")
public class MypageController {
    private final MypageService mypageService;

    public MypageController(MypageService mypageService) {
        this.mypageService = mypageService;
    }

    @GetMapping
    public ResponseEntity getMypage(@RequestBody MypageRequestDto requestBody){
        return ResponseEntity.status(HttpStatus.OK).body(mypageService.get(requestBody));
    }

    @PostMapping
    public ResponseEntity setSubscribe(@RequestBody SubSettingRequestDto requestBody){
        return ResponseEntity.status(HttpStatus.OK).body(mypageService.setSubscribe(requestBody));
    }

    @PutMapping
    public ResponseEntity updateNickname(@RequestBody UpdateNicknameRequestDto requestBody){
        return ResponseEntity.status(HttpStatus.OK).body(mypageService.updateNickname(requestBody));
    }
}
