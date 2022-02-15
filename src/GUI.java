/*
William Marcus
February 15th 2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI {
    public static void main(String[] args) {
        JFrame win = new JFrame("Currency Converter");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setBounds(600,300,350,450);
        win.getContentPane().setBackground(Color.black);
        win.setLayout(null);

        JTextField Box1 = new JTextField("Enter currency amount");
        Box1.setBounds(25, 100, 100, 20);
        Box1.setBackground(Color.GREEN);
        win.add(Box1);

        JTextField Box2 = new JTextField();
        Box2.setBounds(225, 100, 100, 20);
        Box2.setBackground(Color.GREEN);
        Box2.setEditable(false);
        win.add(Box2);

        JTextField Box3 = new JTextField("Exchange rate");
        Box3.setBounds(125, 200, 100, 20);
        Box3.setBackground(Color.GREEN);
        win.add(Box3);

        JLabel Text = new JLabel("$1 USD =");
        Text.setBounds(55,200,100,20);
        Text.setForeground(Color.GREEN);
        win.add(Text);

        JLabel Text2 = new JLabel("CAD");
        Text2.setBounds(225,200,100,20);
        Text2.setForeground(Color.GREEN);
        win.add(Text2);

        JLabel CADorUSDText = new JLabel();
        CADorUSDText.setBounds(55,70,100,20);
        CADorUSDText.setForeground(Color.GREEN);
        win.add(CADorUSDText);

        JLabel CADorUSDText2 = new JLabel();
        CADorUSDText2.setBounds(255,70,100,20);
        CADorUSDText2.setForeground(Color.GREEN);
        win.add(CADorUSDText2);

        JLabel Equalstext = new JLabel("=");
        Equalstext.setBounds(170,70,100,20);
        Equalstext.setForeground(Color.GREEN);
        win.add(Equalstext);

        JComboBox WhichUnit = new JComboBox();
        WhichUnit.setBounds(75,300,200,100);
        WhichUnit.addItem("CAD to USD");
        WhichUnit.addItem("USD to CAD");

        JButton convert = new JButton("Convert");
        convert.setBounds(135,100,80,20);
        convert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
               String Amount = Box1.getText();
               double NumAmount = Double.parseDouble(Amount);
                   CADtoUSD CTU = new CADtoUSD(Double.parseDouble(Box3.getText()), NumAmount);
                   USDtoCAD UTC = new USDtoCAD(Double.parseDouble(Box3.getText()), NumAmount);

                   if (WhichSelection(WhichUnit)) {
                       CADorUSDText.setText("CAD");
                       CADorUSDText2.setText("USD");
                       Box2.setText(Double.toString(CTU.Convert()));
                   } else {
                       CADorUSDText.setText("USD");
                       CADorUSDText2.setText("CAD");
                       Box2.setText(Double.toString(UTC.Convert()));
                   }
               } catch(Exception ex){
                   JOptionPane.showMessageDialog(null, "Please enter valid input");
               }
            }
        });
        win.add(convert);
        win.add(WhichUnit);
        win.setVisible(true);
    }
    public static boolean WhichSelection(JComboBox WhichUnit){
        if (WhichUnit.getSelectedItem().equals("CAD to USD")){
            return true;
        }
        return false;
    }
}
