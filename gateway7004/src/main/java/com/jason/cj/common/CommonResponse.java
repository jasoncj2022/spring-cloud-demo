package com.jason.cj.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jiancheng
 * @date 2022/7/8 11:11 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse<T> {
    private String code;

    private String message;

    private T data;
}
