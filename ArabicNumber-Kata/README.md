## Arabic Number kata

This kata should return the arabic (or decimal) number from a roman numeral given.

The acceptance criteria is as follows:
- I want customers to be able to convert numerals to numbers so that they can buy the latest version of the game
- Given I have started the converter When I enter $numeral Then $number is returned

The process to come up with the final solution has been doing Test Driven Development. Starting for a guiding test using no-extreme acceptance criteria, I was able to implement the solution. Spliting responsabilities between classes and using a combination between mocks (london school) and state checking(classsist) having a converter, calculator and a class that holds the conversions resolve the problem. 

A important detail is that in the calculator, at the beginning it was implemented using a while loop but in the refactor phase I came up with an improved solution using recursive calls to obtain the final result. 
