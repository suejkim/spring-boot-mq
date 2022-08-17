package com.sjkim.modulemq.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
public class QueueDto { // implements Serializable {
    private String index;
    private String name;

    public QueueDto(String index, String name) {
        this.index = index;
        this.name = name;
    }
}
