import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Stopwatch extends JFrame implements ActionListener {
    private JLabel timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
    private JButton start = new JButton("Start"), pause = new JButton("Pause"), stop = new JButton("Stop");
    private Timer timer = new Timer(1000, e -> updateTimer());
    private int elapsedTime = 0;
    private boolean isRunning = false;

    public Stopwatch() {
        setTitle("Stopwatch");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(timeLabel);
        
        JPanel panel = new JPanel();
        for (JButton btn : new JButton[]{start, pause, stop}) {
            btn.addActionListener(this);
            panel.add(btn);
        }
        add(panel);
    }

    private void updateTimer() {
        elapsedTime++; // Increment elapsed time before formatting
        timeLabel.setText(String.format("%02d:%02d:%02d", elapsedTime / 3600, (elapsedTime % 3600) / 60, elapsedTime % 60));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start && !isRunning) {
            timer.start();
            isRunning = true; // Set isRunning to true immediately
        } else if (e.getSource() == pause && isRunning) {
            timer.stop();
            isRunning = false; // Set isRunning to false when paused
        } else if (e.getSource() == stop) {
            timer.stop();
            elapsedTime = 0;
            timeLabel.setText("00:00:00");
            isRunning = false; // Reset isRunning when stopped
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Stopwatch().setVisible(true));
    }
}
