package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

// Simple program to sell my hand bags offline, hence the price is of integer type because it's easier for cash.
// It should print the receipt to a text file to print or email to them.

public class BagShop extends HandBagPurchase {


    public static void main(String[] args) throws IOException {

        final HandBagPurchase newBag = new HandBagPurchase();

        JPanel shopPanel = new JPanel(new GridLayout(2,0));

        JLabel mothLabel = new JLabel("** Choose Transaction Type **");
        mothLabel.setHorizontalAlignment(SwingConstants.CENTER);

        shopPanel.setBackground(Color.cyan);
        shopPanel.setSize(400, 850);

        final JFrame bagFrame = new JFrame("March of the Hare");
        bagFrame.pack();
        bagFrame.setVisible(true);
        bagFrame.setSize(400, 150);
        bagFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton smallBag = new JButton("Small Bag Purchase $35");
        JButton bigBag = new JButton("Big Bag Purchase $45");


        JPanel bPan = new JPanel();
        bPan.setBackground(Color.green);
        bPan.add(smallBag);
        bPan.add(bigBag);
        bagFrame.add(shopPanel);
        shopPanel.add(mothLabel);
        shopPanel.add(bPan);

        class SmallListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {
                    bagFrame.setVisible(false);
                    Customer newCust = new Customer();
                    newCust.newCustomer();
                    newBag.newSmallHandBagPurchase();

                String filename = "Receipt.txt";
                    try {
                        PrintWriter outputStream = new PrintWriter(filename);
                        outputStream.print(newCust.getCust());
                        outputStream.print(newBag.displayReceipt());
                        outputStream.close();

                     //newBag.displayReceipt();  // Left in case I want to use them later.
                     //newCust.getCust();
                    bagFrame.setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } }

        class BigListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                try {
                    bagFrame.setVisible(false);
                    Customer newCust = new Customer();
                    newCust.newCustomer();
                    newBag.newBigHandBagPurchase();

                    String filename = "Receipt.txt";
                    try {
                        PrintWriter outputStream = new PrintWriter(filename);
                        outputStream.print(newCust.getCust());
                        outputStream.print(newBag.displayReceipt());
                        outputStream.close();

                        //newBag.displayReceipt(); // Left in case I want to use them later.
                        //newCust.getCust();
                        bagFrame.setVisible(true);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } }

        smallBag.addActionListener(new SmallListener());
        bigBag.addActionListener(new BigListener());

    } }

