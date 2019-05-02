import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bug{
    Random r = new Random();
    private int yCord;
    private int xCord;
    private char[] charray;//N= north, S= south, W= west , E = east
    private int lastPixel;
    private Environment mine;

    //
    public Bug(Environment mine, boolean ifFirstGen){
        xCord = 0;
        yCord = 0;
        charray = new char[8];//nB, eB, sB, wB, nD, eD, sD, wD
        this.mine = mine;
        lastPixel = mine.getStartRBG();

        if(ifFirstGen){
            for(int i = 1; i <= 8; i++){
                int rand = r.nextInt(1000);
                if(rand <= 250){
                    charray[i] = 'N';
                }
                else if(rand >= 250 && rand <= 500) {
                    charray[i] = 'E';
                }
                else if(rand >= 500 && rand <= 750){
                    charray[i] = 'S';
                }
                else{
                    charray[i] = 'W';
                }
            }
        }
        else{
            
        }



    }



    public boolean seeIfBrighter(){
        int sumNow = mine.getPixelVal(xCord, yCord);
        return (sumNow > lastPixel); //greater sum = lighter
    }

    public boolean moveIt(int moveNum) { //will return true if not off of the image and within legal move number
        if(moveNum < charray.length){
            char currentMove = charray[moveNum];
            int newX = xCord;
            int newY = yCord;
            int width = mine.getEnviWidth();
            int height = mine.getEnviHeight();
            if (currentMove == 'N') {
                newY += mine.getStep();
            }else if(currentMove == 'S') {
                newY -= mine.getStep();
            }else if(currentMove == 'W') {
                newX -= mine.getStep();
            }else { //direction is east
                newX += mine.getStep();
            }
            if (newX > width || newY > height) {
                return false;
            }else {
                yCord = newY;
                xCord = newX;
                moveIt(moveNum + 1);
                lastPixel = mine.getPixelVal(newX, newY);
                return true;
            }
    }
        return false;
    }

    public double getDistance(){
        double distance = Math.sqrt((xCord-mine.getBrightestXCord())*(xCord-mine.getBrightestXCord()) + (yCord-mine.getBrightestYCord())*(yCord-mine.getBrightestYCord()));
        return distance;
    }
}
