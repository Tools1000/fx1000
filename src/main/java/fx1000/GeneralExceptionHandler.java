package fx1000;


import lombok.extern.slf4j.Slf4j;

import java.util.ResourceBundle;

@Slf4j
public class GeneralExceptionHandler {

    private final static String ALERT_TITLE = "error.alert.title";

    private final ResourceBundle resourceBundle;

    private class Handler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            log.error("Uncaught exception on thread {}", t, e);
            showAlertDialog(e);
        }
    }

    public GeneralExceptionHandler(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        Thread.setDefaultUncaughtExceptionHandler(new Handler());
    }

    public void showAlertDialog(Throwable e) {
        Alerts.exceptionAlert(String.format(resourceBundle.getString(ALERT_TITLE)), e);
    }
}
