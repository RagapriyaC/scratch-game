# scratch-game
Build a scratch game, that will generate a matrix (for example 3x3) from symbols(based on probabilities for each individual cell) and based on winning combinations user either will win or lost

# Prerequisites:
# Application Required :
Eclipse IDE
# Running the Application in CLI:
1. Download the project from github and unzip the downloaded folder
2. Navigate to the Project Folder (say C:\Users\HP\Downloads\scratch-game-main\target) and ensure build_scratch_game-0.0.1-jar-with-dependencies.jar is present in that folder.
3. open Command Prompt terminal from the respective containing folder (C:\Users\HP\Downloads\scratch-game-main\target)
4. Give the below command and test the output
5. "java -jar build_scratch_game-0.0.1-jar-with-dependencies.jar config.json 100"
   
Note : 100 denotes the betting amount, you can change the amount accordingly.

1.	“build_scratch_game-0.0.1-jar-with-dependencies.jar” denotes the jar name.
2.	“config.json” configuration file 
3.	“100” denotes the betting amount, you can change the betting output and check the output.
   
# Running the Application in Eclipse:
1. Download the project from github and import as existing maven project.
2. Do maven build and check for any compilation errors.
3. Right-click on the ScratchGame class (the one with the main method) and select "Run As" > "Run Configurations”
4. In "Run Configurations”, please add the program arguments as “config.json 100” and click “apply” and then “run” to run the application.
   
Note : 100 denotes the betting amount, you can change the amount accordingly.

6. The application will start and you should see the console output in JSON format successfully.
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/59933920-bf5b-44ef-93a3-955ffd7c90d5)

# Sample Output and Testing Screenshots:
# IN CLI MODE:
# Test Case 1:
Output:
{
"matrix": [[F, E, MISS], [E, F, E], [F, D, F]],
"reward": 1425,
"applied_winning_combinations": {E=[same_symbol_3_times], F=[same_symbol_4_times, same_symbols_diagonally_left_to_right, same_symbol_3_times]},
"applied_bonus_symbol": []
}

Explanation :

Reward = (Betting amount * Symbol E Reward * same_symbol_3_times) + 
(Betting amount * Symbol F Reward * same_symbol_4_times * same_symbols_diagonally_left_to_right * same_symbol_3_times)

= (100 * 3 * 1) + (100 * 1.5 * 1.5 * 5 *1)

Reward = 1425

![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/605c7b37-5043-4380-a66b-fb342b9741c9)

# Test Case 2 With Bonus symbol:
Output:
{
"matrix": [[MISS, D, C], [E, +1000, E], [F, E, B]],
"reward": 1300,
"applied_winning_combinations": {E=[same_symbol_3_times]},
"applied_bonus_symbol": [+1000]
}

Explanation :

Reward = (Betting amount * Symbol E Reward * same_symbol_3_times
= (100 * 3 * 1) + (1000 (bonus symbol)
Reward = 1300
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/a695e9d9-09b2-43df-8a38-ad2446a06735)

# Test Case 3 with No Winning Combination:
Output:
{
"matrix": [[D, F, C], [+1000, F, MISS], [D, E, E]],
"reward": 0,
"applied_winning_combinations": {},
"applied_bonus_symbol": [+1000]
}
Explanation :

Reward = 0 (No winning Combination)
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/2672e335-540c-4926-a73e-9447da0546e9)

# Test Case 4 with Multiple Symbols:
Output :

{
"matrix": [[E, D, F], [F, E, F], [D, D, E]],
"reward": 2150,
"applied_winning_combinations": {D=[same_symbol_3_times], E=[same_symbols_diagonally_left_to_right, same_symbol_3_times], F=[same_symbol_3_times]},
"applied_bonus_symbol": []
}

Explanation :

Reward = (Betting amount * Symbol D Reward * same_symbol_3_times) +
(Betting amount * Symbol E Reward * same_symbols_diagonally_left_to_right * same_symbol_3_times)
(Betting amount * Symbol F Reward * same_symbol_3_times)

= (100 * 5 * 1) + (100 * 3 * 5 * 1) + (100 * 1.5 * 1) 
Reward = 2150
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/d3712372-3e12-4c68-b349-7dc051f601a1)

# IN Eclipse IDE:
# Test Case 1:
Output:
{
"matrix": [[F, F, C], [F, B, C], [F, B, MISS]],
"reward": 450,
"applied_winning_combinations": {F=[same_symbols_vertically, same_symbol_4_times, same_symbol_3_times]},
"applied_bonus_symbol": []
}

Explanation :
Reward = (Betting amount * Symbol F Reward * same_symbols_vertically * same_symbol_4_times * same_symbol_3_times)

= 100 * 1.5 * 2 * 1.5 * 1
Reward = 450
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/2d747254-7cf7-48b1-99c4-e019809e8d18)
# Test Case 2 with Bonus symbol:
Output:
{
"matrix": [[C, D, 10x], [B, D, B], [D, D, D]],
"reward": 60000,
"applied_winning_combinations": {D=[same_symbols_vertically, same_symbol_5_times, same_symbol_4_times, same_symbol_3_times, same_symbols_horizontally]},
"applied_bonus_symbol": [10x]}
Explanation :

Reward = (Betting amount * Symbol D Reward * same_symbols_vertically * same_symbol_5_times  * same_symbol_4_times * same_symbol_3_times * same_symbols_horizontally)

= 100 * 5 * 2 * 2 * 1.5 * 1 * 2
= Reward * 10 (bonus symbol)
Reward = 60000
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/da14a0b3-9015-4f31-a75d-739567f1767d)
# Test Case 3 with No Winning Combination:
Output:
{
"matrix": [[E, A, C], [B, E, D], [F, D, B]],
"reward": 0,
"applied_winning_combinations": {},
"applied_bonus_symbol": []
}

Explanation :
Reward = 0 (No winning Combination)
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/3165531c-6542-4671-8d9e-e2710c321681)
Test Case 4 with Multiple Symbols:
Output :
{
"matrix": [[B, B, F], [C, B, F], [F, E, B]],
"reward": 18900,
"applied_winning_combinations": {B=[same_symbol_4_times, same_symbols_diagonally_left_to_right, same_symbol_3_times], F=[same_symbol_3_times]},
"applied_bonus_symbol": []
}

Explanation :
Reward = (Betting amount * Symbol B Reward * same_symbol_4_times * same_symbols_diagonally_left_to_right * same_symbol_3_times) + 
(Betting amount * Symbol F Reward * same_symbol_3_times)

= (100 * 25 * 1.5 * 5 * 1) + (100*1.5*1)
Reward =18900
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/d6eaa6f7-f72f-4d5a-8f5e-2cf555cf87ed)
# Random Screenshot :
![image](https://github.com/RagapriyaC/scratch-game/assets/157902475/230eed07-3018-4b9a-8629-f35e4b3f2797)


