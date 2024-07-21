import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

class O1MyFrame extends JFrame implements MouseListener, KeyListener, WindowListener, MouseMotionListener {

    final public static int WIDTH = 1520;
    final public static int HEIGHT = 855;
    Color bgColor = new Color(0x303030); 

    public O1MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1520, 855);
        this.getContentPane().setBackground(bgColor);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.addKeyListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
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
}

public class O1MyFrameDemo {
    public static void main(String[] args) {
        O1MyFrame frame = new O1MyFrame();
        frame.setVisible(true);
    }
}
