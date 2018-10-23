package com.amaris.futbol.domain;

import com.amaris.futbol.interfaces.IEvent;

import java.time.LocalDateTime;

public abstract class Event extends BaseEntity implements IEvent {

    LocalDateTime startTime;
    LocalDateTime endTime;

}
