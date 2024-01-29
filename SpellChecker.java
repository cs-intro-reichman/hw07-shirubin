
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		// System.out.println(levenshtein("SPELL", "spell"));

	}

	public static String tail(String str) {
		return str.substring(1);
		// Your code goes here
	}

	public static int levenshtein(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();

		if(word1.length()==0){
			return word2.length();
		}
		if(word2.length()==0){
			return word1.length();
		}
		if (word1.substring(0, 1).equals(word2.substring(0, 1))){
			return levenshtein(tail(word1), tail(word2));
		}
		int option1 = levenshtein(tail(word1), word2);
		int option2 = levenshtein(word1, tail(word2));
		int option3 = levenshtein(tail(word1), tail(word2));
		return 1 + Math.min(option1, Math.min(option2, option3));


		
		// Your code goes here
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		int i=0;
		In in = new In(fileName);
		while(!in.isEmpty()){
			dictionary[i]= in.readLine();
			i++;
		}
		// Your code here

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int minDistance = levenshtein(word, dictionary[0]);
		String similarWord = word;
		for (int i = 1; i < dictionary.length; i++) {
			if(levenshtein(word, dictionary[i])<=threshold){
				if (levenshtein(word, dictionary[i])<minDistance){
					minDistance=levenshtein(word, dictionary[i]);
					similarWord = dictionary[i];
				}
			}
		}
		return similarWord;
		// Your code goes here
	}

}
