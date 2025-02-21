import javax.swing.*;

public class GUI {
    public static void drawTarget() {
        // Create the JFrame
        JFrame frame = new JFrame("Target Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 625);

        // Create a scoreboard and target panel
        ScoreBoard scoreBoard = new ScoreBoard();
        TargetPanel targetPanel = new TargetPanel(scoreBoard);

        // Add components to the frame
        frame.setLayout(null); // Use absolute layout
        targetPanel.setBounds(0, 0, 600, 550); // Target panel (top portion)
        scoreBoard.setBounds(0, 550, 600, 50); // Scoreboard (bottom portion)

        frame.add(targetPanel);
        frame.add(scoreBoard);

        // Make frame visible
        frame.setVisible(true);
    }
}