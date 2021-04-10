package client.ui.warpslist;

import client.ui.graphics.Shapes;
import client.ui.graphics.Words;
import data.Warps;

import java.awt.*;
import java.awt.geom.GeneralPath;

//绘制单元格
public class Bar {
    private static final int CENTER_OFFSET_Y = (int) ((UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET - UI_WarpsList.FONT_SIZE) * 0.5f);
    private static final int CENTER_OFFSET_X = 8;

    public static void drawBar(Graphics2D g2d, int ROW, int index, Color color) {
        if (ROW > UI_WarpsList.AMOUNT - 1) {
            System.out.println("Out Of Range: index " + ROW + " > AMOUNT " + (UI_WarpsList.AMOUNT - 1));
            return;
        }
        float PERCENTAGE = 0;   //   TEMP/PERCENTAGE== 单元格占比
        float TEMP = 0;         //
        for (float i : UI_WarpsList.COW_WIDE) {
            PERCENTAGE += i;
        }
        //绘制表格 行
        Shapes.drawRoundRect(UI_WarpsList.WIDTH, UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT, UI_WarpsList.POSITION.getX(), UI_WarpsList.POSITION.getZ() + ROW * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET), 10, color, g2d);
        GeneralPath p = new GeneralPath();
        //绘制表格 列
        for (int i = 0; i < UI_WarpsList.COW_WIDE.length; TEMP += UI_WarpsList.COW_WIDE[i], i++) {
            if (ROW == 0) {
                Words.writeWords(UI_WarpsList.POSITION.getX() + TEMP / PERCENTAGE * UI_WarpsList.WIDTH + CENTER_OFFSET_X, UI_WarpsList.POSITION.getZ() + (ROW + 1) * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET) - CENTER_OFFSET_Y, UI_WarpsList.FONT_SIZE, UI_WarpsList.COW_NAME[i], g2d);
            } else if (index - 1 < Warps.getListSize()) {
                switch (i) {
                    //绘制地标名字
                    case 0 -> Words.writeWords(UI_WarpsList.POSITION.getX() + TEMP / PERCENTAGE * UI_WarpsList.WIDTH + CENTER_OFFSET_X, UI_WarpsList.POSITION.getZ() + (ROW + 1) * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET) - CENTER_OFFSET_Y, UI_WarpsList.FONT_SIZE,
                            Warps.getWarp(index - 1).getNAME(), g2d);
                    //绘制地标坐标 X
                    case 1 -> Words.writeWords(UI_WarpsList.POSITION.getX() + TEMP / PERCENTAGE * UI_WarpsList.WIDTH + CENTER_OFFSET_X, UI_WarpsList.POSITION.getZ() + (ROW + 1) * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET) - CENTER_OFFSET_Y, UI_WarpsList.FONT_SIZE,
                            Integer.toString(Warps.getWarp(index - 1).getPos().getX()), g2d);
                    //绘制地标坐标 Z
                    case 2 -> Words.writeWords(UI_WarpsList.POSITION.getX() + TEMP / PERCENTAGE * UI_WarpsList.WIDTH + CENTER_OFFSET_X, UI_WarpsList.POSITION.getZ() + (ROW + 1) * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET) - CENTER_OFFSET_Y, UI_WarpsList.FONT_SIZE,
                            Integer.toString(Warps.getWarp(index - 1).getPos().getZ()), g2d);
                    //方向
                    case 3 -> Words.writeWords(UI_WarpsList.POSITION.getX() + TEMP / PERCENTAGE * UI_WarpsList.WIDTH + CENTER_OFFSET_X, UI_WarpsList.POSITION.getZ() + (ROW + 1) * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET) - CENTER_OFFSET_Y, UI_WarpsList.FONT_SIZE,
                            Warps.getWarp(index-1).getTrunk().toString(), g2d);
                    //支路
                    case 4 -> Words.writeWords(UI_WarpsList.POSITION.getX() + TEMP / PERCENTAGE * UI_WarpsList.WIDTH + CENTER_OFFSET_X, UI_WarpsList.POSITION.getZ() + (ROW + 1) * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET) - CENTER_OFFSET_Y, UI_WarpsList.FONT_SIZE,
                            Warps.getWarp(index-1).getBranch().toString(), g2d);
                    //未定义的情况
                    default -> System.out.println("DATA_IMPORT: Undefined situation");
                }
            }

            if (TEMP == 0) continue;
            p.moveTo(UI_WarpsList.POSITION.getX() + TEMP / PERCENTAGE * UI_WarpsList.WIDTH, UI_WarpsList.POSITION.getZ() + ROW * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET));
            p.lineTo(UI_WarpsList.POSITION.getX() + TEMP / PERCENTAGE * UI_WarpsList.WIDTH, UI_WarpsList.POSITION.getZ() + ROW * (UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT - UI_WarpsList.DISPLAY_FIX_OFFSET) + UI_WarpsList.HEIGHT / UI_WarpsList.AMOUNT);
        }
        g2d.setColor(Color.BLACK);
        g2d.draw(p);
    }
}
