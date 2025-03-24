import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class stopwatch extends JFrame {
    private JLabel timeLabel;
    private JButton startBtn, stopBtn, resetBtn;
    private Timer timer;
    private long startTime = 0;
    private long elapsedTime = 0;
    private boolean running = false;
    
    public stopwatch() {
        setTitle("Stopwatch");
        setSize(250, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        timeLabel = new JLabel("00:00:00");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel btnPanel = new JPanel();
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        resetBtn = new JButton("Reset");
        stopBtn.setEnabled(false);
        
        startBtn.addActionListener(e -> start());
        stopBtn.addActionListener(e -> stop());
        resetBtn.addActionListener(e -> reset());
        
        btnPanel.add(startBtn);
        btnPanel.add(stopBtn);
        btnPanel.add(resetBtn);
        
        setLayout(new BorderLayout());
        add(timeLabel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        
        timer = new Timer(10, e -> updateDisplay());
    }
    
    private void start() {
        startTime = System.currentTimeMillis() - elapsedTime;
        timer.start();
        running = true;
        startBtn.setEnabled(false);
        stopBtn.setEnabled(true);
    }
    
    private void stop() {
        timer.stop();
        elapsedTime = System.currentTimeMillis() - startTime;
        running = false;
        startBtn.setEnabled(true);
        stopBtn.setEnabled(false);
    }
    
    private void reset() {
        timer.stop();
        elapsedTime = 0;
        running = false;
        startBtn.setEnabled(true);
        stopBtn.setEnabled(false);
        timeLabel.setText("00:00:00");
    }
    
    private void updateDisplay() {
        long current = running ? (System.currentTimeMillis() - startTime) : elapsedTime;
        
        int hours = (int)(current / 3600000);
        int minutes = (int)((current % 3600000) / 60000);
        int seconds = (int)((current % 60000) / 1000);
        
        timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new stopwatch().setVisible(true));
    }
}