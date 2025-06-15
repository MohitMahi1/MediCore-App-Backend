package com.mohit.MediCore.entities;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Data
public class TimeSlots {
    private String id;
    private DayOfWeek dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean available;
}
