import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class Canvas extends JPanel
{
    static int width = 500;
    static int height = 500;
    static BufferedImage image;

    public Canvas()
    {
        super();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0,this);
    }

    public Graphics2D getG2D()
    {
        return (Graphics2D) image.getGraphics();
    }
}
