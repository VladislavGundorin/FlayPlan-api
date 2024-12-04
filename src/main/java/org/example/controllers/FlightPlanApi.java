package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.dtos.FlightPlanDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Schema(name = "Flight Plan API", description = "API for managing flight plans")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Operation successful",content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightPlanDTO.class))),
        @ApiResponse(responseCode = "201", description = "Resource created successfully",content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightPlanDTO.class))),
        @ApiResponse(responseCode = "204", description = "Resource deleted successfully",content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightPlanDTO.class))),
        @ApiResponse(responseCode = "400", description = "Validation error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightPlanDTO.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found",content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightPlanDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = FlightPlanDTO.class)))
})
public interface FlightPlanApi {

    @PostMapping("/create")
    @Operation(summary = "Creates a new FlightPlan.")
    ResponseEntity<EntityModel<FlightPlanDTO>> createFlightPlan(@RequestBody FlightPlanDTO flightPlanDTO);

    @GetMapping("/{id}")
    @Operation(summary = "Fetches FlightPlan by ID.")
    ResponseEntity<EntityModel<FlightPlanDTO>> getFlightPlan(@PathVariable UUID id);

    @GetMapping
    @Operation(summary = "Get all FlightPlan.")
    ResponseEntity<RepresentationModel<?>> getAllFlightPlans();

    @PutMapping("/{id}")
    @Operation(summary = "Updates FlightPlan by ID.")
    ResponseEntity<EntityModel<FlightPlanDTO>> updateFlightPlan(@PathVariable UUID id, @RequestBody FlightPlanDTO flightPlanDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes FlightPlan by ID.")
    ResponseEntity<Void> deleteFlightPlan(@PathVariable UUID id);
}
