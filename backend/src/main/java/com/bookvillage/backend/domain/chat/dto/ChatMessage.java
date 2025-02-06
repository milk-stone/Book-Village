package com.bookvillage.backend.domain.chat.dto;

public record ChatMessage(
        String role,
        String content
) {
}
