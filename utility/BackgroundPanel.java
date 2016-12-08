package utility;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Image im = null;
        try {
            im = ImageIO.read(new File("src\\images\\background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(im, 0, 0, null);
    }
}