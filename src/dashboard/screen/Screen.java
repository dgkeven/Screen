package dashboard.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Screen extends JFrame implements ActionListener {
    private final JButton jButton;
    private final Timer timer;
    private int scaleStep = 0;
    private boolean enlarging = true;

    public Screen() {
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Layout mais flexível
        setLayout(new GridBagLayout());

        jButton = new JButton("BAKER");
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(Color.BLACK);
        jButton.setBackground(Color.RED);
        jButton.addActionListener(this);

        add(jButton);

        // Timer otimizado para animação
        timer = new Timer(30, e -> animateButton());

        setVisible(true);
    }

    private void animateButton() {
        if (enlarging) {
            jButton.setPreferredSize(new Dimension(jButton.getWidth() + 4, jButton.getHeight() + 4));
            scaleStep++;
            if (scaleStep >= 10) enlarging = false;
        } else {
            jButton.setPreferredSize(new Dimension(jButton.getWidth() - 4, jButton.getHeight() - 4));
            scaleStep--;
            if (scaleStep <= 0) {
                timer.stop();
                openLink("https://www.youtube.com/watch?v=T-64_HO5bJo");
            }
        }
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        scaleStep = 0;
        enlarging = true;
        timer.start();
    }

    private void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Screen::new);
    }
}
