package com.bookvillage.backend.domain.chat.dto;

import java.util.List;

public record ChatCompletionReq(
        String model,
        List<ChatMessage> messages,
        double temperature
) {
}
