package com.j25.trivia.model.api;

import lombok.Data;

import java.util.List;

@Data
public class TriviaResponse {
    private int response_code;
    private List<TriviaQuestion> results;
}
