package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.dtos.PilotDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Schema(name = "Pilot API", description = "API for managing pilots")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Operation successful",content = @Content(mediaType = "application/json", schema = @Schema(implementation = PilotDTO.class))),
        @ApiResponse(responseCode = "201", description = "Resource created successfully",content = @Content(mediaType = "application/json", schema = @Schema(implementation = PilotDTO.class))),
        @ApiResponse(responseCode = "204", description = "Resource deleted successfully",content = @Content(mediaType = "application/json", schema = @Schema(implementation = PilotDTO.class))),
        @ApiResponse(responseCode = "400", description = "Validation error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = PilotDTO.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found",content = @Content(mediaType = "application/json", schema = @Schema(implementation = PilotDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = PilotDTO.class)))
})
public interface PilotApi {

    @PostMapping
    @Operation(summary = "Create a new pilot", description = "Creates a new pilot and returns the created resource with links.")
    ResponseEntity<EntityModel<PilotDTO>> createPilot(@RequestBody @Valid PilotDTO pilotDTO);

    @GetMapping("/{id}")
    @Operation(summary = "Get pilot by ID", description = "Fetches a specific pilot by its unique ID.")
    ResponseEntity<EntityModel<PilotDTO>> getPilot(@PathVariable @Valid UUID id);

    @GetMapping
    @Operation(summary = "Get all pilots", description = "Retrieves a collection of all available pilots.")
    ResponseEntity<RepresentationModel<?>> getAllPilots();

    @PutMapping("/{id}")
    @Operation(summary = "Update a pilot", description = "Updates the details of an existing pilot by its ID.")
    ResponseEntity<EntityModel<PilotDTO>> updatePilot(@PathVariable UUID id, @RequestBody @Valid PilotDTO pilotDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a pilot", description = "Deletes a pilot by its unique ID.")
    ResponseEntity<Void> deletePilot(@PathVariable UUID id);
}
