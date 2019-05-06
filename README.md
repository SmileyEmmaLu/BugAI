# Bug AI
### Bug.java
Bug class creates the new bugs and set's their default environment and position. Bug.java includes: 
* __seeIfBrighter()__ (compares the current pixel RGB value and the previous one to see if the pixel is getting ligher)
* __moveIt(int moveNum)__ (moves the bug in a certain direction depending on the brightness of the pixel)
* __getDistance()__ (returns the distance between the bugs current position and the brightest pixel)
### Environment.java 
The environment class is the class that encompasses the methods regarding the picture. The constructor determines the image, the number of steps a bug takes per move, the number of gnerations in the simulation, and the generation size of each. Environment.java includes:
* __getStartRBG()__ (returns RBG value of the initial pixel)
* __getBrightestXCord()__ and getBrightestYCord() (returns the X and Y cord of the brightest pixel determined when initialized)
* __getPixelVal(int xCord, int yCord)__ (returns RBG value of any pixel)
* __getEnviWidth() and getEnviHeight()__ (returns the size of the image)
* __getStep()__ (returns the number of steps per move)
* __getGenSize()__ (returns the generation size)
### light.png
This the image we used to test our code. 
