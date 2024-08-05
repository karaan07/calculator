import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {

    JFrame Frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont=new Font("Ink Free",Font.BOLD,30);

    double num1=0;
    double num2=0;
    double result=0;

    char operator;



    calculator(){

        Frame=new JFrame("Calculator");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(420,550);
        Frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        divButton=new JButton("/");
        mulButton=new JButton("*");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("DELETE");
        clrButton=new JButton("CLEAR");
        negButton=new JButton("(-)");





        functionButtons[0]= addButton;
        functionButtons[1]= subButton;
        functionButtons[2]= divButton;
        functionButtons[3]= mulButton;
        functionButtons[4]= decButton;
        functionButtons[5]= equButton;
        functionButtons[6]= delButton;
        functionButtons[7]= clrButton;
        functionButtons[8]= negButton;


        for (int i = 0; i <=8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }

        for (int i = 0; i <=9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,145,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        Frame.add(panel);
        Frame.add(negButton);
        Frame.add(delButton);
        Frame.add(clrButton);
        Frame.add(textField);
        Frame.setVisible(true);

    }


    public static void main(String[] args) {
        calculator calc= new calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }}
            if (e.getSource()==decButton){
                textField.setText(textField.getText().concat("."));
            }
            if (e.getSource()==addButton){
               num1= Double.parseDouble(textField.getText());
               operator='+';
               textField.setText("");
            }
            if (e.getSource()==subButton){
                num1= Double.parseDouble(textField.getText());
                operator='-';
                textField.setText("");
            }
            if (e.getSource()==mulButton){
                num1= Double.parseDouble(textField.getText());
                operator='*';
                textField.setText("");
            }
            if (e.getSource()==divButton){
                num1= Double.parseDouble(textField.getText());
                operator='/';
                textField.setText("");
            }
            if (e.getSource()==equButton){
                num2=Double.parseDouble(textField.getText());

                switch(operator){
                    case'+':
                        result=num1+num2;
                        break;
                    case'-':
                        result=num1-num2;
                        break;
                    case'*':
                        result=num1*num2;
                        break;
                    case'/':
                        result=num1/num2;
                        break;
                }
                textField.setText(String.valueOf(result));
                num1=result;
            }
        if (e.getSource()==clrButton){
            textField.setText("");
        }
        if (e.getSource()==delButton){
            String string =textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+ string.charAt(i));
            }

            }
        if(e.getSource()==negButton){
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));

        }


        }

    }

