package org.example.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;
@Schema(description = "WaypointDTO")
public class WaypointDTO {
    private UUID id;
    @NotNull(message = "Широта не может быть нулевой")
    private double latitude;
    @NotNull(message = "Долгота не может быть нулевой")
    private double longitude;
    @Min(value = 0, message = "Высота над уровнем моря должна быть положительным числом")
    private int altitude;

    public WaypointDTO(UUID id, double latitude, double longitude, int altitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public WaypointDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
