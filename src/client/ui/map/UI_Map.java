package client.ui.map;

import base.unit.Point;
import client.WINDOW;
import client.ui.UI;
import client.ui.graphics.Shapes;
import client.ui.warpslist.UI_WarpsList;
import data.Warps;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

//绘制地图
public class UI_Map {
    //地图绘制起始点
    public static final Point POSITION = new Point(new Point(WINDOW.OFFSET, WINDOW.OFFSET));
    //地图宽度
    public static final int WIDTH = WINDOW.HEIGHT - WINDOW.OFFSET * 2;
    //地图高度
    public static final int HEIGHT = WINDOW.HEIGHT - WINDOW.OFFSET * 2;

    public static final int SIGNS_SIZE = 8;//2//8
    public static final int SIGNS_FRAME_WEIGHT = 2;
    public static final int SIGNS_HIGHLIGHT_SIZE = SIGNS_SIZE + 4;
    public static final int SIGNS_FRAME_HIGHLIGHT_WEIGHT = SIGNS_FRAME_WEIGHT + 6;
    public static final int CENTER_WEIGHT = 16;//4//16
    public static final Color CENTER_COLOR = new Color(200, 200, 200);

    public static int highlight = Integer.MAX_VALUE;

    //绘制地图边框
    public static void drawMap(Graphics2D g2d) {
        Shapes.drawRoundRect(WIDTH, HEIGHT, POSITION, 10, UI.DEFAULT_BG_COLOR, g2d);
        for (int i = 0; i < Warps.getListSize(); i++) {
            Road.drawRoad(i, false, g2d);
            Sign.drawSign(i, g2d);
        }
        for (int i = 0; i < Warps.getListSize(); i++) {
            if (UI_WarpsList.selected + UI_WarpsList.index - 1 == i) {
                Road.drawRoad(i, true, g2d);
                Sign.drawSign(i, g2d);
            }
        }
        for (int i = 0; i < Warps.getListSize(); i++) {
            if (UI_Map.highlight == i) {
                Road.drawRoad(i, true, g2d);
                Sign.drawSign(i, g2d);
            }
        }
        Center.drawCenter(g2d);
    }

    public static void createImage() {
        BufferedImage map = new BufferedImage(WINDOW.HEIGHT, WINDOW.HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D mapG = (Graphics2D) map.getGraphics();
        mapG.setColor(new Color(214,190,150));
        mapG.fillRect(0,0,WINDOW.HEIGHT,WINDOW.HEIGHT);
        for (int i = 0; i < Warps.getListSize(); i++) {
            Road.drawRoad(i, false, mapG);
            Sign.drawSign(i, mapG);
        }
        Center.drawCenter(mapG);
        try {
            ImageIO.write(map, "PNG", new FileOutputStream("C:/Users/22799/Desktop/NetherTraffic.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
