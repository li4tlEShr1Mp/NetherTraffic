package client;

import base.Warp;
import base.unit.Point;
import data.Warps;

import java.awt.*;
import java.util.Random;

public class Launcher {
    public static void main(String[] args) {
        Random r = new Random();


        Warps.addWarp(new Warp("工厂", new Point(11, -31), new Color(r.nextInt(130) + 100, r.nextInt(130) + 100, r.nextInt(130) + 100)));
        Warps.addWarp(new Warp("未知1", new Point(91, -20), new Color(r.nextInt(130) + 100, r.nextInt(130) + 100, r.nextInt(130) + 100)));
        Warps.addWarp(new Warp("史莱姆农场", new Point(123, -79), new Color(r.nextInt(130) + 100, r.nextInt(130) + 100, r.nextInt(130) + 100)));
        Warps.addWarp(new Warp("教堂", new Point(-54, -209), new Color(r.nextInt(130) + 100, r.nextInt(130) + 100, r.nextInt(130) + 100)));
        Warps.addWarp(new Warp("末地", new Point(-133, -196), new Color(r.nextInt(130) + 100, r.nextInt(130) + 100, r.nextInt(130) + 100)));
        Warps.addWarp(new Warp("印钞机", new Point(196, -225), new Color(r.nextInt(130) + 100, r.nextInt(130) + 100, r.nextInt(130) + 100)));
        Warps.addWarp(new Warp("印钞机Plus", new Point(60, -249), new Color(r.nextInt(130) + 100, r.nextInt(130) + 100, r.nextInt(130) + 100)));
 /*       Warps.addWarp(new Warp("AAA", new Point(156, -913)));
        Warps.addWarp(new Warp("AAA", new Point(433, 600)));
        Warps.addWarp(new Warp("AAA", new Point(-532, -595)));
        Warps.addWarp(new Warp("AAA", new Point(-842, 13)));
        Warps.addWarp(new Warp("AAA", new Point(544, -154)));
        Warps.addWarp(new Warp("AAA", new Point(-233, 13)));
        Warps.addWarp(new Warp("AAA", new Point(900, 200),new Color(165,126,87)));
 */
        for (int i = 0; i < 300; i++) {
            Warps.addWarp(new Warp("RandomTest", new Point(r.nextInt(800) - 400, r.nextInt(800) - 400),
                    new Color(r.nextInt(130) + 100
                            , r.nextInt(130) + 100
                            , r.nextInt(130) + 100)));
        }


        Warps.warpsToPosOnMap();


        new WINDOW();
    }
}

