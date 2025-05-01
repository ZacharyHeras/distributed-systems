package com.example.springboot;

import java.net.*;
import java.util.*;
import com.fasterxml.jackson.annotation.*;

class Machine {
    private String id;
    private long timestamp;
    private List<String> resourcesHeld;
    private String waitingOn;

    public Machine(@JsonProperty("machineID") String id,
                   @JsonProperty("timestamp") long timestamp,
                   @JsonProperty("resourcesHeld") Object resourcesHeld,
                   @JsonProperty("waitingOn") String waitingOn) {
        this.id = id;
        this.timestamp = timestamp;

        if (resourcesHeld instanceof String) {
            this.resourcesHeld = new ArrayList<>();
        } else {
            this.resourcesHeld = (List<String>) resourcesHeld;
        }

        this.waitingOn = waitingOn;
    }

    public String toString() {
        return this.id + "\n" + this.timestamp + "\n" + this.resourcesHeld + "\n" + this.waitingOn + "\n";
    }
}
