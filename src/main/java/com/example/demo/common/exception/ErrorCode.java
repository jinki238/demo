package com.example.demo.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    MEMBER_NOT_FOUND(404, "회원이 없습니다"),
    INVALID_REQUEST(400, "잘못된 요청입니다"),
    INTERNAL_SERVER_ERROR(500, "서버 내부 오류");

    private final int code;
    private final String message;
}