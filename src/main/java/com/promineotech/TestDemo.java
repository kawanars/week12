package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
	
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("positive!");
        }
        return a + b;
	}public int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
	  public int randomNumberSquared() {
	        int randomInt = getRandomInt();
	        return randomInt * randomInt;
	    }

	    int getRandomInt() {
	        Random random = new Random();
	        return random.nextInt(10) + 1;
	    }
    

	
}