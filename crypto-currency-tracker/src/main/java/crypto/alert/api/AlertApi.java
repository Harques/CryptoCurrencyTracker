package crypto.alert.api;

import crypto.alert.api.request.AlertCreateInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/alert")
public interface AlertApi {

    @PostMapping
    ResponseEntity<Void> createAlert(@Valid @RequestBody AlertCreateInput alertCreateInput);

    @DeleteMapping
    ResponseEntity<Void> deleteAlert(@RequestParam Integer id);

    @PatchMapping
    ResponseEntity<Void> editAlert(@RequestParam Integer id);

}
