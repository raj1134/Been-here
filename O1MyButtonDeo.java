import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.io.*;


class MyButton extends JComponent implements MouseListener, KeyListener, WindowListener, MouseMotionListener {
    int x, y, width, height, arcValue;
    String text;
    Color color, fontColor;
    Font font;

    public MyButton(int x, int y, int width, int height, int arcValue, String text, Color color, Color fontColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.arcValue = arcValue;
        this.text = text;
        this.color = color;
        this.fontColor = fontColor;
        this.setBounds(x, y, width, height);
        this.addMouseListener(this);
    }

    @Override 
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D.Double rectangle = new RoundRectangle2D.Double(0, 0, width, height, arcValue, arcValue);
        g2.setColor(color);
        g2.fill(rectangle);
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Button/Nunito.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment()  ; 
            ge.registerFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        g2.setFont(font);
        g2.setColor(fontColor);

        FontMetrics metrics = g2.getFontMetrics(font);
        Rectangle2D textBounds = metrics.getStringBounds(text, g2);

        int x = (getWidth() - (int) textBounds.getWidth()) / 2;
        int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();

        g2.drawString(text, x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked");
     }

    @Override
    public void mouseEntered(MouseEvent e) { 
        System.out.println("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) { 
        System.out.println("Mouse Exited");
    }

    @Override
    public void mousePressed(MouseEvent e) { 
    }

    @Override
    public void mouseReleased(MouseEvent e) { 
    }

    @Override
    public void windowActivated(WindowEvent e) { 
    }

    @Override
    public void windowClosed(WindowEvent e) { 
    }

    @Override
    public void windowClosing(WindowEvent e) { 
    }

    @Override
    public void windowDeactivated(WindowEvent e) { 
    }

    @Override
    public void windowDeiconified(WindowEvent e) { 
    }

    @Override
    public void windowIconified(WindowEvent e) {  
    }

    @Override
    public void windowOpened(WindowEvent e) { 
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {  
    }

    @Override
    public void keyTyped(KeyEvent e) {  
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}

public class O1MyButtonDeo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.add(new MyButton(250 - 100, 470 / 2 - 40, 200, 80, 20, "Hello", new Color(0x383837), new Color(0xfefefe)));
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x101010));
        frame.setVisible(true);
        //System.out.println(frame.getContentPane().getBounds().height);
    }
}
