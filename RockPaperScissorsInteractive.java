import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class RockPaperScissorsInteractive {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Rock Paper Scissors Game");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create panels for better layout management
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        // Set layout managers
        topPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(2, 2, 10, 10)); // for buttons and user name
        bottomPanel.setLayout(new BorderLayout());

        // Create components
        JLabel promptLabel = new JLabel("Enter your name: ");
        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");

        JTextArea resultArea = new JTextArea(6, 25);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 18));
        resultArea.setBackground(Color.LIGHT_GRAY);
        resultArea.setForeground(Color.DARK_GRAY);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add components to panels
        topPanel.add(promptLabel);
        topPanel.add(nameField);
        
        centerPanel.add(rockButton);
        centerPanel.add(paperButton);
        centerPanel.add(scissorsButton);
        
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Add panels to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        // Action listeners for buttons
        rockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playGame(0, nameField.getText(), resultArea);
            }
        });
        paperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playGame(1, nameField.getText(), resultArea);
            }
        });
        scissorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playGame(2, nameField.getText(), resultArea);
            }
        });
        
        // Show the frame
        frame.setVisible(true);
    }

    public static void playGame(int userChoice, String userName, JTextArea resultArea) {
        // Declare variables
        int computerChoice;
        Random rnd = new Random();

        // Assigning values
        int rock = 0;
        int paper = 1;
        int scissors = 2;
        
        // Array for choices
        String[] choices = {"Rock", "Paper", "Scissors"};
        
        // Generate computer's choice
        computerChoice = rnd.nextInt(3);
        
        // Display user and computer choices
        resultArea.setText(userName + " chose: " + choices[userChoice] + "\n");
        resultArea.append("Computer chose: " + choices[computerChoice] + "\n");

        // Check the result
        if (userChoice == computerChoice) {
            resultArea.append("It's a Draw! Try again.\n");
            resultArea.setBackground(Color.YELLOW);  // Change background for draw
        } else if ((userChoice == rock && computerChoice == scissors) ||
                   (userChoice == paper && computerChoice == rock) ||
                   (userChoice == scissors && computerChoice == paper)) {
            resultArea.append(userName + " Wins!\n");
            resultArea.setBackground(Color.GREEN);  // Green for user win
        } else {
            resultArea.append("Computer Wins!\n");
            resultArea.setBackground(Color.RED);  // Red for computer win
        }
    }
}
