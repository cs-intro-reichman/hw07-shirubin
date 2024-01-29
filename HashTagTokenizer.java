

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		// // for (int i = 0; i < dictionary.length; i++) {
		// // 	System.out.println(dictionary[i]);
		// // }
		// System.out.println(existInDictionary("abc", dictionary));
		breakHashTag(hashTag, dictionary);
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

	public static boolean existInDictionary(String word, String []dictionary) {
		// Your code here
		boolean exist = false;
		for (int i = 0; i < dictionary.length && exist==false; i++) {
			// System.out.println(dictionary[i] + " ? " + word);
			if(word.equals(dictionary[i])){
				exist = true;
			}
		}
		return exist;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
		
		hashtag = hashtag.toLowerCase();

        int N = hashtag.length();
		boolean foundWord = false;
        for (int i = 1; i <= N && foundWord==false; i++) {
			if(existInDictionary(hashtag.substring(0, i),dictionary)){
				foundWord = true;
				System.out.println(hashtag.substring(0, i));
				breakHashTag(hashtag.substring(i), dictionary);
			}
        }
    }

}
