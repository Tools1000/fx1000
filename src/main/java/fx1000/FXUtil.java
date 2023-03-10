package fx1000;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TreeItem;
import org.apache.commons.lang3.SystemUtils;

/**
 * TODO: move to commons
 */
public class FXUtil {
    public static ScrollBar getListViewScrollBar(final ListView<?> listView) {

        ScrollBar scrollbar = null;
        for (final Node node : listView.lookupAll(".scroll-bar")) {
            if (node instanceof ScrollBar) {
                ScrollBar bar = (ScrollBar) node;
                if (bar.getOrientation().equals(Orientation.VERTICAL)) {
                    scrollbar = bar;
                }
            }
        }
        return scrollbar;
    }

    public static void initAppMenu(MenuBar menuBar) {
        if (SystemUtils.IS_OS_MAC) {
            menuBar.useSystemMenuBarProperty().set(true);
        }
    }

    public static void expandTreeView(TreeItem<?> item, boolean expand){
        if(item != null && !item.isLeaf()){
            item.setExpanded(expand);
            for(TreeItem<?> child:item.getChildren()){
                expandTreeView(child, expand);
            }
        }
    }
}
