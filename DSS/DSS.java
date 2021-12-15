import java.util.*;
import java.security.*;

public class DSS{
	public static void main(String[] args) throws Exception{
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
		KeyPair pair = keyPairGenerator.generateKeyPair();
		PrivateKey privKey = pair.getPrivate();

		String input = "Hello From DSS";
		Signature sign = Signature.getInstance("SHA256withDSA");
		sign.initSign(privKey);
		byte[] inp = input.getBytes();
		sign.update(inp);
		byte[] output = sign.sign();

		System.out.println(new String(output, "UTF-8"));
	}
}