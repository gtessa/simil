package algorithm;

import java.util.ArrayList;
import java.util.List;

import algorithm.base.BaseSimilarityAlgorithm;

import com.devdaily.system.SystemCommandExecutor;

public class SdhashAlgorithm extends BaseSimilarityAlgorithm {

	String file1, file2;
	
	public SdhashAlgorithm(String file1, String file2) {
		this.file1 = file1;
		this.file2 = file2;
	}
	
	@Override
	protected double calculateSimilarity() {
		
		List<String> command = new ArrayList<String>();
		command.add("c:/users/gabriel/workspace/sdhash-3.2.5-x64/sdhash.exe");
		command.add(file1);
		command.add(file2);
		command.add("> output.sdbf");
		
		SystemCommandExecutor sce = new SystemCommandExecutor(command);
		//int result = sce.executeCommand();

		return 0;
	}

}
