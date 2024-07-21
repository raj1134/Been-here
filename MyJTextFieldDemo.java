import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

class MyJTextField extends JTextField implements FocusListener {

    Color borderColor = new Color(0, 0, 0, 20);
    Font font;
    int x, y, width, height;

    public MyJTextField(int x, int y, int width, int height) {
        this.setOpaque(false);
        this.setBackground(new Color(0x383838));
        this.setForeground(new Color(0xAAAAAA));
        this.setCaretColor(new Color(0xAAAAAA));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setMargin(new Insets(0, 10, 0, 10));
        this.setBounds(x, y, width, height);
        this.addFocusListener(this);
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("NuSemiBold.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment()  ; 
            ge.registerFont(font);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        this.setFont(font);
    }

    public void setBorderColor(Color color) {
        borderColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0x383838));
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 16, 16);
        super.paintComponent(g2);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 16, 16);
    }

    @Override
    public void focusGained(FocusEvent e) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        this.setBorderColor(new Color(0x888888));
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.setBorderColor(new Color(0, 0, 0, 20));
    }
}

public class MyJTextFieldDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(800, 800);
        MyJTextField f = new MyJTextField(400 - 230, 400 - 30, 460, 60);
        frame.add(f);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x101010));
        frame.setVisible(true);
        //System.out.println(frame.getContentPane().getBounds().height);
    }
}
