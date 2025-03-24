import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class stopwatch extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private Timer timer;
    private long startTime = 0;
    private long elapsedTime = 0;
    private boolean running = false;
    
    public stopwatch() {
        // Set up the frame
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Create the time display label
        timeLabel = new JLabel("00:00:00.000");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setForeground(Color.BLUE);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        // Create and set up buttons
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        
        stopButton.setEnabled(false);
        
        // Add action listeners to buttons
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });
        
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
        
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
        
        // Add buttons to panel
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        
        // Set up the layout
        setLayout(new BorderLayout());
        add(timeLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Create the timer (updates every 10 milliseconds)
        timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        });
    }
    
    private void start() {
        if (!running) {
            startTime = System.currentTimeMillis() - elapsedTime;
            timer.start();
            running = true;
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
        }
    }
    
    private void stop() {
        if (running) {
            timer.stop();
            elapsedTime = System.currentTimeMillis() - startTime;
            running = false;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }
    
    private void reset() {
        timer.stop();
        elapsedTime = 0;
        running = false;
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        updateDisplay();
    }
    
    private void updateDisplay() {
        long currentTime = running ? (System.currentTimeMillis() - startTime) : elapsedTime;
        
        // Format the time
        long hours = TimeUnit.MILLISECONDS.toHours(currentTime);
        currentTime -= TimeUnit.HOURS.toMillis(hours);
        
        long minutes = TimeUnit.MILLISECONDS.toMinutes(currentTime);
        currentTime -= TimeUnit.MINUTES.toMillis(minutes);
        
        long seconds = TimeUnit.MILLISECONDS.toSeconds(currentTime);
        currentTime -= TimeUnit.SECONDS.toMillis(seconds);
        
        long milliseconds = currentTime;
        
        timeLabel.setText(String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds));
    }
    
    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new stopwatch().setVisible(true);
            }
        });
    }
}