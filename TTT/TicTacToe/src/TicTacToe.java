import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Random.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{

    Random random=new Random();
    JFrame fr=new JFrame();
    JPanel title_P=new JPanel();
    JPanel button_P=new JPanel();
    JLabel textfield=new JLabel();
    JButton[] Buttons=new JButton[9];
    boolean player1_turn;
    TicTacToe(){
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(800,800);
        fr.getContentPane().setBackground(new Color(50,50,50));
        fr.setLayout(new BorderLayout());
        fr.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Consolas",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_P.setLayout(new BorderLayout());
        title_P.setBounds(0,0,800,100);

        button_P.setLayout(new GridLayout(3,3));
        button_P.setBackground(new Color(255,255,255));

        for(int i=0; i<9; i++){
            Buttons[i]=new JButton();
            button_P.add(Buttons[i]);
            Buttons[i].setFont(new Font("DejaVu Sans Mono",Font.BOLD,120));
            Buttons[i].setFocusable(false);
            Buttons[i].addActionListener(this);
        }

        title_P.add(textfield);
        fr.add(title_P,BorderLayout.NORTH);
        fr.add(button_P);

        first_turn();


    }

    public void actionPerformed(ActionEvent e){

        for(int i=0 ; i<9 ; i++){
            if(e.getSource()==Buttons[i]){
                if(player1_turn){
                    if(Buttons[i].getText()==""){
                        Buttons[i].setForeground(new Color(255,0,0));
                        Buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O Turn");
                        check();
                    }
                }else{
                    if(Buttons[i].getText()==""){
                        Buttons[i].setForeground(new Color(0,255,0));
                        Buttons[i].setText("0");
                        player1_turn=true;
                        textfield.setText("X Turn");
                        check();
                    }

                }
            }
        }
    }

    public void first_turn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X Turn");
        }else{
            player1_turn=false;
            textfield.setText("O Turn");
        }
    }

    public void check(){
        if (    (Buttons[0].getText()=="X")&&
                (Buttons[1].getText()=="X")&&
                (Buttons[2].getText()=="X")){
            Xwins(0,1,2);
        }
        if (    (Buttons[3].getText()=="X")&&
                (Buttons[4].getText()=="X")&&
                (Buttons[5].getText()=="X")){
            Xwins(3,4,5);
        }
        if (    (Buttons[6].getText()=="X")&&
                (Buttons[7].getText()=="X")&&
                (Buttons[8].getText()=="X")){
            Xwins(6,7,8);
        }
        if (    (Buttons[0].getText()=="X")&&
                (Buttons[3].getText()=="X")&&
                (Buttons[6].getText()=="X")){
            Xwins(0,3,6);
        }
        if (    (Buttons[1].getText()=="X")&&
                (Buttons[4].getText()=="X")&&
                (Buttons[7].getText()=="X")){
            Xwins(1,4,7);
        }
        if (    (Buttons[2].getText()=="X")&&
                (Buttons[5].getText()=="X")&&
                (Buttons[8].getText()=="X")){
            Xwins(2,5,8);
        }
        if (    (Buttons[0].getText()=="X")&&
                (Buttons[4].getText()=="X")&&
                (Buttons[8].getText()=="X")){
            Xwins(0,4,8);
        }
        if (    (Buttons[2].getText()=="X")&&
                (Buttons[4].getText()=="X")&&
                (Buttons[6].getText()=="X")){
            Xwins(2,4,6);
        }
        if (    (Buttons[0].getText()=="O")&&
                (Buttons[1].getText()=="O")&&
                (Buttons[2].getText()=="O")){
            Owins(0,1,2);
        }
        if (    (Buttons[3].getText()=="O")&&
                (Buttons[4].getText()=="O")&&
                (Buttons[5].getText()=="O")){
            Owins(3,4,5);
        }
        if (    (Buttons[6].getText()=="O")&&
                (Buttons[7].getText()=="O")&&
                (Buttons[8].getText()=="O")){
            Owins(6,7,8);
        }
        if (    (Buttons[0].getText()=="O")&&
                (Buttons[3].getText()=="O")&&
                (Buttons[6].getText()=="O")){
            Owins(0,3,6);
        }
        if (    (Buttons[1].getText()=="O")&&
                (Buttons[4].getText()=="O")&&
                (Buttons[7].getText()=="O")){
            Owins(1,4,7);
        }
        if (    (Buttons[2].getText()=="O")&&
                (Buttons[5].getText()=="O")&&
                (Buttons[8].getText()=="O")){
            Owins(2,5,8);
        }
        if (    (Buttons[0].getText()=="O")&&
                (Buttons[4].getText()=="O")&&
                (Buttons[8].getText()=="O")){
            Owins(0,4,8);
        }
        if (    (Buttons[2].getText()=="O")&&
                (Buttons[4].getText()=="O")&&
                (Buttons[6].getText()=="O")){
            Owins(2,4,6);
        }
    }

    public void Xwins(int a, int b , int c){
        Buttons[a].setBackground(Color.green);
        Buttons[b].setBackground(Color.green);
        Buttons[c].setBackground(Color.green);

        for(int i=0; i<9; i++){
            Buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }
    public void Owins(int a, int b , int c){
        Buttons[a].setBackground(Color.green);
        Buttons[b].setBackground(Color.green);
        Buttons[c].setBackground(Color.green);

        for(int i=0; i<9; i++){
            Buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
    }
}
