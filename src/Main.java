import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import algorithm.BaseSimilarityAlgorithm;
import algorithm.LcsStringAlgorithm;
import algorithm.SimHashAlgorithm;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			String str1 = fileToString(args[0]);
			String str2 = fileToString(args[1]);
			BaseSimilarityAlgorithm sim = new LcsStringAlgorithm(str1, str2);
			BaseSimilarityAlgorithm simHash = new SimHashAlgorithm(str1, str2);
			System.out.println("Similaridade: " + sim.similarity() + " em " + sim.getTime() + "ms");
			System.out.println("Similaridade simhash: " + simHash.similarity() + " em " + simHash.getTime() + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    private static String fileToString(String filename) throws IOException {
        FileReader in = new FileReader(filename);
        BufferedReader br = new BufferedReader(in); 
        String s,text=""; 
        while((s = br.readLine()) != null) {
            text = text+s;   
        }
        br.close();
        return text;
    }
}
