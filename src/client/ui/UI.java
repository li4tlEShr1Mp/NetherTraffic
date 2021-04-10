package client.ui;

import client.WINDOW;
import client.listener.MouseStatue;
import client.ui.graphics.Shapes;
import client.ui.map.UI_Map;
import client.ui.warpslist.UI_WarpsList;
import data.Warps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;

public class UI extends JPanel {
    public static final Color DEFAULT_BG_COLOR = new Color(230, 230, 230);
    public static final String DEFAULT_FONT = "等线";

    public UI() {
        super();
        setPreferredSize(new Dimension(WINDOW.WIDTH, WINDOW.HEIGHT));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                MouseStatue.paddingScroller(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                MouseStatue.isDraggingScroller=false;
                UI_WarpsList.selected = MouseStatue.mouseInRow(e);
                int selectedTemp=MouseStatue.mouseOnSign(e);
                if(selectedTemp!=Integer.MAX_VALUE){
                    UI_WarpsList.selected = selectedTemp-UI_WarpsList.index+1;
                    System.out.println(UI_WarpsList.selected);
                    if(UI_WarpsList.selected>UI_WarpsList.AMOUNT-1){
                        UI_WarpsList.index+=UI_WarpsList.selected-UI_WarpsList.AMOUNT+1;
                        UI_WarpsList.selected=UI_WarpsList.AMOUNT-1;
                    }
                    if(UI_WarpsList.selected<1){
                        UI_WarpsList.index+=UI_WarpsList.selected-1;
                        UI_WarpsList.selected=1;
                    }
                }
                repaint();
            }

        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                MouseStatue.draggingScroller(e);
                repaint();
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                UI_WarpsList.highlight = MouseStatue.mouseInRow(e);
                UI_Map.highlight = MouseStatue.mouseOnSign(e);
                if(UI_WarpsList.highlight!=Integer.MAX_VALUE){
                        UI_Map.highlight=UI_WarpsList.highlight+UI_WarpsList.index-1;
                }
                repaint();
            }
        });
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                if(e.getWheelRotation()==1&&UI_WarpsList.AMOUNT+UI_WarpsList.index-1<Warps.getListSize()){
                    UI_WarpsList.selected--;
                    UI_WarpsList.index++;
                    if(UI_WarpsList.selected<1)UI_WarpsList.selected=Integer.MAX_VALUE;
                }
                if(e.getWheelRotation()==-1&&UI_WarpsList.index>0){
                    UI_WarpsList.selected++;
                    UI_WarpsList.index--;
                    if(UI_WarpsList.selected>UI_WarpsList.AMOUNT-1)UI_WarpsList.selected=Integer.MAX_VALUE;
                }
                repaint();
            }
        });
        setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(0.8f));
        Shapes.drawRoundRect(getWidth(), getHeight(), 0, 0, 0, new Color(238, 238, 238), g2d);
        UI_WarpsList.drawList(g2d);
        UI_Map.drawMap(g2d);
    }
}
