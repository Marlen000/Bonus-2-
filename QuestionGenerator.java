import java.util.Random;

public class QuestionGenerator {
    private final Random random;

    public QuestionGenerator() {
        this.random = new Random();
    }

    public String generateQuestion(int[] correctAnswer) {
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        int operation = random.nextInt(4);
        String question = "";

        switch (operation) {
            case 0 -> {
                question = a + " + " + b;
                correctAnswer[0] = a + b;
            }
            case 1 -> {
                question = a + " - " + b;
                correctAnswer[0] = a - b;
            }
            case 2 -> {
                question = a + " * " + b;
                correctAnswer[0] = a * b;
            }
            case 3 -> {
                question = (a * b) + " / " + b;
                correctAnswer[0] = a;
            }
        }
        return question;
    }
}

