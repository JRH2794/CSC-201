package com.company;

import javax.swing.*;
import java.io.IOException;

public class HandBagPurchase extends InventoryItem {

    public void newSmallHandBagPurchase() throws IOException {
        this.cost = 35;

        int quant = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
        quantity = quant;
        String col = JOptionPane.showInputDialog("Enter color(s):");
        color = col; }

    public void newBigHandBagPurchase() throws IOException {
        this.cost = 45;

        int quant = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
                quantity = quant;
        String col = JOptionPane.showInputDialog("Enter color(s):");
                        color = col; }

}
