package data;

import java.util.ArrayList;

import base.Warp;
import base.unit.Direction;
import base.unit.Point;
import base.unit.Vector;
import client.WINDOW;
import client.ui.map.UI_Map;

public class Warps {
    private static final ArrayList<Warp> WARPS_LIST = new ArrayList<>();
    private static final ArrayList<Point> WARPS_ON_MAP = new ArrayList<>();
    private static final Warp CENTER = new Warp("CENTER", new Point(-20, -40));
    private static final Point CENTER_ON_MAP = new Point(WINDOW.OFFSET + UI_Map.WIDTH / 2, WINDOW.OFFSET + UI_Map.WIDTH / 2);

    public static Warp getCENTER() {
        return CENTER;
    }

    public static Warp getWarp(int index) {
        return WARPS_LIST.get(index);
    }

    public static int getListSize() {
        return WARPS_LIST.size();
    }

    public static void addWarp(Warp warp) {
        WARPS_LIST.add(warp);
    }

    public static void delWarp(int index) {
        WARPS_LIST.remove(index);
    }

    public static ArrayList<Point> getWarpsOnMap() {
        return WARPS_ON_MAP;
    }

    public static void warpsToPosOnMap() {
        int maxX = 0, maxZ = 0;
        ArrayList<Vector> vectors = new ArrayList<>();
        for (Warp warp : WARPS_LIST) {
            Vector temp = new Vector(warp.getPos()).minus(new Vector(CENTER.getPos()));
            vectors.add(temp);
            if (Math.abs(temp.getX()) > maxX) maxX = Math.abs(temp.getX());
            if (Math.abs(temp.getZ()) > maxZ) maxZ = Math.abs(temp.getZ());
        }
        float ratio = (UI_Map.WIDTH / 2.0f - WINDOW.OFFSET) / (float) Math.max(maxX, maxZ);
        for (int i = 0; i < vectors.size(); i++) {
            if (Math.abs(vectors.get(i).getX()) > Math.abs(vectors.get(i).getZ())) {
                if (vectors.get(i).getX() > 0) {
                    Warps.getWarp(i).setTrunkDirection(Direction.EAST);
                } else {
                    Warps.getWarp(i).setTrunkDirection(Direction.WEST);
                }
                if (vectors.get(i).getZ() > 0) {
                    Warps.getWarp(i).setBranchDirection(Direction.SOUTH);
                } else {
                    Warps.getWarp(i).setBranchDirection(Direction.NORTH);
                }
            } else {
                if (vectors.get(i).getZ() > 0) {
                    Warps.getWarp(i).setTrunkDirection(Direction.SOUTH);
                } else {
                    Warps.getWarp(i).setTrunkDirection(Direction.NORTH);
                }
                if (vectors.get(i).getX() > 0) {
                    Warps.getWarp(i).setBranchDirection(Direction.EAST);
                } else {
                    Warps.getWarp(i).setBranchDirection(Direction.WEST);
                }
            }
            WARPS_ON_MAP.add(new Point(vectors.get(i).ratio(ratio).add(new Vector(CENTER_ON_MAP))));
        }
    }

    public static Point getCenterOnMap() {
        return CENTER_ON_MAP;
    }
}
