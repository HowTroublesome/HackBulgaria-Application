public class SmallestSubstringContainingTheAlphabet {
	
	public static boolean isAlreadyCounted(String stringToCheckIn, char charToCheckFor){
		
		char charArray[] = stringToCheckIn.toCharArray();
		
		for(int i = 0; i < charArray.length; i++){
			if(charArray[i] == charToCheckFor){
				return true;
			}
		}
		return false;
	}
	
	private static boolean isContainingTheAlphabet(String userString) {

		String tempAlphabetString = "";
		int charCounter = 0;
		char[] charArray = userString.toCharArray();

		for (int i = 0; i < userString.length(); i++) {
			
			char currentChar = charArray[i];
			
			if(currentChar == 32){
				System.err.println("Error...! There Is A Blank Space...!");
				System.exit(0);
			}
			if(currentChar < 0 || currentChar > 127){
				System.err.println("Error...! Symbols Outside The ASCII Table...!");
				System.exit(0);
			}

			for (int j = 65; j < 91; j++) {

				if(!(isAlreadyCounted(tempAlphabetString, currentChar))){
				
					if ((currentChar == j) || currentChar == (j + 32)) {

						tempAlphabetString = tempAlphabetString + currentChar;
						charCounter++;

					}
				}
			}
			
			if (charCounter == 26) {
				return true;
			}
			
		}

		return false;
		
	}
	
	private static String smallestSubstringWithAlphabet(String userString) {

		int minSubstringLength = 25;
		boolean infiniteLoop = true;
		String errorMessage = "Alphabet Not Found In The Substring...!";
		
		while (infiniteLoop) {

			for (int i = 0; i < userString.length() - minSubstringLength; i++) {

				if (isContainingTheAlphabet(userString.substring(i, i + minSubstringLength + 1))) {
					infiniteLoop = false;
					return userString.substring(i, i + minSubstringLength + 1);
				}
			}
			
			minSubstringLength++;
			
			if (minSubstringLength >= userString.length()) {
				return errorMessage;
			}

		}
		
		return errorMessage; // unreachable code
		
	} 		
		
	public static void main(String[] arguments){
		System.out.print("Correct: ");
		System.out.println(smallestSubstringWithAlphabet("aaaaaabcdefghijklmnopqrstuvwxyz"));
		System.out.print("Correct: ");
		System.out.println(smallestSubstringWithAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn"));
		System.out.print("Incorrect: ");
		System.out.println(smallestSubstringWithAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxy!*abcdefghijklmn"));

	}
	
}
