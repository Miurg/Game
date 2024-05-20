import javax.swing.*;
import java.awt.*;




public class JLayeredPaneTest extends JFrame
{
    JButton[] massButtons = new JButton[9];
    int whichMove = 1;
    JLayeredPane lp = getLayeredPane();
    int[] Pane = new int[9];

    public void initFigure(int ifTic, int buttonNumber) {

        if (ifTic == 10) ifTic = 0;
        Figure figure = new Figure(ifTic);

        Figure figureRect = new Figure(2);
        figure.setBounds(massButtons[buttonNumber].getBounds().x, massButtons[buttonNumber].getBounds().y,
                massButtons[buttonNumber].getBounds().width, massButtons[buttonNumber].getBounds().height);
        figureRect.setBounds(massButtons[buttonNumber].getBounds().x, massButtons[buttonNumber].getBounds().y,
                massButtons[buttonNumber].getBounds().width, massButtons[buttonNumber].getBounds().height);
        lp.add(figure, JLayeredPane.POPUP_LAYER);
        lp.add(figureRect, JLayeredPane.POPUP_LAYER);
    }

    public JButton[] initButtons(JButton[] buttons)
        {
            for (int i = 0; i < buttons.length; i++) {
                buttons[i] = new JButton();
                buttons[i].setBorderPainted(false);
                buttons[i].setBackground(Color.white);
                buttons[i].setPreferredSize(new Dimension(100, 100));
                buttons[i].setActionCommand(Integer.toString(i));
                buttons[i].addActionListener(e -> {
                    try {
                        int numberButton = Integer.parseInt(e.getActionCommand());

                        if (whichMove == 1)
                        {
                            Pane[numberButton] = 1;
                            logicTicTacToe();
                            whichMove = 10;
                        }
                        else
                        {

                            Pane[numberButton] = 10;
                            logicTicTacToe();
                            whichMove = 1;
                        }
                        initFigure(whichMove, numberButton);
                        buttons[numberButton].setVisible(false);
                    } catch (NumberFormatException f) {
                        System.out.println("Invalid integer input in actionListener in buttons");
                    }
                });
                lp.add(buttons[i],JLayeredPane.DEFAULT_LAYER);
                }

            buttons[0].setBounds(1, 0, 100, 100);
            buttons[1].setBounds(1, 100, 100, 100);
            buttons[2].setBounds(1, 200, 100, 100);

            buttons[3].setBounds(100, 0, 100, 100);
            buttons[4].setBounds(100, 100, 100, 100);
            buttons[5].setBounds(100, 200, 100, 100);

            buttons[6].setBounds(200, 0, 100, 100);
            buttons[7].setBounds(200, 100, 100, 100);
            buttons[8].setBounds(200, 200, 100, 100);
            return buttons;
        }

    private void centerLocationWindow() throws HeadlessException {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - this.getWidth()) / 2;
        final int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }
    public JLayeredPaneTest()
    {
        // создание окна
        super("Example LayeredTest");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        massButtons = initButtons(massButtons);

        setSize(310, 335);
        setVisible(true);
        centerLocationWindow();
        setResizable(false);
    }

    private void logicTicTacToe() {
        //Can be a logic but TicTacToe pretty obvious in it, and this is just shorter
        if ((Pane[0] + Pane[1] + Pane[2]) == whichMove * 3
                || Pane[3]+Pane[4]+Pane[5] == whichMove * 3
                || Pane[6]+Pane[7]+Pane[8] == whichMove * 3
                || Pane[0]+Pane[4]+Pane[8] == whichMove * 3
                || Pane[2]+Pane[4]+Pane[6] == whichMove * 3
                || Pane[0]+Pane[3]+Pane[6] == whichMove * 3
                || Pane[1]+Pane[4]+Pane[7] == whichMove * 3
                || Pane[2]+Pane[5]+Pane[8] == whichMove * 3)
        {
            for (JButton massButton : massButtons) {
                massButton.setVisible(false);
            }
            System.out.println("Победитель " + whichMove);
        }
    }
    public static void main(String[] args)
    {
        new JLayeredPaneTest();
    }
}