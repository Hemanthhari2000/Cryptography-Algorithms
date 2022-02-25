import java.awt.Point;


public class PlayFair {
	
	private static char[][] charTable;
	private static Point[] positions;
	
	
	private static String prepareText(String text, boolean isDecipher) {
		return isDecipher ? text.replace("J", "I") : text.toUpperCase().replace("I", "J");
	}
	
	private static void createKeyTable(String key) {
		charTable = new char[5][5];
		positions = new Point[26];
		
		key = prepareText(key + "ABCDEFGHIJKLMNOPQRSTUVWXYZ", false);
		
		for(int i=0, k=0; i < key.length(); i++ ) {
			char ch = key.charAt(i);
			if(positions[ch - 'A'] == null) {
				charTable[k/5][k%5] = ch;
				positions[ch - 'A'] = new Point(k/5, k%5);
				k++;
			}
		}
		
		System.out.println("Key Matrix");
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(charTable[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
	
	private static String encode(String plaintext, int dif) {
		StringBuilder sb = new StringBuilder(plaintext);
		for(int i = 0; i<sb.length(); i+=2) {
			if(i == sb.length() - 1) {
				sb.append(sb.length() % 2 == 0 ? "" : "X");
			}
			else if (sb.charAt(i) == sb.charAt(i+1)){
				sb.insert(i+1, "X");
			}
		}
		
		
		for (int i=0; i<sb.length(); i+=2) {
			
			char leftChar = sb.charAt(i);
			char rightChar = sb.charAt(i+1);
			
//			First Char Points
			int row1 = positions[leftChar - 'A'].x;
			int col1 = positions[leftChar - 'A'].y;
			
//			Second Char Points	
			int row2 = positions[rightChar - 'A'].x;
			int col2 = positions[rightChar - 'A'].y;
			
						
//			#1 Same Column
			if (col1 == col2) {
				row1 = (row1 + dif) % 5;
				row2 = (row2 + dif) % 5;
			}
			
//			#2 Same Row
			else if (row1 == row2) {
				col1 = (col1 + dif) % 5;
			    col2 = (col2 + dif) % 5;
			}
			
//			#3 Diagonal
			else {
				int temp = col1;
				col1 = col2;
				col2 = temp;
			}
			
			sb.setCharAt(i, charTable[row1][col1]);
			sb.setCharAt(i+1, charTable[row2][col2]);
		}
		
		
		
		return sb.toString();
	}
	
	public static void main(String args[]) {
//		String plaintext = "GIPSON";
//		String plaintext = "HEMANTH";
		String plaintext = "BALLOON";
		String key = "MONARCHY";
		createKeyTable(key);
		
		String ciphertext = encode(prepareText(plaintext, false), 1);	
		System.out.println(ciphertext);
		
		String deciphertext = prepareText(encode(ciphertext, -1), true);
		System.out.println(deciphertext);
		
	}
}
