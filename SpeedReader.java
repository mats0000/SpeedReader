import java.awt.Font;
import java.awt.Graphics;
public class SpeedReader {

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 5) {
			System.out.println(args.length);
			System.out.println("Please provide 5 command line arguments. (filename, width, height, font size and words per minute)");
			System.exit(1);
		}
		
		String fileName = args[0];
		int width = Integer.valueOf(args[1]);
		int height = Integer.valueOf(args[2]);
		int fontSize = Integer.valueOf(args[3]);
		int wpm = Integer.valueOf(args[4]);
		int wpms = 60000 / wpm; 
		WordGenerator wg = new WordGenerator(fileName);
		DrawingPanel dp = new DrawingPanel(width, height);
		Font font = new Font("Courier",Font.PLAIN,fontSize);
		Graphics gc = dp.getGraphics();
		gc.setFont(font);
		int centerH = height / 2;
		int centerW = width / 2 - 50;
		while (wg.hasNext()) {
			gc.drawString(wg.next(),centerW, centerH);
			Thread.sleep(wpms);
			dp.clear();
		}
		System.out.println("total number of words: " + wg.getWordCount());
		System.out.println("total number of sentences: " + wg.getSentenceCount());
		wg.getScanner().close();
	}

}
