

package fx1000;

import javafx.scene.Node;

import java.util.Locale;
import java.util.Random;
import java.util.stream.Stream;

public class UiUtil {

    public static String getRandomColorString() {
        return String.format("#%06x", new Random().nextInt(256 * 256 * 256));
    }

    public static String getRandomRgbaColorString(double alpha) {
        return String.format(Locale.ENGLISH, "rgba(%d,%d,%d,%.2f)", new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256), alpha);
    }

    public static void applyRandomColors(Node... elements) {
        Stream.of(elements).forEach(l -> l.setStyle("-fx-background-color: " + UiUtil.getRandomRgbaColorString(0.3) + ";"));
    }

    public static <T extends Node> T applyDebug(T node, boolean isDebug) {
        if (isDebug) {
            applyRandomColors(node);
        }
        return node;
    }
}
