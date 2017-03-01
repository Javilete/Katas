## FIZZ BUZZ KATA 

Implementation of the **fizz buzz** kata using outside TDD.

The game is a counting and number substitution game. Players take turns counting up from one, replacing any number
according to the following features:

**Feature 1 - Basic Fizz Buzz Scoring**
- Normal number should return that number so that the game can be scored according to the rules
- Multiple of three should return 'fizz' so that the game can be scored according to the rules
- Multiple of five should return 'buzz' so that the game can be scored according to the rules
- Multiple of three and five should return 'fizz buzz' so that the game can be scored according to the rules

**Feature 2 - Playing FizzBuzz Variations**
- Multiple of seven should return 'pop' so that the game can be scored according to the rules
- Multiple of three and seven should return 'fizz pop' so that the game can be scored according to the rules
- Multiple of five and seven should return 'buzz pop' so that the game can be scored according to the rules
- Multiple of three, five and seven should return 'fizz buzz pop' so that the game can be scored according to the rules

**Feature 3 - Creating Fizz Buzz Variations
- Choose custom substitutions so that I can tailor the game to my preferences
- Substitutions should work the same way as Fizz Buzz so that the essence of the game remains the same

The start was writing acceptance test for the first criteria of the feature 1 (basic scoring).
This led me to create a unique class FizzBuzz where all the logic was there.
As small refactorings where done during the implementation of this basic feature there was a point
that the rules had to be extracted from the FizzBuzz to the Game class. The former would have the
responsability of keeping track of the rules, adding them, retriving them.
FizzBuzz class would just have the method to calculate the score based on the game rules from the class.
