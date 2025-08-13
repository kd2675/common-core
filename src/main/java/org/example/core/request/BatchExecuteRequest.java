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
public class BatchExecuteRequest {
    private String jobType;           // HOTDEAL, COIN, MARKET 등
    private String source;            // server-batch
    private String priority;          // HIGH, MEDIUM, LOW
    private Map<String, Object> parameters;
    private LocalDateTime requestTime;
    private String callbackUrl;       // 완료 후 콜백 URL

    // 편의 메서드
    public static BatchExecuteRequest hotdeal() {
        return BatchExecuteRequest.builder()
                .jobType("HOTDEAL")
                .source("server-batch")
                .priority("MEDIUM")
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest coin() {
        return BatchExecuteRequest.builder()
                .jobType("COIN")
                .source("server-batch")
                .priority("HIGH")
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest market() {
        return BatchExecuteRequest.builder()
                .jobType("MARKET")
                .source("server-batch")
                .priority("LOW")
                .requestTime(LocalDateTime.now())
                .build();
    }
}

