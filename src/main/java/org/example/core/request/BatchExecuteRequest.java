package org.example.core.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchExecuteRequest {
    private String jobType;           // HOTDEAL, COIN, MARKET 등
    private String source;            // server-batch
    private Priority priority;        // HIGH, MEDIUM, LOW
    private Map<String, Object> parameters;
    private LocalDateTime requestTime;
    private String callbackUrl;       // 완료 후 콜백 URL

    public static BatchExecuteRequest insHotdealJob() {
        return BatchExecuteRequest.builder()
                .jobType("insHotdealJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest sendHotdealJob() {
        return BatchExecuteRequest.builder()
                .jobType("sendHotdealJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest delSentHotdealHob() {
        return BatchExecuteRequest.builder()
                .jobType("delSentHotdealHob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest delHotdealHob() {
        return BatchExecuteRequest.builder()
                .jobType("delHotdealHob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest updOrderJob() {
        return BatchExecuteRequest.builder()
                .jobType("updOrderJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest insNewsJob() {
        return BatchExecuteRequest.builder()
                .jobType("insNewsJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest sendNewsJob() {
        return BatchExecuteRequest.builder()
                .jobType("sendNewsJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest sendNewsFlashJob() {
        return BatchExecuteRequest.builder()
                .jobType("sendNewsFlashJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest sendNewsMarketingJob() {
        return BatchExecuteRequest.builder()
                .jobType("sendNewsMarketingJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest sendNewsStockJob() {
        return BatchExecuteRequest.builder()
                .jobType("sendNewsStockJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest delNewsJob() {
        return BatchExecuteRequest.builder()
                .jobType("delNewsJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest delCoinJob() {
        return BatchExecuteRequest.builder()
                .jobType("delCoinJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static BatchExecuteRequest sendCoinJob() {
        return BatchExecuteRequest.builder()
                .jobType("sendCoinJob")
                .source("server-batch")
                .priority(Priority.MEDIUM)
                .requestTime(LocalDateTime.now())
                .build();
    }
}

