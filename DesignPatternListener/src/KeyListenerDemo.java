import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyListenerDemo extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextArea textArea;

    public KeyListenerDemo() {
        super(new BorderLayout());
        textArea = new JTextArea(20, 40);
        JTextField textField = new JTextField();
        JButton cancella = new JButton("Cancella");
        super.add(textField, BorderLayout.NORTH);
        super.add(new JScrollPane(textArea), BorderLayout.CENTER);
        super.add(cancella, BorderLayout.SOUTH);
        textField.addKeyListener(this);


        cancella.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                textArea.setText("");
            }
        });
    }
        
    public void keyTyped(KeyEvent e) {
        textArea.append("KEYTYPED -> KeyChar : " + e.getKeyChar() +
                        "  KeyCode : " + e.getKeyCode() + "\n");
    }

    public void keyPressed(KeyEvent e) {
        textArea.append("KEYPRESSED -> KeyChar : " + e.getKeyChar() +
                        "  KeyCode : " + e.getKeyCode() + "\n");
    }

    public void keyReleased(KeyEvent e) {
        textArea.append("KEYRELEASED -> KeyChar : " + e.getKeyChar() +
                        "  KeyCode : " + e.getKeyCode() + "\n");
    }
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("KeyListener Demo");
        frame.getContentPane().add(new KeyListenerDemo());
        frame.pack();
        frame.setVisible(true);
    }
}