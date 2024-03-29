package com.raga.scratch.game;

import java.util.List;
import java.util.Map;

/**
 * 
 * This class represents the main entry point for the scratch game application.
 * 
 * It reads the configuration file, generates a random matrix, calculates
 * Winning Combinations and rewards and prints the results in JSON format.
 */
public class ScratchGame {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println(
					"Please give in the proper format like : java -jar build_scratch_game-0.0.1-jar-with-dependencies.jar config.json 100");
			return;
		}

		String configFile = args[0];
		int bettingAmount = Integer.parseInt(args[1]);

		LoadConfigurationFile.loadConfig(configFile);
		
		List<List<String>> matrix = MatrixGenerator.generateRandomMatrix();
		
		Map<String, List<String>> appliedWinningCombinations = ScratchGameUtility.findAppliedWinningCombinations(matrix);
		
		ScratchGameUtility.calculateStandardSymbolReward(appliedWinningCombinations, bettingAmount);
		
		List<String> appliedBonusSymbol = ScratchGameUtility.findAppliedBonusSymbols(matrix);

		System.out.println("{\n\"matrix\": " + matrix + ",");
		System.out.println("\"reward\": " + ScratchGameUtility.reward + ",");
		System.out.println("\"applied_winning_combinations\": " + appliedWinningCombinations + ",");
		System.out.println("\"applied_bonus_symbol\": " + appliedBonusSymbol + "\n}");
	}
}
