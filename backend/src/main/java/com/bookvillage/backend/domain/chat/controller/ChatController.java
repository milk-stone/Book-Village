package com.bookvillage.backend.domain.chat.controller;

import com.bookvillage.backend.domain.chat.dto.ChatCompletionReq;
import com.bookvillage.backend.domain.chat.dto.ChatCompletionRes;
import com.bookvillage.backend.domain.chat.dto.UserInput;
import com.bookvillage.backend.domain.openai.GptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/chat")
public class ChatController {
    private final GptService gptService;

    @PostMapping("/input")
    public ResponseEntity<String> chat(@RequestBody UserInput userInput) {
        return gptService.callOpenAI(userInput);
    }
}