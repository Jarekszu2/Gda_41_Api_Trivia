package com.j25.trivia;

import com.j25.trivia.model.QuizCategory;
import com.j25.trivia.model.QuizDifficulty;
import com.j25.trivia.model.QuizType;

public class APITriviaURLBuilder {
    private static final String BASE_URL = "https://opentdb.com/api.php?amount={amount}";

    private final StringBuilder builder;

    /**
     * Tworzę builder który jako początkowy URL ma link z góry.
     */
    public APITriviaURLBuilder() {
        builder = new StringBuilder(BASE_URL);
    }

    public void appendNumberOfQuestions(int count) {
        if (builder.toString().contains("{amount}")) {
            int pozycjaAmount = builder.indexOf("{amount}");
            builder.replace(pozycjaAmount, pozycjaAmount + 8, String.valueOf(count));
        }
    }

    public void appendCategory(QuizCategory quizCategory) {
        // quizCategory.getId() == -1 to wartość ANY
        if (!builder.toString().contains("&cateogry=") && quizCategory.getId() != -1) {
            builder.append("&category=");
            builder.append(quizCategory.getId());
        } else {
            System.err.println("Kategoria została już dopisana.");
        }
    }

    public void appendDifficulty(QuizDifficulty quizDifficulty) {
        // quizDifficulty.getId() == -1 to wartość ANY
        if (!builder.toString().contains("&difficulty=") && quizDifficulty != QuizDifficulty.ANY) {
            builder.append("&difficulty=");
            builder.append(quizDifficulty.toString().toLowerCase());
        } else {
            System.err.println("Poziom trudności został już ustawiony.");
        }
    }

    public void appendType(QuizType quizType) {
        // quizType.getId() == -1 to wartość ANY
        if (!builder.toString().contains("&type=") && quizType != QuizType.ANY) {
            builder.append("&type=");
            builder.append(quizType.toString().toLowerCase());
        } else {
            System.err.println("Rodzaj pytań został już określony.");
        }
    }

    @Override
    public String toString() {
        return "APITriviaURLBuilder{" +
                "builder=" + builder +
                '}';
    }
}
