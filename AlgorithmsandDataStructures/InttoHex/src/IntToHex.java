
public class IntToHex {

	
	public static char[] convert(int n) {
		String digits = "0123456789ABCDEF";
		if (n == 0) {
			char[] hex = {'0'};
			return hex;
		}
		String hex = "";
		while (n > 0) {
			int digit = n % 16;
			hex = digits.charAt(digit) + hex;
			n = n / 16;
		}
		char[] hex1 = new char[hex.length()];
		for (int i = 0; i < hex.length(); i++) {
			hex1[i] = hex.charAt(i);
		}
		return hex1;
	}
	public static void main(String[] args) {
		char[] hex = convert(199);
		
		for (int i = 0; i < hex.length; i++) {
			System.out.print(hex[i]);
		}
	}
}
