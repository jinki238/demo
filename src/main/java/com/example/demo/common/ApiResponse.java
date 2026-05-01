package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private int code;        // 상태 코드 (200, 400 등)
    private String message;  // 메시지
    private T data;          // 실제 데이터
    private String writer;      //성공메시지

    // 성공 응답
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "SUCCESS", data,"shr");
    }

    // 성공 (메시지 포함)
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, message, data,"shr");
    }

    // 실패 응답
    public static <T> ApiResponse<T> fail(int code, String message) {
        return new ApiResponse<>(code, message, null,"shr");
    }
}