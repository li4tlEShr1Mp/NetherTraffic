package client;

import client.ui.UI;
import client.ui.map.UI_Map;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class WINDOW extends JFrame {
    /**
     *
     */
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 675;//128//675
    public static final int OFFSET = 20;//20//2
    public static final int SHADOW_OFFSET = 5;
    @Serial
    private static final long serialVersionUID = -2951767431850252249L;

    public WINDOW() {
        setTitle("Nether Traffic");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.white);
        getContentPane().add(new UI());
        UI_Map.createImage();
        pack();
        setVisible(true);
    }
}
