package client.ui.graphics;

import client.ui.UI;

import java.awt.*;

public class Words {
    //绘制文字
    public static void writeWords(float x, float y, int size, String words, Graphics2D g2d){
        g2d.setFont(new Font(UI.DEFAULT_FONT, Font.PLAIN,size));
        g2d.drawString(words,x,y);
    }
}
