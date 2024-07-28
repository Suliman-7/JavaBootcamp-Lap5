package com.example.event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Event {

    private String id ;
    private String description ;
    private int capacity ;
    private String startDate ;
    private String endDate ;
}
