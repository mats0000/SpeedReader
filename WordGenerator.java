import java.util.Scanner; 
import java.io.FileReader;
import java.io.IOException;    

public class WordGenerator {
	private Scanner sc;
	private int wordCount;
	private int sentenceCount;
	
	public WordGenerator(String filename) {
		wordCount = 0;
		try {
			sc = new Scanner(new FileReader(filename));
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}
	
	public boolean hasNext() {
		return sc.hasNext();
	}
	
	public String next() {
		String nextWord = sc.next();
		wordCount++;
		char lastChar = nextWord.charAt(nextWord.length()-1);
		if (lastChar == '!' || lastChar == '.' || lastChar == '?') sentenceCount++;
		return nextWord;
	} 
	
	public int getWordCount() {
		return wordCount;
	}
	
	public int getSentenceCount() {
		return sentenceCount;
	}
	
	public Scanner getScanner() {
		return sc;
	}
}
