import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {
    private int score;

    public ScoreBoard() {
        this.score = 0; 
    }

    public void addScore(int points) {
        this.score += points; 
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String scoreText = "Score: " + score;
        FontMetrics metrics = g.getFontMetrics();
        int scoreX = (getWidth() - metrics.stringWidth(scoreText)) / 2;
        int scoreY = (getHeight() + metrics.getAscent()) / 2 - 4; 
        g.drawString(scoreText, scoreX, scoreY);
    }
}