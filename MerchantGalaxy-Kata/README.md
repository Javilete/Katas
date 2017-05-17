Merchant's Galaxy kata
---------------------------------------------

You decided to give up on earth and you move to the space. Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
 
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have collected the appropriate translation between them.

Roman numerals explanation can be found here: https://en.wikipedia.org/wiki/Roman_numerals

**SOLUTION AND DESIGN

Use of TDD Outside-In approach to help the implementation and design.
Starting with a guiding test based on the test input and test output specified
in the problem.

This guiding test (GuidingTest) has helped me to progress the implementation little by little
through the different classes and collaborators, from
the input of the problem until the verification of the output.

In most of the cases, for unit test I have used mocks (mockito framework), where
the collaborators of the class unit tested have been mocked as well as the behaviour if needed.
In other cases, for example in the GalaxyNumberShould test I have tested the state of the object.

The input of the problem is the GalaxyTranslator which reads the notes.
This class uses the Parser collaborator to read the notes and differenciate
between those types using regular expressions.
Depending on the on the note type, different actions take place:
- For statements, the information is processed and stored in the ConversionTable (numbers and units)
- For the questions, the entry is processed and uses the Calculator class
to obtain the result (using RomanConverter) which then calls Console to print it.

To run the application, GalaxyGuide contains the main program where the assembly of the components
is done and check that at least a parameter with the path of the notes is passed.

