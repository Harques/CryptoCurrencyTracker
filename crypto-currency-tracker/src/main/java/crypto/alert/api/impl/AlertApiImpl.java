package crypto.alert.api.impl;

import crypto.alert.api.AlertApi;
import crypto.alert.api.request.AlertCreateInput;
import crypto.alert.service.AlertService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@Api(tags = "Alert API")
@Tag(name = "Alert API", description = "Alert API")
public class AlertApiImpl implements AlertApi {

    private final AlertService alertService;

    @Override
    public ResponseEntity<Void> createAlert(AlertCreateInput alertCreateInput) {
        alertService.createAlert(alertCreateInput);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Void> deleteAlert(Integer id) {
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> editAlert(Integer id) {
        alertService.editAlert(id);
        return ResponseEntity.noContent().build();
    }
}
