import java.awt.BorderLayout;      // Import for BorderLayout manager, used to arrange components.
import java.awt.Color;             // Import for Color class to set colors.
import java.awt.Font;              // Import for Font class to set fonts.
import java.awt.event.ActionEvent; // Import for ActionEvent class, used in the Timer.
import java.awt.event.ActionListener; // Import for ActionListener interface, used to handle action events.
import java.text.SimpleDateFormat; // Import for SimpleDateFormat class to format date and time.
import java.util.Calendar;         // Import for Calendar class to get the current date and time.
import javax.swing.BorderFactory;  // Import for BorderFactory class to create borders.
import javax.swing.JFrame;         // Import for JFrame class to create the main window.
import javax.swing.JLabel;         // Import for JLabel class to create labels for displaying text.
import javax.swing.JPanel;         // Import for JPanel class to create panels.
import javax.swing.SwingConstants; // Import for SwingConstants class to set alignment constants.
import javax.swing.Timer;          // Import for Timer class to create a timer to update the clock.

public class Digitalclock extends JFrame { // Class definition extending JFrame to create a window.

    private JLabel timeLabel;      // Label to display the current time.
    private JLabel dateLabel;      // Label to display the current date.

    public Digitalclock() {        // Constructor for Digitalclock class.
        setTitle("Digital Clock"); // Set the title of the window.
        setSize(500, 200);         // Set the size of the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation.
        setResizable(false);       // Prevent the window from being resizable.

        // Create a panel to hold the time and date labels
        JPanel panel = new JPanel(); // Create a new JPanel.
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Set an empty border around the panel.
        panel.setLayout(new BorderLayout()); // Set the layout manager for the panel to BorderLayout.

        // Create a label to display the time
        timeLabel = new JLabel();  // Create a new JLabel for time.
        timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 60)); // Set the font of the time label.
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text horizontally.
        timeLabel.setVerticalAlignment(SwingConstants.CENTER); // Center-align the text vertically.
        timeLabel.setForeground(Color.RED); // Set the text color to red.

        // Create a label to display the date
        dateLabel = new JLabel();  // Create a new JLabel for date.
        dateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // Set the font of the date label.
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center-align the text horizontally.
        dateLabel.setVerticalAlignment(SwingConstants.CENTER); // Center-align the text vertically.
        dateLabel.setForeground(Color.WHITE); // Set the text color to white.

        // Add the time and date labels to the panel
        panel.add(timeLabel, BorderLayout.CENTER); // Add the time label to the center of the panel.
        panel.add(dateLabel, BorderLayout.SOUTH); // Add the date label to the bottom of the panel.

        // Set the panel's background color
        panel.setBackground(Color.BLACK); // Set the background color of the panel to black.

        // Add the panel to the frame
        add(panel); // Add the panel to the JFrame.

        // Use a Timer to update the time and date labels every second
        Timer timer = new Timer(1000, new ActionListener() { // Create a new Timer that triggers every second.
            @Override
            public void actionPerformed(ActionEvent e) { // Define the action to be performed on each tick.
                updateTimeAndDate(); // Call the method to update time and date.
            }
        });
        timer.start(); // Start the timer.
    }

    private void updateTimeAndDate() { // Method to update the time and date labels.
        // Get the current time and format it
        Calendar calendar = Calendar.getInstance(); // Get the current date and time.
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss"); // Create a formatter for the time.
        String time = timeFormatter.format(calendar.getTime()); // Format the current time.

        // Get the current date and format it
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE, MMM dd, yyyy"); // Create a formatter for the date.
        String date = dateFormatter.format(calendar.getTime()); // Format the current date.

        // Update the time and date labels
        timeLabel.setText(time); // Set the formatted time to the time label.
        dateLabel.setText(date); // Set the formatted date to the date label.
    }

    public static void main(String[] args) { // Main method to run the application.
        Digitalclock clock = new Digitalclock(); // Create an instance of Digitalclock.
        clock.setVisible(true); // Make the window visible.
    }
}
