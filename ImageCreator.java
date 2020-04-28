import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ImageCreator extends JFrame implements MouseListener
{
    static Canvas canvas;
    static Menu menu;
    public ImageCreator()
    {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(Canvas.width, Canvas.height));
        add(canvas);
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        menu = new Menu();
    }
    public static void main(String[] args)
    {
        ImageCreator ic = new ImageCreator();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        Graphics2D g2d = (Graphics2D) canvas.getG2D();
        Drawer.draw(g2d, Menu.color_text, Menu.mode_text, e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
