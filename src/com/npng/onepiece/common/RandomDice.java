package com.npng.onepiece.common;

public class RandomDice {

	public static int randomDice() {
		
		int result = 0;
		
		result = (int) (Math.random() * 50);
		
		return result;
	}
}
