package com.bookvillage.backend.domain.book.dto;

public record BookRes(String title,
                      String author,
                      String publisher,
                      String contents,
                      String category,
                      String img) {
}
