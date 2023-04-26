package com.j25.trivia;

import com.j25.trivia.model.QuizCategory;
import com.j25.trivia.model.QuizDifficulty;
import com.j25.trivia.model.QuizParameters;
import com.j25.trivia.model.QuizType;

import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // api trivia
        APITriviaURLBuilder builder = new APITriviaURLBuilder();
        QuizParameters quizParameters = new QuizParameters();
        ScannerContentLoader scannerContentLoader = new ScannerContentLoader();

        scannerContentLoader.loadAmount(quizParameters);
        scannerContentLoader.loadCategory(quizParameters);
        scannerContentLoader.loadDifficulty(quizParameters);
        scannerContentLoader.loadType(quizParameters);

        builder.loadParameters(quizParameters);

        String requestURL = builder.compileURL();

        System.out.println(requestURL); //mój dodatek

        TriviaAPI api = new TriviaAPI();

        api.loadURLbyInputStream(requestURL).getResults().forEach(System.out::println);
    }
}
