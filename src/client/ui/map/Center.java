package client.ui.map;

import client.ui.graphics.Shapes;
import data.Warps;

import java.awt.*;

public class Center {
    public static void drawCenter(Graphics2D g2d) {
        if (UI_Map.highlight != Integer.MAX_VALUE && UI_Map.highlight < Warps.getListSize()) {

            Shapes.drawCircle(UI_Map.CENTER_WEIGHT, UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT, Warps.getCenterOnMap()
                    , Warps.getWarp(UI_Map.highlight).getTrunkColor(), Warps.getWarp(UI_Map.highlight).getBrunchColor().brighter(), g2d);

        } else {
            Shapes.drawCircle(UI_Map.CENTER_WEIGHT, UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT, Warps.getCenterOnMap()
                    , UI_Map.CENTER_COLOR, Color.GRAY.darker(), g2d);
        }

    }
}
