package hello;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String make;
    private String model;
    private int year;

    @JsonCreator
    public Car(@JsonProperty("make") String make, @JsonProperty("model") String model, @JsonProperty("year") int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String toString() {
        return make + model + year;
    }
}
