package client.listener;

import client.WINDOW;
import client.ui.map.UI_Map;
import client.ui.warpslist.Scroller;
import client.ui.warpslist.UI_WarpsList;
import data.Warps;

import java.awt.event.MouseEvent;

public class MouseStatue {
    private static final int OUT_OF_RANGE = Integer.MAX_VALUE;

    public static int mouseInRow(MouseEvent e) {
        if (e.getX() > UI_WarpsList.POSITION.getX() && e.getX() < UI_WarpsList.POSITION.getX() + UI_WarpsList.WIDTH) {
            for (int ROW = 1; ROW < UI_WarpsList.AMOUNT; ROW++) {
                boolean top = e.getY() > UI_WarpsList.POSITION.getZ() + ROW * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET);
                boolean bottom = e.getY() < UI_WarpsList.POSITION.getZ() + ROW * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET) + UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT;
                if (top && bottom) return ROW;
            }
            return OUT_OF_RANGE;
        }
        return OUT_OF_RANGE;
    }

    public static int mouseOnSign(MouseEvent e) {
        for (int i = 0; i < Warps.getWarpsOnMap().size(); i++) {
            if (UI_Map.highlight == i) {
                if (e.getX() > Warps.getWarpsOnMap().get(i).getX() - UI_Map.SIGNS_HIGHLIGHT_SIZE / 2 - UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT &&
                        e.getX() < Warps.getWarpsOnMap().get(i).getX() + UI_Map.SIGNS_HIGHLIGHT_SIZE / 2 + UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT &&
                        e.getY() > Warps.getWarpsOnMap().get(i).getZ() - UI_Map.SIGNS_HIGHLIGHT_SIZE / 2 - UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT &&
                        e.getY() < Warps.getWarpsOnMap().get(i).getZ() + UI_Map.SIGNS_HIGHLIGHT_SIZE / 2 + UI_Map.SIGNS_FRAME_HIGHLIGHT_WEIGHT) {
                    return i;
                } else return OUT_OF_RANGE;
            } else {
                if (e.getX() > Warps.getWarpsOnMap().get(i).getX() - UI_Map.SIGNS_SIZE / 2 - UI_Map.SIGNS_FRAME_WEIGHT &&
                        e.getX() < Warps.getWarpsOnMap().get(i).getX() + UI_Map.SIGNS_SIZE / 2 + UI_Map.SIGNS_FRAME_WEIGHT &&
                        e.getY() > Warps.getWarpsOnMap().get(i).getZ() - UI_Map.SIGNS_SIZE / 2 - UI_Map.SIGNS_FRAME_WEIGHT &&
                        e.getY() < Warps.getWarpsOnMap().get(i).getZ() + UI_Map.SIGNS_SIZE / 2 + UI_Map.SIGNS_FRAME_WEIGHT) {
                    return i;
                }
            }
        }
        return OUT_OF_RANGE;
    }

    public static void draggingScroller(MouseEvent e) {
        if (!isDraggingScroller && e.getX() > Scroller.currentPosition.getX() && e.getX() < Scroller.currentPosition.getX() + WINDOW.OFFSET
                && e.getY() > Scroller.currentPosition.getZ() && e.getY() < Scroller.currentPosition.getZ() + Scroller.scrollerBarHeight) {
            isDraggingScroller = true;
            offsetScroller = e.getY() - Scroller.currentPosition.getZ();
            System.out.println(isDraggingScroller);
        }
        if (isDraggingScroller) {
            UI_WarpsList.index =
                    e.getY() < WINDOW.HEIGHT - WINDOW.OFFSET - Scroller.scrollerBarHeight+offsetScroller ?
                            (e.getY() - WINDOW.OFFSET - offsetScroller) > 0 ?
                                    (int) ((e.getY() - WINDOW.OFFSET - offsetScroller) / Scroller.moveEachLine) : 0
                            : Warps.getListSize() - UI_WarpsList.AMOUNT + 1;
        }
    }

    public static void paddingScroller(MouseEvent e) {
        if (e.getX() > UI_WarpsList.WIDTH + WINDOW.HEIGHT && e.getX() < UI_WarpsList.WIDTH + WINDOW.HEIGHT + WINDOW.OFFSET
                && e.getY() > WINDOW.OFFSET && e.getY() < WINDOW.OFFSET + UI_WarpsList.HEIGHT) {
            UI_WarpsList.index =
                    e.getY() < WINDOW.HEIGHT - WINDOW.OFFSET - Scroller.scrollerBarHeight / 2 ?
                            e.getY() - WINDOW.OFFSET - Scroller.scrollerBarHeight / 2 > 0 ?
                                    (int) ((e.getY() - WINDOW.OFFSET - Scroller.scrollerBarHeight / 2) / Scroller.moveEachLine) : 0
                            : Warps.getListSize() - UI_WarpsList.AMOUNT + 1;
        }
    }

    private static float offsetScroller = 0;
    public static boolean isDraggingScroller = false;

}