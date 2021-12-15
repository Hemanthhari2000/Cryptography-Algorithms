import java.util.*;
import java.security.*;

public class SHA1{

	public static void main(String args[]) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		System.out.println(md.toString());

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your input: \t");
		String input = scan.next();
		input+= scan.nextLine();

		// System.out.println(input);

		md.update(input.getBytes());

		byte[] output = md.digest();

		System.out.println(output);
		System.out.println("value" + bytesToHex(output));
	}
	private static String bytesToHex(byte[] byteArr){
		char[] hexDigits = {'0','1', '2', '3', '4', '5', '6', '7', '8','9', 'A','B', 'C', 'D', 'E', 'F'};
			StringBuilder enc = new StringBuilder();
		for (byte b: byteArr){
			enc.append(hexDigits[(b >> 4) & 0x0f]);
			enc.append(hexDigits[b & 0x0f]);
		}
		return enc.toString();
	}
}