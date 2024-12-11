import java.util.Scanner;

public abstract class Game {
    protected int attempts;
    protected int correctStreak;
    protected Scanner scanner;

    public Game(int attempts) {
        this.attempts = attempts;
        this.correctStreak = 0;
        this.scanner = new Scanner(System.in);
    }

    public abstract void play();

    protected void resetStreak() {
        correctStreak = 0;
    }

    protected void decrementAttempts() {
        attempts--;
    }

    protected boolean hasAttemptsLeft() {
        return attempts > 0;
    }
}
