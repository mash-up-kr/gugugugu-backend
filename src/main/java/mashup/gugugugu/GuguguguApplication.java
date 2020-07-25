package mashup.gugugugu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GuguguguApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuguguguApplication.class, args);
    }

}
