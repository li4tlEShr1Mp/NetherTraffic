package client.ui.warpslist;

import base.unit.Point;
import client.WINDOW;
import client.ui.UI;
import client.ui.graphics.Shapes;
import data.Warps;

import java.awt.*;

public class Scroller {
    public static final float scrollerBarHeight = UI_WarpsList.HEIGHT / (float) (Warps.getListSize() / (UI_WarpsList.AMOUNT - 1) + 1);
    public static final float moveEachLine = (UI_WarpsList.HEIGHT - scrollerBarHeight) / (float) (Warps.getListSize() - (UI_WarpsList.AMOUNT-1));
    public static Point currentPosition;

    public static void drawScroller(Graphics2D g2d) {
        currentPosition = new Point(UI_WarpsList.WIDTH + WINDOW.HEIGHT, WINDOW.OFFSET + (int) (UI_WarpsList.index * moveEachLine));
        Shapes.drawRoundRect(WINDOW.OFFSET, UI_WarpsList.HEIGHT, new Point(UI_WarpsList.WIDTH + WINDOW.HEIGHT, WINDOW.OFFSET), 6, UI.DEFAULT_BG_COLOR, g2d);
        Shapes.drawRoundRect(WINDOW.OFFSET, (int) scrollerBarHeight, currentPosition, 6, new Color(200, 200, 200), g2d)
        ;

    }


}
