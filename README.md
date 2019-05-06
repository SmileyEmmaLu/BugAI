# Bug AI
### Bug.java
Bug class creates the new bugs and set's their default environment and position. Bug.java includes: 
...seeIfBrighter (compares the current pixel RGB value and the previous one to see if the pixel is getting ligher).. 
...moveIt (moves the bug in a certain direction depending on the brightness of the pixel)..
...getDistance (returns the distance between the bugs current position and the brightest pixel).. 
### Environment.java 
The environment class is the class that encompasses the methods regarding the picture. The constructor determines the image, the number of steps a bug takes per move, the number of gnerations in the simulation, and the generation size of each. Environment.java includes
