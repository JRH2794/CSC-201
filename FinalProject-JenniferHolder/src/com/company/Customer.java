package com.company;

import javax.swing.*;

public class Customer {

public String cFName,  cEmail; // cFName = Customer Full Name

    public void newCustomer () {

        String custName = JOptionPane.showInputDialog("Client's Full Name:");
                this.cFName = custName;
        String custEmail = JOptionPane.showInputDialog("Client's Email:");
                this.cEmail = custEmail;  }

    public String getCust () {
            return "Name: "+ cFName +"\nEmail: " + cEmail; }

}
