import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Engineering;


public class code {

	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		//if 1 text to morse if 2 morse to text
		int textOrMorse;
		String phrase, answer;
		System.out.println("Text to morse or morse to text");
		textOrMorse = kb.nextInt();
		System.out.println("enter stuff");
		phrase = kb.nextLine();
		if (textOrMorse == 1) {
			answer = EnglishToMorse(phrase);
		}
		else answer = MorseToEnglish(phrase);
	}
	
	private static String EnglishToMorse(String phrase) {
		Scanner kb = new Scanner(System.in);
		String answer = "";
		for (int i = 0; i < phrase.length(); i++) {
			answer += findCharacter(phrase.charAt(i));
		}
		
		return answer;
		
		
		
		
	}
	
	private static String findCharacter(char letter) {
		//or a switch statment
		if (letter == a) {
			return "morse code"; //whatever morse code
		}
		//for all letters
		
	}
	private static String MorseToEnglish(String morse) {
		
	}
}
