
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu extends JFrame
{
    static String[] modes = {"CIRCLE", "CIRCLE FILL", "SQUARE", "SQUARE FILL", "STAR", "STAR FILL"};
    static String[] colors = {"BLUE", "RED", "GREEN", "YELLOW", "BLACK", "RANDOM"};
    static String mode_text = modes[0];
    static String color_text = colors[0];
    static JComboBox<String> mode;
    static JComboBox<String> color;
    static VBox layout;
    static HBox buttons;
    static JButton reset;
    static JButton save;
    static JTextField size;

    public Menu()
    {
        super();
        mode = new JComboBox<>(modes);
        color = new JComboBox<>(colors);
        reset = new JButton("RESET");
        save = new JButton("SAVE");
        size = new JTextField(4);
        layout = new VBox();
        buttons = new HBox();
        add(layout);
        buttons.add(size);
        buttons.add(reset);
        buttons.add(save);
        layout.add(mode);
        layout.add(color);
        layout.add(buttons);
        pack();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mode.addItemListener(e ->
        {
            mode_text = mode.getSelectedItem().toString();
        });

        color.addItemListener(e ->
        {
            color_text = color.getSelectedItem().toString();
        });

        reset.addActionListener(e ->
        {
            Drawer.clear((Graphics2D) Canvas.image.getGraphics(), Canvas.width, Canvas.height);
        });

        save.addActionListener(e ->
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
            Date date = new Date();
            final String path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\generated\\image" + formatter.format(date) +  ".png";
            try
            {
                final RenderedImage ri =  Canvas.image;
                ImageIO.write(ri, "png", new File(path));
                setTitle("SAVED TO: " + path);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        });
    }
}
