# **BOWLING KATA**


Bowling kata implemented in java using Outside-in TDD double loop, starting from and acceptance test and then going internally into unit test of each class or collaborators till the problem is resolved. 

The definition of the problem is as follows:
- Given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game.

Each game, or "line" of bowling, includes ten turns, or "frames" for the bowler.The scoring for this form of bowling will be:
- In each frame, the bowler gets up to two tries to knock down all the pins.
- If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
- If in two tries he knocks them all down, this is called a "spare" and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
- If on his first try in the frame he knocks down all the pins, this is called a "strike". His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
- If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
The game score is the total of all frame scores.
More info on the rules at: www.topendsports.com/sport/tenpin/scoring.htm

Some acceptance test cases (or guiding tests) are the following ones:

When scoring +X+ indicates a strike, / indicates a spare, - indicates a miss:

12 rolls: 12 strikes: +XXXXXXXXXXXX+ = 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 = 300
20 rolls: 10 pairs of 9 and miss: 9-9-9-9-9-9-9-9-9-9- = 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 = 90
21 rolls: 10 pairs of 5 and spare, with a final 5: 5/5/5/5/5/5/5/5/5/5/5 = 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 = 150
