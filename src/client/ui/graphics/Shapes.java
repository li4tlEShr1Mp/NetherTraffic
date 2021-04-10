package client.ui.graphics;

import base.unit.Point;

import java.awt.*;

//绘制形状
public class Shapes {
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;

    //圆角矩形/矩形
    public static void drawRoundRect(int WIDTH, int HEIGHT, Point POSITION, int R, Color BACKGROUND_COLOR, Color FRAME_COLOR, Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(BACKGROUND_COLOR);
        g2d.fillRoundRect(POSITION.getX(), POSITION.getZ(), WIDTH, HEIGHT, R, R);
        g2d.setColor(FRAME_COLOR);
        g2d.drawRoundRect(POSITION.getX(), POSITION.getZ(), WIDTH, HEIGHT, R, R);
    }

    public static void drawRoundRect(int WIDTH, int HEIGHT, int X, int Y, int R, Color BACKGROUND_COLOR, Color FRAME_COLOR, Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(BACKGROUND_COLOR);
        g2d.fillRoundRect(X, Y, WIDTH, HEIGHT, R, R);
        g2d.setColor(FRAME_COLOR);
        g2d.drawRoundRect(X, Y, WIDTH, HEIGHT, R, R);
    }

    public static void drawRoundRect(int WIDTH, int HEIGHT, Point POSITION, int R, Color BACKGROUND_COLOR, Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(BACKGROUND_COLOR);
        g2d.fillRoundRect(POSITION.getX(), POSITION.getZ(), WIDTH, HEIGHT, R, R);
        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(POSITION.getX(), POSITION.getZ(), WIDTH, HEIGHT, R, R);
    }

    public static void drawRoundRect(int WIDTH, int HEIGHT, int X, int Y, int R, Color BACKGROUND_COLOR, Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(BACKGROUND_COLOR);
        g2d.fillRoundRect(X, Y, WIDTH, HEIGHT, R, R);
        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(X, Y, WIDTH, HEIGHT, R, R);
    }

    public static void drawSquare(int WIDTH, int FRAME_WEIGHT, Point POSITION, Color BACKGROUND_COLOR, Color FRAME_COLOR, Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(FRAME_COLOR);
        g2d.fillRect(POSITION.getX() - WIDTH / 2 - FRAME_WEIGHT, POSITION.getZ() - WIDTH / 2 - FRAME_WEIGHT, WIDTH + 2 * FRAME_WEIGHT, WIDTH + 2 * FRAME_WEIGHT);
        g2d.setColor(BACKGROUND_COLOR);
        g2d.fillRect(POSITION.getX() - WIDTH / 2, POSITION.getZ() - WIDTH / 2, WIDTH, WIDTH);
    }

    public static void drawStraightLine(int WEIGHT, Point BEGIN, Point END, int MODE, Color LINE_COLOR, Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g2d.setColor(LINE_COLOR);
        if (MODE == VERTICAL) {
            if (END.getZ() - BEGIN.getZ() < 0) {
                g2d.fillRect(BEGIN.getX() - WEIGHT / 2, END.getZ() - WEIGHT / 2, WEIGHT, BEGIN.getZ() - END.getZ() + WEIGHT);
            } else {
                g2d.fillRect(BEGIN.getX() - WEIGHT / 2, BEGIN.getZ() - WEIGHT / 2, WEIGHT, END.getZ() - BEGIN.getZ() + WEIGHT);
            }
        } else if (MODE == HORIZONTAL) {
            if (END.getX() - BEGIN.getX() < 0) {
                g2d.fillRect(END.getX() - WEIGHT / 2, BEGIN.getZ() - WEIGHT / 2, BEGIN.getX() - END.getX() + WEIGHT, WEIGHT);

            } else {
                g2d.fillRect(BEGIN.getX() - WEIGHT / 2, BEGIN.getZ() - WEIGHT / 2, END.getX() - BEGIN.getX() + WEIGHT, WEIGHT);
            }
        } else {
            g2d.fillRect(BEGIN.getX(), BEGIN.getZ(), WEIGHT, WEIGHT);
        }
    }

    public static void drawCircle(int RADIUS, int FRAME, Point POS, Color Color,Color FRAME_COLOR, Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        g2d.setColor(FRAME_COLOR);
        g2d.fillOval(POS.getX() -RADIUS, POS.getZ() - RADIUS , RADIUS * 2, RADIUS*2);
        if (FRAME > 0) {
            g2d.setColor(Color);
            g2d.fillOval(POS.getX() - RADIUS + FRAME, POS.getZ() - RADIUS + FRAME, (RADIUS - FRAME) * 2, (RADIUS - FRAME) * 2);
        }
    }
}
