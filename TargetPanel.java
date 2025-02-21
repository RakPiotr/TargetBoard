import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TargetPanel extends JPanel {
    private int targetRadius;
    private int numberOfRings;
    private ScoreBoard scoreBoard;

    public TargetPanel(ScoreBoard scoreBoard) {
        this.targetRadius = 150; // Fixed target size
        this.numberOfRings = 10; // 10 concentric circles
        this.scoreBoard = scoreBoard; // Reference to the scoreboard

        // Add a mouse listener to detect clicks
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e.getX(), e.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set background color
        this.setBackground(Color.WHITE);

        // Get dimensions and center point
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        // Draw concentric circles
        Graphics2D g2d = (Graphics2D) g;
        for (int i = numberOfRings; i > 0; i--) {
            int currentRadius = (targetRadius / numberOfRings) * i;
            if (i % 2 == 0) {
                g2d.setColor(Color.RED); // Alternate colors
            } else {
                g2d.setColor(Color.BLACK);
            }
            g2d.fillOval(centerX - currentRadius, centerY - currentRadius,
                    currentRadius * 2, currentRadius * 2);
        }
    }

    private void handleMouseClick(int x, int y) {
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
    
        // Calculate distance from the center
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
    
        // Determine which ring was clicked
        int ringPoints = 0; // Initialize points for the ring
        for (int i = 1; i <= numberOfRings; i++) { // Iterate from outermost (1) to innermost (10)
            int currentRadius = (targetRadius / numberOfRings) * i;
            if (distance <= currentRadius) {
                ringPoints = numberOfRings - i + 1; // Assign points: 10 for innermost, 1 for outermost
                break;
            }
        }
    
        // Update the score
        if (ringPoints > 0) {
            scoreBoard.addScore(ringPoints); // Add points to the scoreboard
        }
    }
}