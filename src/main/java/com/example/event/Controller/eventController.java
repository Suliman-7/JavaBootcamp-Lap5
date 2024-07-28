package com.example.event.Controller;


import com.example.event.Api.ApiResponse;
import com.example.event.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class eventController {

    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/events")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PostMapping("/post")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("event added successfully !", "200");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("event updated successfully !", "200");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("event deleted successfully !", "200");
    }

    @PutMapping("/changecapacity/{index}/{newcapacity}")
    public ApiResponse changeCapacity(@PathVariable int newcapacity, @PathVariable int index) {
        events.get(index).setCapacity(newcapacity);
        return new ApiResponse("event capacity changed successfully !", "200");
    }

    @GetMapping("search/{id}")
    public Event searchProject(@PathVariable String id) {
        for(Event event : events) {
            if(event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }






}
