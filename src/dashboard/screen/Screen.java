
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Screen extends JFrame implements ActionListener {
    private JButton jButton;
    private Timer timer;
    private int scaleStep = 0;

    public Screen() {
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        setLayout(null);


        jButton = new JButton("BAKER");
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(Color.BLACK);
        jButton.setBackground(Color.RED);
        setButtonPosition();
        add(jButton);

        jButton.addActionListener(this);

        setVisible(true);
    }
    private void setButtonPosition() {
        int buttonWidth = (int) (getWidth() * 0.3);
        int buttonHeight = (int) (getHeight() * 0.3);
        jButton.setBounds((getWidth() - buttonWidth) / 2, (getHeight() - buttonHeight) / 2, buttonWidth, buttonHeight);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer = new Timer(30, new ActionListener() {
            private boolean enlarging = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (enlarging) {
                    jButton.setBounds(jButton.getX() - 2, jButton.getY() - 2, jButton.getWidth() + 4, jButton.getHeight() + 4);
                    scaleStep++;
                    if (scaleStep >= 10) {
                        enlarging = false;
                    }
                } else {
                    jButton.setBounds(jButton.getX() + 2, jButton.getY() + 2, jButton.getWidth() - 4, jButton.getHeight() - 4);
                    scaleStep--;
                    if (scaleStep <= 0) {
                        timer.stop();
                        try {
                            Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=T-64_HO5bJo"));
                        } catch (IOException | URISyntaxException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        timer.start();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setButtonPosition();
    }
}
