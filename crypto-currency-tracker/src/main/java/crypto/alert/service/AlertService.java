package crypto.alert.service;

import crypto.alert.api.request.AlertCreateInput;

public interface AlertService {
    void createAlert(AlertCreateInput alertCreateInput);

    void deleteAlert(Integer id);

    void editAlert(Integer id);
}
