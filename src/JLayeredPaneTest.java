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
    Figure[] massFigureTic = new Figure[9];
    Figure[] massFigureTac = new Figure[9];
    JButton[] massButtons = new JButton[9];
    boolean tickers = true;
    JLayeredPane lp = getLayeredPane();

    public Figure[] initFigure(Figure[] massFigure, boolean ifTic) {
        if (ifTic)
        {
            for (int i = 0; i < massFigure.length; i++) massFigure[i] = new Figure( 0);

        }
        else
        {
            for (int i = 0; i < massFigure.length; i++) massFigure[i] = new Figure( 1);
        }
        massFigure[0].setBounds(1, 25, 100, 100);
        massFigure[1].setBounds(1, 125, 100, 100);
        massFigure[2].setBounds(1, 225, 100, 100);

        massFigure[3].setBounds(100, 25, 100, 100);
        massFigure[4].setBounds(100, 125, 100, 100);
        massFigure[5].setBounds(100, 225, 100, 100);

        massFigure[6].setBounds(200, 25, 100, 100);
        massFigure[7].setBounds(200, 125, 100, 100);
        massFigure[8].setBounds(200, 225, 100, 100);

        for (Figure figure : massFigure) lp.add(figure, JLayeredPane.POPUP_LAYER);
        for (Figure figure : massFigure) figure.setVisible(false);

        return(massFigure);
    }

    public JButton[] initButtons(JButton[] buttons)
        {
            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = new JButton();
                buttons[i].setBorderPainted(false);
                buttons[i].setBackground(Color.white);
                buttons[i].setPreferredSize(new Dimension(100, 100));
                buttons[i].setActionCommand(Integer.toString(i));
                buttons[i].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int number = Integer.parseInt(e.getActionCommand());
                        if (tickers)
                        {
                            massFigureTic[number].setVisible(true);
                            tickers = false;
                        }
                        else
                        {
                            massFigureTac[number].setVisible(true);
                            tickers = true;
                        }
                        buttons[number].setVisible(false);
                    } catch (NumberFormatException f) {
                        System.out.println("Invalid integer input in actionListener in buttons");
                    }
                }
                });
                lp.add(buttons[i],JLayeredPane.DEFAULT_LAYER);
                }

            buttons[0].setBounds(1, 25, 100, 100);
            buttons[1].setBounds(1, 125, 100, 100);
            buttons[2].setBounds(1, 225, 100, 100);

            buttons[3].setBounds(100, 25, 100, 100);
            buttons[4].setBounds(100, 125, 100, 100);
            buttons[5].setBounds(100, 225, 100, 100);

            buttons[6].setBounds(200, 25, 100, 100);
            buttons[7].setBounds(200, 125, 100, 100);
            buttons[8].setBounds(200, 225, 100, 100);
            return buttons;
        }


    public JLayeredPaneTest()
    {
        // создание окна
        super("Example LayeredTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        massFigureTic = initFigure(massFigureTic, true);
        massFigureTac = initFigure(massFigureTac, false);

        massButtons = initButtons(massButtons);


        // Изменение выравнивания текста и изображения


        //Белый бэкграунд
        Figure foreground = new Figure(2);
        foreground.setBounds(0,25,500,500);
        lp.add(foreground, 2);

        setSize(310, 335);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new JLayeredPaneTest();
    }
}