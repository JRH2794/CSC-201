package com.company;
import java.util.Scanner;

public class HelloName {

   public static void main(String[] args) {

       String name;

       System.out.println("Please tell me your username:");
       Scanner keyboard = new Scanner(System.in);
       name = keyboard.next();
       System.out.println("Please tell me your password:");
       System.out.println("Hello " + name + ", Welcome to CSC200 class! and Your password is " + keyboard.next() + "!");

   System.exit(0); } }