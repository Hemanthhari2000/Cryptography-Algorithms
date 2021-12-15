import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class AES{
	private static SecretKeySpec secretKey;
	private static byte[] key;


	public static void setKey(String myKey) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		key = myKey.getBytes();
		key = md.digest(key);
		key = Arrays.copyOf(key, 16);
		secretKey = new SecretKeySpec(key, "AES");
	}

	public static String encrypt(String text, String secret) throws Exception{
		setKey(secret);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] b = cipher.doFinal(text.getBytes());
		return Base64.getEncoder().encodeToString(b);
	}

	public static String decrypt(String enc) throws Exception{
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);

		return new String(cipher.doFinal(Base64.getDecoder().decode(enc)));
	}

	public static void main(String[] args) throws Exception{
		String secretKey = "FUTURE";
		String input = "COMPUTERS ARE OUR FUTURE";

		String enc = encrypt(input, secretKey);
		System.out.println(enc);

		String dec = decrypt(enc);
		System.out.println(dec);
	}
}