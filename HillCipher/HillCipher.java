import java.util.Scanner;

public class HillCipher {

	
	private static int[][] keyMatrix;
	
	
	private static int[] convertTextToNumberArray(String text) {
		StringBuilder plaintext = new StringBuilder(text);
		int[]  numberArray = new int[3];
		
		for(int i=0; i<3; i++) {
			numberArray[i] = (int)(plaintext.charAt(i) - 'A');
		}
		return numberArray;
	}
	
	private static String convertNumberArrayToText(int[] numberArray) {
		StringBuilder text = new StringBuilder();
		
		for(int i=0; i<3; i++) {
			text.append((char)(numberArray[i] + 'A'));
		}
		
		return text.toString();
	}
	
	private static int[] encode(int[] plaintextArray) {
		int[] ciphertextArray = new int[3];
		
		ciphertextArray[0] = (keyMatrix[0][0] * plaintextArray[0] + keyMatrix[0][1] * plaintextArray[1] + keyMatrix[0][2] * plaintextArray[2]) % 26;
		ciphertextArray[1] = (keyMatrix[1][0] * plaintextArray[0] + keyMatrix[1][1] * plaintextArray[1] + keyMatrix[1][2] * plaintextArray[2]) % 26;
		ciphertextArray[2] = (keyMatrix[2][0] * plaintextArray[0] + keyMatrix[2][1] * plaintextArray[1] + keyMatrix[2][2] * plaintextArray[2]) % 26;
		
		return ciphertextArray;
		
	}
	
	public static void main(String[] args) {
		String plaintext;
		keyMatrix = new int[3][3];

		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Plaintext: ");
		plaintext = sc.nextLine();
		System.out.println("Enter Key elements");

		
		for(int i=0;i<3;i++) {
			for(int j=0; j<3; j++) {
				keyMatrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		System.out.println("Key is as follows: ");
		for(int i=0;i<3;i++) {
			for(int j=0; j<3; j++) {
				System.out.print(keyMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
		int[] ciphertextArray = encode(convertTextToNumberArray(plaintext));
		
		for(int val: ciphertextArray) {
			System.out.println(val);
		}
		
		
		String ciphertext = convertNumberArrayToText(ciphertextArray);
		
		System.out.println(ciphertext);
		
	}
	
	
}
