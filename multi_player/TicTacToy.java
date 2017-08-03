import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;


public class TicTacToy extends JFrame {
    private final int SIZE = 3;
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
        if ((buttons[0][0].getText().equals("X") && buttons[0][1].getText().equals("X") && buttons[0][2].getText().equals("X")) || (buttons[1][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[1][2].getText().equals("X")) || (buttons[2][0].getText().equals("X") && buttons[2][1].getText().equals("X") && buttons[2][2].getText().equals("X")) || (buttons[0][0].getText().equals("X") && buttons[1][0].getText().equals("X") && buttons[2][0].getText().equals("X")) || (buttons[2][1].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[0][1].getText().equals("X")) || (buttons[2][2].getText().equals("X") && buttons[1][2].getText().equals("X") && buttons[0][2].getText().equals("X")) || (buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals("X")) || (buttons[2][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[0][2].getText().equals("X"))) {
            XWin();
        } else if ((buttons[0][0].getText().equals("O") && buttons[0][1].getText().equals("O") && buttons[0][2].getText().equals("O")) || (buttons[1][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[1][2].getText().equals("O")) || (buttons[2][0].getText().equals("O") && buttons[2][1].getText().equals("O") && buttons[2][2].getText().equals("O")) || (buttons[0][0].getText().equals("O") && buttons[1][0].getText().equals("O") && buttons[2][0].getText().equals("O")) || (buttons[2][1].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[0][1].getText().equals("O")) || (buttons[2][2].getText().equals("O") && buttons[1][2].getText().equals("O") && buttons[0][2].getText().equals("O")) || (buttons[0][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][2].getText().equals("O")) || (buttons[2][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[0][2].getText().equals("O"))) {
            OWin();
        } else if(index == 10) {
            Drawn();
        }
    }

    public void XWin() {

        JOptionPane.showMessageDialog(this, "X IS WON ");
    }

    public void OWin() {
        JOptionPane.showMessageDialog(this, "O IS WON");

    }

    public void Drawn() {
       JOptionPane.showMessageDialog(this, "MATCH IS DRAWN");
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

    class ButtonClickedAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] split = e.getActionCommand().split(",");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);

            if ((index%2) == 1){
                buttons[i][j].setText("X");
                buttons[i][j].setEnabled(false);
                index++;
            } else if ((index%2) == 0){

                buttons[i][j].setText("O");
                buttons[i][j].setEnabled(false);
                index++;
            }
            winner();

        }
    }

}