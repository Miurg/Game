import javax.swing.*;
import java.awt.*;

import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class JLayeredPaneTest extends JFrame
{
    private static final long serialVersionUID = 1L;


    public Figure[] initFigure(JLayeredPane lp)
    {
        Figure[] massFigure = new Figure[3];

        massFigure[0] = new Figure(Color.red , 0, "Figure popup top app pap pop pep");
        massFigure[1] = new Figure(Color.blue, 0, "Figure 1");
        massFigure[2] = new Figure(Color.cyan, 1, "Figure popup top app pap pop pep");

        massFigure[0].setBounds(100, 400, 120, 120);
        massFigure[1].setBounds(200, 240, 160, 180);
        massFigure[2].setBounds(150, 550, 500, 300);

        lp.add(massFigure[0], JLayeredPane.POPUP_LAYER  );
        lp.add(massFigure[1], JLayeredPane.PALETTE_LAYER);
        lp.add(massFigure[2], JLayeredPane.PALETTE_LAYER);


        return(massFigure);
    }
    public JLayeredPaneTest()
    {
        // создание окна
        super("Example LayeredTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLayeredPane lp = getLayeredPane();

        Figure[] massFigure = new Figure[3];

        massFigure = initFigure(lp);

        Container container = getContentPane();
        container.setLayout(new FlowLayout( FlowLayout.LEFT, 10, 10));



        // Изменение выравнивания текста и изображения
        JButton button = new JButton("Кнопка тест");
        button.setMargin                (new Insets(10, 10, 10, 10));
        button.setVerticalAlignment     (SwingConstants.TOP   );
        button.setHorizontalAlignment   (SwingConstants.RIGHT );
        button.setHorizontalTextPosition(SwingConstants.LEFT  );
        button.setVerticalTextPosition  (SwingConstants.BOTTOM);
        button.setIconTextGap(10);
        // сделаем кнопку большой, чтобы увидеть выравнивание
        button.setPreferredSize(new Dimension(300, 100));
        button.addActionListener(new TestActionListener());
        container.add(button);

        // определение размера и открытие окна
        setSize(500, 500);
        setVisible(true);
    }

    class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JLayeredPaneTest();
    }
}