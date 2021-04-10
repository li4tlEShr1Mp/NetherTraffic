package client.ui.map;

import client.ui.graphics.Shapes;
import client.ui.warpslist.UI_WarpsList;
import data.Warps;

import java.awt.*;

public class Sign {
    public static void drawSign(int i, Graphics2D g2d) {
        if (UI_Map.highlight == i||UI_WarpsList.selected+UI_WarpsList.index-1 == i) {
            Shapes.drawSquare(UI_Map.SIGNS_HIGHLIGHT_SIZE, UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT, Warps.getWarpsOnMap().get(i),
                    Warps.getWarp(i).getBrunchColor(), Warps.getWarp(i).getBrunchColor().brighter(), g2d);
        } else {
            Shapes.drawSquare(UI_Map.SIGNS_SIZE, UI_Map.SIGNS_FRAME_WEIGHT, Warps.getWarpsOnMap().get(i),
                    Warps.getWarp(i).getBrunchColor().brighter(), Warps.getWarp(i).getBrunchColor(), g2d);
        }

    }
}
