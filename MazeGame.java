public class MazeGame extends Game {
    private int position;
    private final QuestionGenerator questionGenerator;

    public MazeGame(int attempts) {
        super(attempts);
        this.position = 0;
        this.questionGenerator = new QuestionGenerator();
    }

    @Override
    public void play() {
        System.out.println("Добро пожаловать в игру-лабиринт!");
        System.out.println("У вас есть " + attempts + " попыток.");

        while (hasAttemptsLeft()) {
            int[] correctAnswer = new int[1];
            String question = questionGenerator.generateQuestion(correctAnswer);

            System.out.println("Решите: " + question + " = ?");
            int answer = scanner.nextInt();

            if (answer == correctAnswer[0]) {
                correctStreak++;
                position++;
                System.out.println("Правильно! Вы двигаетесь вправо.");
                if (correctStreak == 5) {
                    System.out.println("Поздравляем! Вы выиграли!");
                    return;
                }
            } else {
                resetStreak();
                position--;
                System.out.println("Неправильно! Вы двигаетесь влево.");
            }

            decrementAttempts();
            System.out.println("Оставшиеся попытки: " + attempts);
            System.out.println("Текущая позиция: " + position);
        }

        System.out.println("Игра окончена. Вы проиграли.");
        System.out.println("Конечная позиция: " + position);
    }
}

