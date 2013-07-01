package algorithm;

import java.io.FileNotFoundException;
import java.io.IOException;

import algorithm.base.BaseSimilarityAlgorithm;

import com.fastlink2.ssdeep.SpamSumSignature;
import com.fastlink2.ssdeep.Ssdeep;

public class SsdeepAlgoritm extends BaseSimilarityAlgorithm {

	private String file1, file2;
	
	public SsdeepAlgoritm(String file1, String file2) {
		this.file1 = file1;
		this.file2 = file2;
	}
	@Override
	protected double calculateSimilarity() {
		
		Ssdeep algo = new Ssdeep();
		SpamSumSignature sigFile1;
		SpamSumSignature sigFile2;
		double result = 0.0;
		try {
			sigFile1 = algo.fuzzy_hash_file(file1);
			sigFile2 = algo.fuzzy_hash_file(file2);
			result = algo.Compare(sigFile1, sigFile2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
