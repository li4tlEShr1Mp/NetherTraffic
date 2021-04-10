package client.ui.map;

import base.unit.Direction;
import base.unit.Point;
import client.ui.graphics.Shapes;
import data.Warps;

import java.awt.*;

public class Road {
    public static void drawRoad(int i, boolean isHighlight, Graphics2D g2d) {
        if (isHighlight) {
            drawBrunch(i, UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT + UI_Map.SIGNS_HIGHLIGHT_SIZE, Warps.getWarp(i).getBrunchColor(), g2d);
            drawTrunk(i, UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT + UI_Map.SIGNS_HIGHLIGHT_SIZE, Warps.getWarp(i).getBrunchColor(), g2d);
            drawBrunch(i, UI_Map.SIGNS_SIZE - 2, Warps.getWarp(i).getBrunchColor().brighter(), g2d);
            drawTrunk(i, UI_Map.SIGNS_SIZE - 2, Warps.getWarp(i).getBrunchColor().brighter(), g2d);
            drawCross(i, UI_Map.SIGNS_SIZE - 4, Warps.getWarp(i).getBrunchColor().brighter(), g2d);
        } else {
            drawBrunch(i, UI_Map.SIGNS_SIZE, Warps.getWarp(i).getBrunchColor(), g2d);
            drawTrunk(i, UI_Map.SIGNS_SIZE+2, Warps.getWarp(i).getTrunkColor(), g2d);
        }
    }

    public static void drawTrunk(int i, int WEIGHT, Color LINE_COLOR, Graphics2D g2d) {
        if (Warps.getWarp(i).getTrunk() == Direction.EAST || Warps.getWarp(i).getTrunk() == Direction.WEST) {
            Shapes.drawStraightLine(WEIGHT, new Point(Warps.getWarpsOnMap().get(i).getX(), Warps.getCenterOnMap().getZ()), Warps.getCenterOnMap(), Shapes.HORIZONTAL,
                    LINE_COLOR, g2d);
        }
        if (Warps.getWarp(i).getTrunk() == Direction.NORTH || Warps.getWarp(i).getTrunk() == Direction.SOUTH) {
            Shapes.drawStraightLine(WEIGHT, new Point(Warps.getCenterOnMap().getX(), Warps.getWarpsOnMap().get(i).getZ()), Warps.getCenterOnMap(), Shapes.VERTICAL,
                    LINE_COLOR, g2d);
        }

    }

    public static void drawBrunch(int i, int WEIGHT, Color LINE_COLOR, Graphics2D g2d) {
        if (Warps.getWarp(i).getBranch() == Direction.EAST || Warps.getWarp(i).getBranch() == Direction.WEST) {
            Shapes.drawStraightLine(WEIGHT, Warps.getWarpsOnMap().get(i), Warps.getCenterOnMap(), Shapes.HORIZONTAL,
                    LINE_COLOR, g2d);
        }
        if (Warps.getWarp(i).getBranch() == Direction.NORTH || Warps.getWarp(i).getBranch() == Direction.SOUTH) {
            Shapes.drawStraightLine(WEIGHT, Warps.getWarpsOnMap().get(i), Warps.getCenterOnMap(), Shapes.VERTICAL,
                    LINE_COLOR, g2d);
        }
    }

    public static void drawCross(int i, int WEIGHT, Color LINE_COLOR, Graphics2D g2d) {
        if (Warps.getWarp(i).getTrunk() == Direction.EAST || Warps.getWarp(i).getTrunk() == Direction.WEST) {
            Shapes.drawSquare(WEIGHT, 0, new Point(Warps.getWarpsOnMap().get(i).getX(), Warps.getCenterOnMap().getZ()),
                    LINE_COLOR, LINE_COLOR, g2d);
        }
        if (Warps.getWarp(i).getTrunk() == Direction.NORTH || Warps.getWarp(i).getTrunk() == Direction.SOUTH) {
            Shapes.drawSquare(WEIGHT, 0, new Point(Warps.getCenterOnMap().getX(), Warps.getWarpsOnMap().get(i).getZ()),
                    LINE_COLOR, LINE_COLOR, g2d);
        }
    }
}
