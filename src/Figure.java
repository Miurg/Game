import javax.swing.*;
import java.awt.*;
import java.io.Serial;

class Figure extends JComponent
{
    @Serial
    private static final long serialVersionUID = 1L;
    private Color color;
    private int type;
    private String text;
    Figure(Color color, int type, String text) {
        this.color = color;
        this.type = type;
        this.text = text;
    }

    public void paintComponent(Graphics g) {
        // прорисовка фигуры
        g.setColor(color);
        switch (type) {
            case 0 -> {
                g.setColor(Color.black);
                g.fillOval(0, 0, this.getBounds().width, this.getBounds().height);
                g.setColor(color);
                g.fillOval(2, 2, this.getBounds().width-4, this.getBounds().height-4);
            }
            case 1 -> {
                g.setColor(Color.black);
                g.fillRect(0, 0, this.getBounds().width, this.getBounds().height);
                g.setColor(color);
                g.fillRect(2, 2, this.getBounds().width-4, this.getBounds().height-4);
            }
        }
        g.setColor(Color.yellow);
        g.drawString(text, (this.getBounds().width/2)-(text.length()*3), this.getBounds().height/2);
    }
}