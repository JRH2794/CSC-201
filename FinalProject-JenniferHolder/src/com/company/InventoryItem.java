package com.company;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InventoryItem extends Customer implements Receipt {

    int cost;
    double TOTAL = 0;
    String color;
    int quantity;

    // No shipping fee, the purpose of this app is for person-to-person sales.
    // Since I'm selling goods in VA I have to collect state tax,
    // despite not having an official company buiding or any employees besides myself, said Google.

    // FROM RECEIPT INTERFACE:

    public String calculateTotal() {
        DecimalFormat df = new DecimalFormat("##.##");
        double tax = .06; // Northern Virginia sales tax rate.
        double taxCharged;
        int SUBTOTAL;
        SUBTOTAL = this.cost*quantity;
        taxCharged = SUBTOTAL * tax;
        TOTAL = (SUBTOTAL) + (taxCharged) ;
                return "Subtotal: $" + SUBTOTAL +
                        "\nTax: " + (df.format(taxCharged)); } // 2 Decimal Places

    public String displayReceipt() throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy @ HH:mm:ss");
        Date date = new Date();
        this.calculateTotal();
        return ("\n***********************\n-------- March --------\n----- of the Hare -----\n"
                + dateFormat.format(date) + "\n-----------------------\n" + quantity + " Bag(s) @ " + cost + " Each" +
                "\nColor(s): " + color + "\n-----------------------\n"  + this.calculateTotal() + "\nTotal: $" + TOTAL + "\n***********************");

    } }

