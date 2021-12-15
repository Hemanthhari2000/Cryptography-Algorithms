import java.util.*;
import javax.crypto.*;
import java.security.*;

public class DES{
	public static void main(String args[]) throws Exception{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
		SecretKey myDesKey = keyGenerator.generateKey();

		Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		// System.out.println(desCipher.toString());

		String input = "Java is good";

		desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

		byte[] enc = desCipher.doFinal(input.getBytes());

		System.out.println(enc);

		desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

		byte[] dec = desCipher.doFinal(enc);

		System.out.println(new String(dec));

	}
}