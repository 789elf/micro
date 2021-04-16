package myobj;

import myobj.item.*;

public class Peach{
	
	int size;
	int calorie;
	long lifetime;
	double sweet;
	String color;


	void eat() {
		size--;
		calorie -=10;
	}
	public static void main(String[] args) {
		Candy candy = new Candy("È¦½º", 1500);
		Inventory inven = new Inventory(5);
	}
}
