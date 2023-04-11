import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessingGame extends JFrame implements ActionListener {

    private JPanel mainPanel, gamePanel, instructionsPanel;
    private JButton playButton, instructionsButton, backButton, quitButton, checkButton;
    private JTextField guessTextField;
    private JLabel guessLabel, resultLabel;
    private int randomNumber = 16;
    
    public GuessingGame() {
        super("Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 4));
        
        playButton = new JButton("Play");
        playButton.addActionListener(this);
        instructionsButton = new JButton("Instructions");
        instructionsButton.addActionListener(this);
        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        
        // Add buttons to main panel
        mainPanel.add(playButton);
        mainPanel.add(instructionsButton);
        mainPanel.add(quitButton);
        
        // Add main panel to frame
        add(mainPanel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == playButton) {
            JFrame gameFrame = new JFrame("Guessing Game - Play");
            gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
            JPanel gamePanel = new JPanel();
            gamePanel.setLayout(new GridLayout(3, 1));
    
            JLabel guessLabel = new JLabel("Guess a number between 1 and 100: ");
            JTextField guessTextField = new JTextField();
    
            JLabel resultLabel = new JLabel("");
    
            JButton checkButton = new JButton("Check");
            checkButton.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                String guessText = guessTextField.getText();
                try {
                    int guess = Integer.parseInt(guessText);
                    if (guess == randomNumber) {
                        resultLabel.setText("You got it!");
                    } 
                    else if (guess < randomNumber) {
                        resultLabel.setText("Too low!");
                    } 
                    else {
                        resultLabel.setText("Too high!");
                    }
                } 
                catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number.");
                }
            }
            });
    
            JButton backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameFrame.dispose();
                }
            });
    
            gamePanel.add(guessLabel);
            gamePanel.add(guessTextField);
            gamePanel.add(checkButton);
            gamePanel.add(backButton);
            gamePanel.add(resultLabel);
    
            gameFrame.getContentPane().add(gamePanel);
            gameFrame.pack();
            gameFrame.setLocationRelativeTo(null);
            gameFrame.setVisible(true);
    
        } 
        else if (event.getSource() == instructionsButton) {
            JFrame instructionsFrame = new JFrame("Guessing Game - Instructions");
            instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
            JPanel instructionsPanel = new JPanel();
            instructionsPanel.setLayout(new GridLayout(2, 1));
    
            // Instructions label and back button
            JLabel instructionsLabel = new JLabel("Guess a number between 1 and 100.");
            JButton backButton = new JButton("Back");
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    instructionsFrame.dispose();
                }
            });
    
            instructionsPanel.add(instructionsLabel);
            instructionsPanel.add(backButton);
    
            instructionsFrame.getContentPane().add(instructionsPanel);
            instructionsFrame.pack();
            instructionsFrame.setLocationRelativeTo(null);
            instructionsFrame.setVisible(true);
    
        } 
        else if (event.getSource() == quitButton) {
            dispose();
        }
    }
     public static void main(String[] args) {
        new GuessingGame();
    }
}
