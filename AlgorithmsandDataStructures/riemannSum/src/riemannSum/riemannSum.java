package riemannSum;


import java.util.Scanner;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class riemannSum {

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);		
		int a, b, n, changeX, xi, answer = 0;
		System.out.print("Enter your function with x as the variable seperated by spaces ex.. (1 / x): ");
		//Expression class imported through build path
		Expression fx = new ExpressionBuilder(kb.nextLine())
		.variables("x", "y")
		.build();
		System.out.println();
		System.out.print("Enter the the first value of your integral partition... (a) ");
		a = kb.nextInt();
		System.out.println();
		System.out.print("Enter the the second value of your integral partition... (b) ");
		b = kb.nextInt();
		System.out.println();
		n = b - a;
		changeX = (b - a)/ n;
		
		for (int i = 0; i < n; i++) {
			xi = a + (i * changeX);
			fx.setVariable("x", xi);
				answer += (int) fx.evaluate();
		}
		kb.close();
		System.out.println(answer);
	}
}
