import javax.swing.*;
import java.awt.*;

class Figure extends JComponent
{
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

public class JLayeredPaneTest extends JFrame
{
    private static final long serialVersionUID = 1L;

    public JLayeredPaneTest()
    {
        // создание окна
        super("Example LayeredTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // определение многослойной панели
        JLayeredPane lp = getLayeredPane();

        Figure figure1 = new Figure(Color.red , 0, "Figure popup top app pap pop pep");
        Figure figure2 = new Figure(Color.blue, 0, "Figure 1");
        Figure figure3 = new Figure(Color.cyan, 1, "Figure popup top app pap pop pep");

        figure1.setBounds(10, 40, 120, 120);
        figure2.setBounds(60, 120, 160, 180);
        figure3.setBounds(90, 55, 500, 300);
        // добавление фигур в различные слои
        lp.add(figure1, JLayeredPane.POPUP_LAYER  );
        lp.add(figure2, JLayeredPane.PALETTE_LAYER);
        lp.add(figure3, JLayeredPane.PALETTE_LAYER);
        // смена позиции одной из фигур
//        lp.setPosition(figure3, 0);
        figure1.setLocation(100,100);
        // определение размера и открытие окна
        setSize(500, 500);
        setVisible(true);
        JButton newButton = new JButton();
        getContentPane().add(newButton);
    }

    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JLayeredPaneTest();
    }
}