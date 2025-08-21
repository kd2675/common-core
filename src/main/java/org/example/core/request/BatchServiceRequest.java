package org.example.core.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchServiceRequest {
    private String jobType;           // HOTDEAL, COIN, MARKET 등
    private String source;            // server-batch
    private Priority priority;        // HIGH, MEDIUM, LOW
    private Map<String, Object> parameters;
    private LocalDateTime requestTime;
    private String callbackUrl;       // 완료 후 콜백 URL

    public static BatchServiceRequest account() {
        return BatchServiceRequest.builder()
                .jobType("account")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchServiceRequest check() {
        return BatchServiceRequest.builder()
                .jobType("check")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchServiceRequest buy() {
        return BatchServiceRequest.builder()
                .jobType("buy")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchServiceRequest reset() {
        return BatchServiceRequest.builder()
                .jobType("reset")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchServiceRequest saveCoinDataBTC() {
        return BatchServiceRequest.builder()
                .jobType("saveCoinDataBTC")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchServiceRequest logCacheStats() {
        return BatchServiceRequest.builder()
                .jobType("logCacheStats")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }
}

