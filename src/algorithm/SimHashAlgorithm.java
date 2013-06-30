package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimHashAlgorithm extends StringSimilarityAlgorithm {

	public SimHashAlgorithm(String str1, String str2) {
		super(str1,str2);
	}
	
	@Override
	protected double calculateSimilarity() {
		
		Map<String,Integer> wordsMap1 = new HashMap<String,Integer>(); 
		String[] wordsStr1 = str1.split("\\s+");
		for (String w : wordsStr1) {
			Integer count = wordsMap1.get(w);
			if (count == null) {
				count = new Integer(0);
				
			}
			count++;
			wordsMap1.put(w,count);
		}
		Map<String,Integer> wordsMap2 = new HashMap<String,Integer>(); 
		String[] wordsStr2 = str2.split("\\s+");
		for (String w : wordsStr2) {
			Integer count = wordsMap2.get(w);
			if (count == null) {
				count = new Integer(0);
				
			}
			count++;
			wordsMap2.put(w,count);
		}
		
		Set<String> allWords = new HashSet<String>(wordsMap1.keySet());
		allWords.addAll(wordsMap2.keySet());
		List<String> wordsList = new ArrayList<String>(allWords);
		
		double[] freq1 = new double[wordsList.size()];
		for (int i = 0; i < wordsList.size(); i++) {
			Integer count = wordsMap1.get(wordsList.get(i));
			freq1[i] = (count == null)?0.0:count.doubleValue();
		}
		
		double[] freq2 = new double[wordsList.size()];
		for (int i = 0; i < wordsList.size(); i++) {
			Integer count = wordsMap2.get(wordsList.get(i));
			freq2[i] = (count == null)?0.0:count.doubleValue();
		}
		SimHash<String> sh = SimHash.build(wordsList);
		
		return sh.similarity(freq1, freq2);
	}
}
