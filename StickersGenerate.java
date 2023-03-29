import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StickersGenerate {
    public void generate(InputStream inputStream, String fileName) throws Exception {
        // STERAMING IMAGE
        // InputStream inputStream = new URL(
        // "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        // .openStream();
        BufferedImage originalFile = ImageIO.read(inputStream);

        // SETTING SIZE
        int fileWidht = originalFile.getWidth();
        int fileHeight = originalFile.getHeight() + 200;

        BufferedImage bufferedImage = new BufferedImage(fileWidht, fileHeight, BufferedImage.TRANSLUCENT);
        // String size = Integer.toString(fileHeight) + " " +
        // Integer.toString(fileWidht);
        // System.out.println("_______");
        // System.out.println(size);

        // CREATING A TRASNPARENT IMAGE
        Graphics2D newImage = (Graphics2D) bufferedImage.getGraphics();
        newImage.drawImage(bufferedImage, 0, 0, null);

        // SETTING FONT
        var fontType = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        newImage.setFont(fontType);
        newImage.setColor(Color.YELLOW);
        newImage.drawString("TOPZERA", 100, fileHeight - 100);

        // String newFileName = "arquivo";
        // SAVE IMAGE
        ImageIO.write(bufferedImage, "png", new File(fileName));

    }

    // public static void main(String[] args) throws Exception {
    // var makeImage = new StickersGenerate();
    // makeImage.generate();
    // }
}
