import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Environment {
    private final BufferedImage lightImage;
    private final int step;
    private final int[] brightestPixel;
    private final int numGens; //how many generations
    private final int genSize; //how big each generation is
    private Bug [] top;

    public Environment(String imageName, int step, int numGens, int genSize)  throws IOException {
        lightImage = ImageIO.read(new File(
                imageName));//src/images.jpeg
        this.step = step;
        this.numGens = numGens;
        this.genSize = genSize;
        top = new Bug[genSize/10];

        Color c;
        int[] light = new int [2];
        int smallestSum = 0;
        for(int row = 0; row <lightImage.getHeight(); row++){
            for(int col = 0; col < lightImage.getWidth(); col++){
                c = new Color(lightImage.getRGB(col, row));
                if(c.getBlue() + c.getRed() + c.getGreen() < smallestSum){
                    smallestSum = c.getBlue() + c.getRed() + c.getGreen();
                    light[0] = row;
                    light[1] = col;
                }
            }
        }
        brightestPixel = new int[2];
        brightestPixel[0] = light[0];
        brightestPixel[1] = light[1];
    }
    public int getStartRBG(){
        Color c = new Color(lightImage.getRGB(0, 0));

        return c.getRed() + c.getGreen() + c.getBlue();
    }

    public int getBrightestXCord(){
        return brightestPixel[0];
    }

    public int getBrightestYCord(){
        return brightestPixel[1];
    }

    public int getPixelVal(int xCord, int yCord){
        Color c = new Color(lightImage.getRGB(xCord, yCord));
        return c.getBlue() + c.getGreen() + c.getRed();
    }

    public int getEnviWidth(){
        return lightImage.getWidth();
    }

    public int getEnviHeight(){
        return lightImage.getHeight();
    }

    public int getStep(){
        return step;
    }

    public int getGenSize(){
        return genSize;
    }

    public

}
