/**
 * PROGRAM DESCRIPTION: TO CREATE A CUSTOMER INFO PAGE FOR BLOSSOM BEAUTE ONLINE BOOKING SYSTEM
 * PROGRAMMER: NUR FARHANA
 * DATE: 13/4/2024
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class CustomerInfo extends JFrame 
{
    private JFrame custInfoFrame;
    private JTextField custNameText, custPhoneNoText;

    public CustomerInfo(String haircut, boolean washHair, String facial, boolean doManicure, boolean doPedicure, String day, String month, String timeDesc, String promoCodeText, double totalPrice, boolean payNow, double finalPrice)
    {
        //Create the frame for customer info
        custInfoFrame = new JFrame();
        //Set title for the frame "Blossom-Beautê Booking System"
        custInfoFrame.setTitle("Blossom-Beautê Booking System");
        //Set customer info frame size
        custInfoFrame.setSize(500, 200);
        //Exit/ terminate the application when JFrame is close
        custInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the JFrame to appear at the center of the screen 
        custInfoFrame.setLocationRelativeTo(null);
        //Create a panel for customer info
        JPanel panelCustInfo = new JPanel();
        //Create a label " Name: "
        JLabel custNameLabel = new JLabel("Name: ");
        //Create a text field for name
        JTextField custNameText = new JTextField(15);
        //Add name label and name text into the customer info 
        panelCustInfo.add(custNameLabel);
        panelCustInfo.add(custNameText);
        JLabel custPhoneNoLabel = new JLabel("Phone Number: ");
        JTextField custPhoneNoText = new JTextField(15);
        panelCustInfo.add(custPhoneNoLabel);
        panelCustInfo.add(custPhoneNoText);
        //Set border tittle to "Customer Information" 
        panelCustInfo.setBorder(BorderFactory.createTitledBorder("Customer Information"));
        //Set the position for customer info panel
        panelCustInfo.setBounds(0, 20, 680, 60); 
        //Create new button "Next" to redirect to the next frame
        JButton doneButton = new JButton("Next");
        //Add listener to the button to call for action
        doneButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {        
                    // Check if name and phone number is empty, ask user to fill up the information
                    if(custNameLabel.getText().isEmpty() || custPhoneNoText.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please fill in your name and phone number", "Customer Information Missing!", JOptionPane.ERROR_MESSAGE);                            
                    }else{
                        custInfoFrame.dispose();
                        new Receipt(haircut, washHair, facial, doManicure, doPedicure, day, month, timeDesc, promoCodeText, totalPrice, payNow, finalPrice, custNameText.getText(), custPhoneNoText.getText());
                    }
                }
            });
            
        //Add the booking button to the panel
        custInfoFrame.add(doneButton, BorderLayout.SOUTH);
        //Add customer info into the panel
        custInfoFrame.add(panelCustInfo); 
        //Show frame on the screen
        custInfoFrame.setVisible(true);  

    }
}