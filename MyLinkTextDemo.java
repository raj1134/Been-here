package Text;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyLinkText extends JLabel implements MouseListener {
    
    String text;
    int x, y, width, height;
    float FontSize;
    Object Action;
    Font font;

    public MyLinkText (String text,float FontSize, int x, int y, Object Action) {
        super(text);   
        this.text = text;
        this.x = x;
        this.y = y;
        this.FontSize = (float) FontSize;
        this.Action = Action;
        this.setForeground(new Color(0x2260FF));
        this.addMouseListener(this);

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Text/NuSemiBold.ttf")).deriveFont(FontSize);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment()  ; 
            ge.registerFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        this.setFont(font);

        Dimension d = getPreferredSize();
        width = d.width;
        height = d.height;
        setBounds(x, y, width, height);
        System.out.println(height);
        System.out.println(width);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
        this.setForeground(new Color(0x2410CC));
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
        this.setForeground(new Color(0x2260FF));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}

public class MyLinkTextDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 600);
        MyLinkText f = new MyLinkText("New? Sign up and start playing chess.", 20, 564/2 - 354/2, 562/2 - 15, null);
        frame.add(f);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x101010));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println(frame.getContentPane().getBounds().height);
    }
}