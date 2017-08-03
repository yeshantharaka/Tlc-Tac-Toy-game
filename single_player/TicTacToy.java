import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class TicTacToy extends JFrame {
    private final int SIZE = 3;
    Random r = new Random();
    private JPanel panel, panel1;
    private JLabel label, label1, label2;
    private JButton[][] buttons;
    private JButton rbutton;
    private int index = 1;
    private GridLayout Layout, layout2;
    private long counter;


    public TicTacToy() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);

//creating a new grid layout
        Layout = new GridLayout(SIZE + 1, SIZE);
        layout2 = new GridLayout(1, 1);

//creating a pannel
        panel = new JPanel();
        panel.setLayout(Layout);
//adding buttons
        buttons = new JButton[SIZE][SIZE];
        addButtons();

//adding buttons
        label1 = new JLabel("");
        label1.setAlignmentX(label1.CENTER);
        panel.add(label1, 9);

        rbutton = new JButton("RESTART");
        rbutton.setPreferredSize(new Dimension(20, 20));
        panel.add(rbutton, 10);

        add(panel);
// restart game...
        rbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TicTacToy();

            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToy();


    }

    public void winner() {
        if ((buttons[0][0].getText().equals("X") && buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals("X")) ||
                (buttons[1][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X")) ||
                (buttons[2][0].getText().equals("X") && buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals("X")) ||
                (buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X")) ||
                (buttons[2][1].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[0][1].getText().equals("X")) ||
                (buttons[2][2].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[0][2].getText().equals("X")) ||
                (buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals("X")) ||
                (buttons[2][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[0][2].getText().equals("X"))) {
            XWin();
        } else if ((buttons[0][0].getText().equals("O") && buttons[0][1].getText().equals("O") && buttons[0][2].getText().equals("O")) ||
                (buttons[1][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[1][2].getText().equals("O")) ||
                (buttons[2][0].getText().equals("O") && buttons[2][1].getText().equals("O") && buttons[2][2].getText().equals("O")) ||
                (buttons[0][0].getText().equals("O") && buttons[1][0].getText().equals("O") && buttons[2][0].getText().equals("O")) ||
                (buttons[2][1].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[0][1].getText().equals("O")) ||
                (buttons[2][2].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[0][2].getText().equals("O")) ||
                (buttons[0][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][2].getText().equals("O")) ||
                (buttons[2][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[0][2].getText().equals("O"))) {
            OWin();
        } else if (index >= 10) {
            Drawn();
        }
    }

    public void XWin() {

        JOptionPane.showMessageDialog(this, "X IS WON ");
        rbutton.doClick();
    }

    public void OWin() {
        JOptionPane.showMessageDialog(this, "O IS WON");
        rbutton.doClick();
    }

    public void Drawn() {
        JOptionPane.showMessageDialog(this, "MATCH IS DRAWN");
        rbutton.doClick();
    }

    public void addButtons() {
        for (int k = 0; k < SIZE; k++)
            for (int j = 0; j < SIZE; j++) {
                buttons[k][j] = new JButton();
                buttons[k][j].setActionCommand(k + "," + j);
                buttons[k][j].addActionListener(new ButtonClickedAction());

                panel.add(buttons[k][j], k, j);
            }

    }

    public void AutoPlay() {
        //if ((buttons[0][0].getText().equals("O") && buttons[0][1].getText().equals("O")) || (buttons[0][0].getText().equals("O") && buttons[0][2].getText().equals("O")) || (buttons[0][2].getText().equals("O") && buttons[0][1].getText().equals("O")) || (buttons[1][0].getText().equals("O") && buttons[1][1].getText().equals("O")) || (buttons[1][0].getText().equals("O") && buttons[1][2].getText().equals("O")) || (buttons[1][2].getText().equals("O") && buttons[1][1].getText().equals("O")) || (buttons[2][0].getText().equals("O") && buttons[2][1].getText().equals("O")) || (buttons[2][0].getText().equals("O") && buttons[2][2].getText().equals("O")) || (buttons[2][2].getText().equals("O") && buttons[2][1].getText().equals("O")) || (buttons[0][0].getText().equals("O") && buttons[1][0].getText().equals("O")) || (buttons[0][0].getText().equals("O") && buttons[2][0].getText().equals("O")) || (buttons[1][0].getText().equals("O") && buttons[2][0].getText().equals("O")) || (buttons[0][1].getText().equals("O") && buttons[1][1].getText().equals("O")) || (buttons[2][1].getText().equals("O") && buttons[0][1].getText().equals("O")) || (buttons[2][1].getText().equals("O") && buttons[1][1].getText().equals("O")) || (buttons[1][2].getText().equals("O") && buttons[0][2].getText().equals("O")) || (buttons[0][2].getText().equals("O") && buttons[2][2].getText().equals("O")) || (buttons[2][2].getText().equals("O") && buttons[1][2].getText().equals("O")) || (buttons[0][0].getText().equals("O") && buttons[1][1].getText().equals("O")) || (buttons[0][0].getText().equals("O") && buttons[2][2].getText().equals("O")) || (buttons[2][2].getText().equals("O") && buttons[1][1].getText().equals("O")) || (buttons[0][2].getText().equals("O") && buttons[1][1].getText().equals("O")) || (buttons[2][0].getText().equals("O") && buttons[0][2].getText().equals("O")) || (buttons[2][0].getText().equals("O") && buttons[1][1].getText().equals("O"))){
        if ((buttons[0][0].getText().equals("O") && buttons[0][1].getText().equals("O") && buttons[0][2].getText().equals(""))) {
            buttons[0][2].setText("O");
            buttons[0][2].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("O") && buttons[0][2].getText().equals("O") && buttons[0][1].getText().equals(""))) {
            buttons[0][1].setText("O");
            buttons[0][1].setEnabled(false);
            return;
        } else if ((buttons[0][1].getText().equals("O") && buttons[0][2].getText().equals("O") && buttons[0][0].getText().equals(""))) {
            buttons[0][0].setText("O");
            buttons[0][0].setEnabled(false);
            return;
        } else if ((buttons[1][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[1][2].getText().equals(""))) {
            buttons[1][2].setText("O");
            buttons[1][2].setEnabled(false);
            return;
        } else if ((buttons[1][0].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[1][1].getText().equals(""))) {
            buttons[1][1].setText("O");
            buttons[1][1].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[1][0].getText().equals(""))) {
            buttons[1][0].setText("O");
            buttons[1][0].setEnabled(false);
            return;
        } else if ((buttons[2][0].getText().equals("O") && buttons[2][1].getText().equals("O") && buttons[2][2].getText().equals(""))) {
            buttons[2][2].setText("O");
            buttons[2][2].setEnabled(false);
            return;
        } else if ((buttons[2][1].getText().equals("O") && buttons[2][2].getText().equals("O") && buttons[2][0].getText().equals(""))) {
            buttons[2][0].setText("O");
            buttons[2][0].setEnabled(false);
            return;
        } else if ((buttons[2][0].getText().equals("O") && buttons[2][2].getText().equals("O") && buttons[2][1].getText().equals(""))) {
            buttons[2][1].setText("O");
            buttons[2][1].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("O") && buttons[1][0].getText().equals("O") && buttons[2][0].getText().equals(""))) {
            buttons[2][0].setText("O");
            buttons[2][0].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("O") && buttons[2][0].getText().equals("O") && buttons[1][0].getText().equals(""))) {
            buttons[1][0].setText("O");
            buttons[1][0].setEnabled(false);
            return;
        } else if ((buttons[1][0].getText().equals("O") && buttons[2][0].getText().equals("O") && buttons[0][0].getText().equals(""))) {
            buttons[0][0].setText("O");
            buttons[0][0].setEnabled(false);
            return;
        } else if ((buttons[0][1].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][1].getText().equals(""))) {
            buttons[2][1].setText("O");
            buttons[2][1].setEnabled(false);
            return;
        } else if ((buttons[0][1].getText().equals("O") && buttons[2][1].getText().equals("O") && buttons[1][1].getText().equals(""))) {
            buttons[1][1].setText("O");
            buttons[1][1].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("O") && buttons[2][1].getText().equals("O") && buttons[0][1].getText().equals(""))) {
            buttons[0][1].setText("O");
            buttons[0][1].setEnabled(false);
            return;
        } else if ((buttons[0][2].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[2][2].getText().equals(""))) {
            buttons[2][2].setText("O");
            buttons[2][2].setEnabled(false);
            return;
        } else if ((buttons[2][2].getText().equals("O") && buttons[0][2].getText().equals("O") && buttons[1][2].getText().equals(""))) {
            buttons[1][2].setText("O");
            buttons[1][2].setEnabled(false);
            return;
        } else if ((buttons[1][2].getText().equals("O") && buttons[2][2].getText().equals("O") && buttons[0][2].getText().equals(""))) {
            buttons[0][2].setText("O");
            buttons[0][2].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][2].getText().equals(""))) {
            buttons[2][2].setText("O");
            buttons[2][2].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("O") && buttons[2][2].getText().equals("O") && buttons[1][1].getText().equals(""))) {
            buttons[1][1].setText("O");
            buttons[1][1].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("O") && buttons[2][2].getText().equals("O") && buttons[0][0].getText().equals(""))) {
            buttons[0][0].setText("O");
            buttons[0][0].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("O") && buttons[0][2].getText().equals("O") && buttons[2][0].getText().equals(""))) {
            buttons[2][0].setText("O");
            buttons[2][0].setEnabled(false);
            return;
        } else if ((buttons[2][0].getText().equals("O") && buttons[0][2].getText().equals("O") && buttons[1][1].getText().equals(""))) {
            buttons[1][1].setText("O");
            buttons[1][1].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("O") && buttons[2][0].getText().equals("O") && buttons[0][2].getText().equals(""))) {
            buttons[0][2].setText("O");
            buttons[0][2].setEnabled(false);
            return;
        }

        //  } else  if ((buttons[0][0].getText().equals("X") && buttons[0][1].getText().equals("X")) || (buttons[0][0].getText().equals("X") && buttons[0][2].getText().equals("X")) || (buttons[0][2].getText().equals("X") && buttons[0][1].getText().equals("X")) || (buttons[1][0].getText().equals("X") && buttons[1][1].getText().equals("X")) || (buttons[1][0].getText().equals("X") && buttons[1][2].getText().equals("X")) || (buttons[1][2].getText().equals("X") && buttons[1][1].getText().equals("X")) || (buttons[2][0].getText().equals("X") && buttons[2][1].getText().equals("X")) || (buttons[2][0].getText().equals("X") && buttons[2][2].getText().equals("X")) || (buttons[2][2].getText().equals("x") && buttons[2][1].getText().equals("X")) || (buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X")) || (buttons[0][0].getText().equals("X") && buttons[2][0].getText().equals("X")) || (buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X")) || (buttons[0][1].getText().equals("X") && buttons[1][1].getText().equals("X")) || (buttons[2][1].getText().equals("X") && buttons[0][1].getText().equals("X")) || (buttons[2][1].getText().equals("X") && buttons[1][1].getText().equals("X")) || (buttons[1][2].getText().equals("X") && buttons[0][2].getText().equals("X")) || (buttons[0][2].getText().equals("X") && buttons[2][2].getText().equals("X")) || (buttons[2][2].getText().equals("X") && buttons[1][2].getText().equals("X")) || (buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X")) || (buttons[0][0].getText().equals("X") && buttons[2][2].getText().equals("X")) || (buttons[2][2].getText().equals("X") && buttons[1][1].getText().equals("X")) || (buttons[0][2].getText().equals("X") && buttons[1][1].getText().equals("X")) || (buttons[2][0].getText().equals("X") && buttons[0][2].getText().equals("X")) || (buttons[2][0].getText().equals("X") && buttons[1][1].getText().equals("X"))) {
        if ((buttons[0][0].getText().equals("X") && buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals(""))) {
            buttons[0][2].setText("O");
            buttons[2][2].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("X") && buttons[0][2].getText().equals("X") && buttons[0][1].getText().equals(""))) {
            buttons[0][1].setText("O");
            buttons[0][1].setEnabled(false);
            return;
        } else if ((buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals("X") && buttons[0][0].getText().equals(""))) {
            buttons[0][0].setText("O");
            buttons[0][0].setEnabled(false);
            return;
        } else if ((buttons[1][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals(""))) {
            buttons[1][2].setText("O");
            buttons[1][2].setEnabled(false);
            return;
        } else if ((buttons[1][0].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[1][1].getText().equals(""))) {
            buttons[1][1].setText("O");
            buttons[1][1].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[1][0].getText().equals(""))) {
            buttons[1][0].setText("O");
            buttons[1][0].setEnabled(false);
            return;
        } else if ((buttons[2][0].getText().equals("X") && buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals(""))) {
            buttons[2][2].setText("O");
            buttons[2][2].setEnabled(false);
            return;
        } else if ((buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals("X") && buttons[2][0].getText().equals(""))) {
            buttons[2][0].setText("O");
            buttons[2][0].setEnabled(false);
            return;
        } else if ((buttons[2][0].getText().equals("X") && buttons[2][2].getText().equals("X") && buttons[2][1].getText().equals(""))) {
            buttons[2][1].setText("O");
            buttons[2][1].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals(""))) {
            buttons[2][0].setText("O");
            buttons[2][0].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("X") && buttons[2][0].getText().equals("X") && buttons[1][0].getText().equals(""))) {
            buttons[1][0].setText("O");
            buttons[1][0].setEnabled(false);
            return;
        } else if ((buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X") && buttons[0][0].getText().equals(""))) {
            buttons[0][0].setText("O");
            buttons[0][0].setEnabled(false);
            return;
        } else if ((buttons[0][1].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][1].getText().equals(""))) {
            buttons[2][1].setText("O");
            buttons[2][1].setEnabled(false);
            return;
        } else if ((buttons[0][1].getText().equals("X") && buttons[2][1].getText().equals("X") && buttons[1][1].getText().equals(""))) {
            buttons[1][1].setText("O");
            buttons[1][1].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("X") && buttons[2][1].getText().equals("X") && buttons[0][1].getText().equals(""))) {
            buttons[0][1].setText("O");
            buttons[0][1].setEnabled(false);
            return;
        } else if ((buttons[0][2].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[2][2].getText().equals(""))) {
            buttons[2][2].setText("O");
            buttons[2][2].setEnabled(false);
            return;
        } else if ((buttons[2][2].getText().equals("X") && buttons[0][2].getText().equals("X") && buttons[1][2].getText().equals(""))) {
            buttons[1][2].setText("O");
            buttons[1][2].setEnabled(false);
            return;
        } else if ((buttons[1][2].getText().equals("X") && buttons[2][2].getText().equals("X") && buttons[0][2].getText().equals(""))) {
            buttons[0][2].setText("O");
            buttons[0][2].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals(""))) {
            buttons[2][2].setText("O");
            buttons[2][2].setEnabled(false);
            return;
        } else if ((buttons[0][0].getText().equals("X") && buttons[2][2].getText().equals("X") && buttons[1][1].getText().equals(""))) {
            buttons[1][1].setText("O");
            buttons[1][1].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals("X") && buttons[0][0].getText().equals(""))) {
            buttons[0][0].setText("O");
            buttons[0][0].setEnabled(false);
            return;
        } else if ((buttons[1][1].getText().equals("X") && buttons[0][2].getText().equals("X") && buttons[2][0].getText().equals(""))) {
            buttons[2][0].setText("O");
            buttons[2][0].setEnabled(false);
            return;
        } else if ((buttons[2][0].getText().equals("X") && buttons[0][2].getText().equals("X") && buttons[1][1].getText().equals(""))) {
            buttons[1][1].setText("O");
            buttons[1][1].setEnabled(false);
            return;

        } else if ((buttons[1][1].getText().equals("X") && buttons[2][0].getText().equals("X") && buttons[0][2].getText().equals(""))) {
            buttons[0][2].setText("O");
            buttons[0][2].setEnabled(false);
            return;
        }
//            return;
//        } else {
        if (index <= 5) {
            int i = r.nextInt(3);
            int j = r.nextInt(3);
            while (!buttons[i][j].getText().equals("")) {

                i = r.nextInt(3);
                j = r.nextInt(3);
            }
            buttons[i][j].setText("O");
            buttons[i][j].setEnabled(false);

        }
        return;

    }

    class ButtonClickedAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] split = e.getActionCommand().split(",");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);

            if ((index % 2) == 1) {
                buttons[i][j].setText("X");
                buttons[i][j].setEnabled(false);
                index++;
                AutoPlay();

                index++;
            } else if ((index % 2) == 0) {
                // AutoPlay();
                // index++;
            }
            winner();

        }
    }
}