package com.bookvillage.backend.domain.chat.dto;

import java.util.List;

public record ChatCompletionRes(
        String id,
        String object,
        long created,
        List<Choice> choices,
        Usage usage
) {
    public record Choice(
            int index,
            ChatMessage message,
            String finish_reason
    ) {}

    public record Usage(
            int prompt_tokens,
            int completion_tokens,
            int total_tokens
    ) {}
}
