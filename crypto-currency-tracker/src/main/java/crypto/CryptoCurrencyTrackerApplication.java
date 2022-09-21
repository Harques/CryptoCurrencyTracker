package crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class CryptoCurrencyTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoCurrencyTrackerApplication.class);
    }
    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Test");
    }
}
