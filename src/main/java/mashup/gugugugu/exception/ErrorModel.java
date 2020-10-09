package mashup.gugugugu.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorModel {

    private int code;
    private String msg;
    private LocalDateTime timestamp;

}