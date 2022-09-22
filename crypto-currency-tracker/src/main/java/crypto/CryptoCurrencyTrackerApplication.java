package crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@RestController
public class CryptoCurrencyTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoCurrencyTrackerApplication.class);
    }

    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> user(){
        return ResponseEntity.ok("User");
    }
    @GetMapping("/user")
//    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> admin(){
        return ResponseEntity.ok("Admin");
    }
}
