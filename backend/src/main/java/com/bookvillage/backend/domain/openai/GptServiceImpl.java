package com.bookvillage.backend.domain.openai;

import com.bookvillage.backend.domain.chat.dto.ChatCompletionReq;
import com.bookvillage.backend.domain.chat.dto.ChatCompletionRes;
import com.bookvillage.backend.domain.chat.dto.ChatMessage;
import com.bookvillage.backend.domain.chat.dto.UserInput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GptServiceImpl implements GptService {
    private final RestTemplate restTemplate;
    private final HttpHeaders headersForGpt;

    @Value("${openai.model}")
    private String openaiModel;

    @Value("${openai.default-prompt}")
    private String defaultPrompt;

    @Override
    public ResponseEntity<String> callOpenAI(UserInput userInput){
        ChatCompletionReq requestBody = new ChatCompletionReq(
                openaiModel,
                List.of(new ChatMessage("user", userInput.userInput())),
                0.7
        );

        HttpEntity<ChatCompletionReq> reqHttpEntity = new HttpEntity<>(requestBody, headersForGpt);

        String url = "https://api.openai.com/v1/chat/completions";
        ResponseEntity<ChatCompletionRes> responseEntity =
                restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        reqHttpEntity,
                        ChatCompletionRes.class
                );

        ChatCompletionRes response = responseEntity.getBody();

        System.out.println("\n\n");
        System.out.println(response);
        System.out.println("\n\n");

        if (response != null || response.choices() == null || response.choices().isEmpty()) {
            return new ResponseEntity<>("No response from ChatGPT", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response.choices().get(0).message().content(), HttpStatus.OK);
    }

    @Override
    public String generatePrompt(ChatCompletionReq chatReq){
        return "";
    }
}
