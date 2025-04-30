package hello;

import java.net.*;

class Machine {
    @JsonProperty("machineID")
    private String id;
    @JsonProperty("timestamp")
    private long timestamp;
    @JsonProperty("resourcesHeld")
    private List<String> resourcesHeld;
    @JsonProperty("waitingOn")
    private String waitingOn;

    public Machine(String id, long timestamp, List<String> resourcesHeld, String waitingOn) {
        this.id = id;
        this.timestamp = timestamp;
        this.resourcesHeld = resourcesHeld;
        this.waitingOn = waitingOn;
    }

    public String toString() {
        return this.id + "\n" + this.timestamp + "\n" + this.resourcesHeld + "\n" + this.waitingOn;
    }
}
