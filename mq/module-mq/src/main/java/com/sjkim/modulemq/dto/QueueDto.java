package com.sjkim.modulemq.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class QueueDto {
    private String index;
    private String name;

    public QueueDto(String index, String name) {
        this.index = index;
        this.name = name;
    }
}
