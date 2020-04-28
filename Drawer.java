
import java.awt.*;
import java.util.Random;

public class Drawer
{
    static int default_width = 100;
    static Color default_color = Color.BLACK;
    public static void draw(Graphics2D g2d, String color, String mode, int x, int y)
    {
        switch(mode)
        {
            case "CIRCLE":
                drawCIRCLE(g2d, color, x, y);
                break;
            case "CIRCLE FILL":
                drawCIRCLE_FILL(g2d, color, x, y);
                break;
            case "SQUARE":
                drawSQUARE(g2d, color, x, y);
                break;
            case "SQUARE FILL":
                drawSQUARE_FILL(g2d, color, x, y);
                break;
            case "STAR":
                drawSTAR(g2d, color, x, y);
                break;
            case "STAR FILL":
                drawSTAR_FILL(g2d, color, x, y);
                break;
        }
    }

    public static Color getColor(String color_string)
    {
        switch(color_string)
        {
            case "BLUE":
                return Color.BLUE;
            case "RED":
                return Color.RED;
            case "GREEN":
                return Color.GREEN;
            case "YELLOW":
                return Color.YELLOW;
            case "BLACK":
                return Color.BLACK;
            case "RANDOM":
                Random random = new Random();
                Color result = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                return result;
            default :
                return default_color;
        }
    }

    public static int get()
    {
        try
        {
            int result = Integer.parseInt(Menu.size.getText());
            if(result < Canvas.width / 2)
            {
                return result;
            }
            else
            {
                return Canvas.width / 2;
            }
        }
        catch(NumberFormatException e)
        {
            return default_width;
        }
        catch(NullPointerException e)
        {
            return default_width;
        }
    }

    public static void clear(Graphics2D g2d, int x, int y)
    {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, Canvas.width, Canvas.height);
        ImageCreator.canvas.repaint();
    }

    public static void drawCIRCLE(Graphics2D g2d, String color, int x, int y)
    {
        g2d.setColor(getColor(color));
        int n = get();
        g2d.drawOval(x - n / 2, y - n / 2, n, n);
        ImageCreator.canvas.repaint();
    }

    public static void drawCIRCLE_FILL(Graphics2D g2d, String color, int x, int y)
    {
        g2d.setColor(getColor(color));
        int n = get();
        g2d.fillOval(x - n / 2, y - n / 2, n, n);
        ImageCreator.canvas.repaint();
    }

    public static void drawSQUARE(Graphics2D g2d, String color, int x, int y)
    {
        g2d.setColor(getColor(color));
        int n = get();
        g2d.drawRect(x - n / 2, y - n / 2, n, n);
        ImageCreator.canvas.repaint();
    }

    public static void drawSQUARE_FILL(Graphics2D g2d, String color, int x, int y)
    {
        g2d.setColor(getColor(color));
        int n = get();
        g2d.fillRect(x - n / 2, y - n / 2, n, n);
        ImageCreator.canvas.repaint();
    }

    public static void drawSTAR(Graphics2D g2d, String color, int x, int y)
    {
        g2d.setColor(getColor(color));
        int n = get();
        Polygon p = new Polygon();
        for(int i = 0; i < 5; i++)
        {
            p.addPoint((int)((n / 2) * Math.cos(Math.toRadians(90 + i * 72)) + x), (int) ((n / 2) * Math.sin(Math.toRadians(90 + i * 72)) + y));
            p.addPoint((int)((n / 4) * Math.cos(Math.toRadians(126 + i * 72)) + x), (int) ((n / 4) * Math.sin(Math.toRadians(126 + i * 72)) + y));
        }
        g2d.drawPolygon(p);
        ImageCreator.canvas.repaint();
    }

    public static void drawSTAR_FILL(Graphics2D g2d, String color, int x, int y)
    {
        g2d.setColor(getColor(color));
        int n = get();
        Polygon p = new Polygon();
        for(int i = 0; i < 5; i++)
        {
            p.addPoint((int)((n / 2) * Math.cos(Math.toRadians(90 + i * 72)) + x), (int) ((n / 2) * Math.sin(Math.toRadians(90 + i * 72)) + y));
            p.addPoint((int)((n / 4) * Math.cos(Math.toRadians(126 + i * 72)) + x), (int) ((n / 4) * Math.sin(Math.toRadians(126 + i * 72)) + y));
        }
        g2d.fillPolygon(p);
        ImageCreator.canvas.repaint();
    }
}
