package org.example.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.dtos.enums.FlightStatus;

import java.util.List;
import java.util.UUID;
@Schema(description = "FlightPlanDTO")
public class FlightPlanDTO {
    private UUID id;
    @NotNull(message = "Номер рейса не может быть пустым")
    @Size(min = 1, max = 10, message = "Номер рейса должен содержать от 1 до 10 символов")
    private String flightNumber;
    @NotNull(message = "Авиакомпания не может быть нулевой")
    @Size(min = 1, max = 100, message = "Название авиакомпании должно содержать от 1 до 100 символов")
    private String airline;
    @NotNull(message = "Идентификатор пилота не может быть пустым")
    private UUID pilotId;
    @NotNull(message = "Маршрут не может быть нулевым")
    private List<WaypointDTO> route;
    private int altitude;
    @NotBlank
    @NotNull(message = "Время отправления не может быть нулевым")
    private String  departureTime;
    @NotNull(message = "Время прибытия не может быть нулевым")
    private String  arrivalTime;
    @NotNull(message = "Статус не может быть нулевым")
    private FlightStatus status;
    private List<UUID> airspaceAuthorityIds;
    @NotNull(message = "Идентификатор подтверждения не может быть пустым")
    private UUID approvalId;

    public FlightPlanDTO(UUID id, String flightNumber, String airline, UUID pilotId, List<WaypointDTO> route, int altitude, String  departureTime, String  arrivalTime, FlightStatus status, List<UUID> airspaceAuthorityIds, UUID approvalId) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.pilotId = pilotId;
        this.route = route;
        this.altitude = altitude;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.airspaceAuthorityIds = airspaceAuthorityIds;
        this.approvalId = approvalId;
    }

    public FlightPlanDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public UUID getPilotId() {
        return pilotId;
    }

    public void setPilotId(UUID pilotId) {
        this.pilotId = pilotId;
    }

    public List<WaypointDTO> getRoute() {
        return route;
    }

    public void setRoute(List<WaypointDTO> route) {
        this.route = route;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public String  getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String  departureTime) {
        this.departureTime = departureTime;
    }

    public String  getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String  arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public List<UUID> getAirspaceAuthorityIds() {
        return airspaceAuthorityIds;
    }

    public void setAirspaceAuthorityIds(List<UUID> airspaceAuthorityIds) {
        this.airspaceAuthorityIds = airspaceAuthorityIds;
    }

    public UUID getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(UUID approvalId) {
        this.approvalId = approvalId;
    }
}
