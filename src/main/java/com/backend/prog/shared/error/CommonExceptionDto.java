package com.backend.prog.shared.error;

import lombok.Builder;

@Builder
public record CommonExceptionDto(String errorCode, String errorMessage) {

}
