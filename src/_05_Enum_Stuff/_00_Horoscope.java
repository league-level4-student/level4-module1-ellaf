package _05_Enum_Stuff;

import javax.swing.JOptionPane;

public class _00_Horoscope {
	// 1. Create an enum in a separate file called Zodiac that contains a category for
	//    all 12 zodiac signs.
	
	// 2. Write a method that takes in a Zodiac enum object and uses a JOPtionPane to display
	//    a different horoscope based on the Zodiac's state.
	void zodiac(Zodiac r) {
		switch(r) {
		case LIBRA: {
			System.out.println("fab");
			break;
		}
		case CAPRICORN: {
			System.out.println("yeet");
			break;
		}
		case ARIES: {
			System.out.println("love it");
			break;
		}
		case TAURUS: {
			System.out.println("EXCELLENT");
			break;
		}
		case SAGITTARIUS: {
			System.out.println("fun");
			break;
		}
		case AQUARIUS: {
			System.out.println("fresh");
			break;
		}
		case VIRGO: {
			System.out.println("fiesta");
			break;
		}
		case CANCER: {
			System.out.println("godlike");
			break;
		}
		case GEMINI: {
			System.out.println("iconic");
			break;
		}
		case LEO: {
			System.out.println("i literally don't know any leos");
			break;
		}
		case SCORPIO: {
			System.out.println("legendary");
			break;
		}
		case PISCES: {
			System.out.println("A++++");
			break;
		}
		
			
		}
		
		
	}
	// 3. Make a main method to test your method
	public static void main(String[] args) {
		_00_Horoscope cons = new _00_Horoscope();
		cons.zodiac(Zodiac.ARIES);
	}
}
