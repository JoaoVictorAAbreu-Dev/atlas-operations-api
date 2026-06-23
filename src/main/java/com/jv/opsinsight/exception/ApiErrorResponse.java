package com.jv.opsinsight.exception;

import java.time.Instant;

public record ApiErrorResponse(Instant timestamp, int status, String error, String message, String path) {}
