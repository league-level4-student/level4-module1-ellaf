package _03_Switch_Statement_Practice;

import java.util.Random;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
		switch(choice) { 
		case "Sunday":
			System.out.println("ADAM!");
			break;
		case "Monday":
			System.out.println("Road work ahead? Uh, yeah, I sure HOPE it does.");
			break;
		case "Tuesday":
			System.out.println("WelcOmE to mY KiTchEn... we've got bananies, and avocadies");
			break;
		case "Wednesday":
			System.out.println("Hi my name's Jared I'm 19 and I never learned how to read");
			break;
		case "Thursday":
			System.out.println("Hi my name's Trey I have a basketball game tomorrooooowowwwwwww");
			break;
		case "Friday":
			System.out.println("Come to Del Taco they've got fresha... freshavOCADO");
			break;
		case "Saturday":
			System.out.println("Chris, is that a WEED");
			break;
		}
	}
}
