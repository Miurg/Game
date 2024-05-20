import javax.swing.*;
import java.awt.*;

class Figure extends JComponent
{

    private final int type;


    Figure(int type) {
        this.type = type;
    }

    public void paintComponent(Graphics g) {
        // прорисовка фигуры
        switch (type) {
            case 0 -> {
                ((Graphics2D) g).setStroke(new BasicStroke(2));
                g.drawOval(1,1,this.getBounds().width-2, this.getBounds().height-2);
            }
            case 1 -> {
                ((Graphics2D) g).setStroke(new BasicStroke(2));
                g.drawLine(1,1,100,100);
                g.drawLine(100,1,1,100);
            }
            case 2 -> {
                g.setColor(Color.WHITE);
                g.fillRect(0,0,this.getBounds().width,this.getBounds().height);
            }
        }
    }
}