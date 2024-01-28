import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class calculator implements ActionListener {

    JFrame fr;
    JTextField tf;
    JButton[] numberb=new JButton[10];
    JButton[] oper=new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel pl;
    Font myfont=new Font("Times New Roman",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;
    calculator(){
        fr=new JFrame("Calculator");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500,700);
        fr.setLayout(null);

        tf=new JTextField();
        tf.setBounds(50,25,380,50);
        tf.setFont(myfont);
        tf.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("DEL");
        clrButton=new JButton("CLR");
        negButton=new JButton("(-)");

        oper[0]=addButton;
        oper[1]=subButton;
        oper[2]=mulButton;
        oper[3]=divButton;
        oper[4]=decButton;
        oper[5]=equButton;
        oper[6]=delButton;
        oper[7]=clrButton;
        oper[8]=negButton;

        for (int i=0; i<9;i++){
            oper[i].addActionListener(this);
            oper[i].setFont(myfont);
            oper[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            numberb[i]=new JButton(String.valueOf(i));
            numberb[i].addActionListener(this);
            numberb[i].setFont(myfont);
            numberb[i].setFocusable(false);
        }
        negButton.setBounds(50,580,70,50);
        delButton.setBounds(130,580,145,50);
        clrButton.setBounds(285,580,145,50);

        pl=new JPanel();
        pl.setBounds(50,100,380,450);
        pl.setLayout(new GridLayout(4,4,10,10));

        pl.add(numberb[1]);
        pl.add(numberb[2]);
        pl.add(numberb[3]);
        pl.add(addButton);
        pl.add(numberb[4]);
        pl.add(numberb[5]);
        pl.add(numberb[6]);
        pl.add(subButton);
        pl.add(numberb[7]);
        pl.add(numberb[8]);
        pl.add(numberb[9]);
        pl.add(mulButton);
        pl.add(decButton);
        pl.add(numberb[0]);
        pl.add(equButton);
        pl.add(divButton);

        fr.add(pl);
        fr.add(delButton);
        fr.add(clrButton);
        fr.add(negButton);
        fr.add(tf);
        fr.setVisible(true);


    }
    public static void main(String[] args) {
        calculator c1=new calculator();
    }

    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10; i++){
            if (e.getSource()==numberb[i]){
                tf.setText(tf.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            tf.setText(tf.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1=Double.parseDouble(tf.getText());
            operator='+';
            tf.setText("");
        }
        if(e.getSource()==subButton){
            num1=Double.parseDouble(tf.getText());
            operator='-';
            tf.setText("");
        }
        if(e.getSource()==mulButton){
            num1=Double.parseDouble(tf.getText());
            operator='*';
            tf.setText("");
        }
        if(e.getSource()==divButton){
            num1=Double.parseDouble(tf.getText());
            operator='/';
            tf.setText("");
        }
        if(e.getSource()==equButton){
            num2=Double.parseDouble(tf.getText());

            switch(operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            tf.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton) {
            num1 = Double.parseDouble(tf.getText());
            tf.setText("");
        }
        if(e.getSource()==delButton) {
        String string=tf.getText();
        tf.setText("");
        for(int i=0; i<string.length()-1;i++){
            tf.setText(tf.getText()+string.charAt(i));
        }

        }
        if(e.getSource()==negButton) {
            double tempo = Double.parseDouble(tf.getText());
            tempo*=-1;
            tf.setText(String.valueOf(tempo));
        }
    }
}
