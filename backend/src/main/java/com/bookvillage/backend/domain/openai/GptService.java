package com.bookvillage.backend.domain.openai;

import com.bookvillage.backend.domain.chat.dto.ChatCompletionReq;
import com.bookvillage.backend.domain.chat.dto.ChatCompletionRes;
import com.bookvillage.backend.domain.chat.dto.UserInput;
import org.springframework.http.ResponseEntity;

public interface GptService {
    public ResponseEntity<String> callOpenAI(UserInput userInput);
    public String generatePrompt(ChatCompletionReq chatReq);
}
