package fx1000;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import tools1000.ToolsUtil;

public class Alerts {

    public static void exceptionAlert(String title, Throwable t) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(t.getLocalizedMessage());
        TextArea area = new TextArea(ToolsUtil.stackTraceToString(t));
        alert.getDialogPane().setContent(area);
        area.setWrapText(true);
        area.setEditable(false);
        alert.setResizable(true);
        alert.getDialogPane().setPrefHeight(300);
        alert.getDialogPane().setPrefWidth(400);
        alert.showAndWait();

    }


    public static void errorAlert(String title, String headerText, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        alert.getDialogPane().setPrefHeight(300);
        alert.getDialogPane().setPrefWidth(400);
        alert.showAndWait();
    }
}
