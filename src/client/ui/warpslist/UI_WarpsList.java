package client.ui.warpslist;

import base.unit.Point;
import client.WINDOW;
import client.ui.UI;
import client.ui.graphics.Shapes;

import java.awt.*;

public class UI_WarpsList {

    public static final int DISPLAY_FIX_OFFSET = 2;
    public static final int AMOUNT = 18;
    public static final int WIDTH = WINDOW.WIDTH - WINDOW.HEIGHT - 2 * WINDOW.OFFSET;
    public static final int HEIGHT = WINDOW.HEIGHT - WINDOW.OFFSET * 2;
    public static final int FONT_SIZE = 16;

    public static final float[] COW_WIDE = {7, 5, 5, 4, 4};
    public static final String[] COW_NAME = {"地名", "X", "Z", "方向", "支路"};
    public static final Point POSITION = new Point(WINDOW.HEIGHT, WINDOW.OFFSET);

    public static final Color HIGH_LIGHT_COLOR = new Color(253, 253, 253);
    public static final Color SELECTED_COLOR = new Color(235, 240, 251);

    public static int highlight = Integer.MAX_VALUE;
    public static int selected = Integer.MAX_VALUE;
    public static int index = 0;

    public static void drawList(Graphics2D g2d) {
        Shapes.drawRoundRect(WIDTH, HEIGHT, POSITION, 10, UI.DEFAULT_BG_COLOR, g2d);
        for (int ROW = 0; ROW < AMOUNT; ROW++) {
            if (ROW == 0) {
                Bar.drawBar(g2d, ROW, index + ROW, UI.DEFAULT_BG_COLOR);
            } else if (ROW == selected) {
                Bar.drawBar(g2d, ROW, index + ROW, SELECTED_COLOR);
            } else if (ROW == highlight) {
                Bar.drawBar(g2d, ROW, index + ROW, HIGH_LIGHT_COLOR);
            } else {
                Bar.drawBar(g2d, ROW, index + ROW, new Color(245, 245, 245));
            }
        }
        Scroller.drawScroller(g2d);
    }
}
