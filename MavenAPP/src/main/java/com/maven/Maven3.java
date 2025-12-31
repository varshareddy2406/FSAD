package com.maven;

class Bank {
    int intrestrate() {
        return 0;
    }
}

class SBI extends Bank {
    @Override
    int intrestrate() {
        return 7;
    }
}

class HDFC extends Bank {
    @Override
    int intrestrate() {
        return 6;
    }
}

public class Maven3 {
    public static void main(String[] args) {

        Bank b;

        b = new SBI();
        System.out.println("SBI: " + b.intrestrate() + "%");

        b = new HDFC();
        System.out.println("HDFC: " + b.intrestrate() + "%");
    }
}

	


