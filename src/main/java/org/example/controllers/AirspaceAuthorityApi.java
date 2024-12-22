package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.dtos.AirspaceAuthorityDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Schema(name = "Airspace Authority API")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successful operation",content = @Content(mediaType = "application/json", schema = @Schema(implementation = AirspaceAuthorityDTO.class))),
        @ApiResponse(responseCode = "400", description = "Validation error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = AirspaceAuthorityDTO.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found",content = @Content(mediaType = "application/json", schema = @Schema(implementation = AirspaceAuthorityDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = AirspaceAuthorityDTO.class)))
})
public interface AirspaceAuthorityApi {

    @PostMapping
    @Operation(summary = "Create a new AirspaceAuthority")
    ResponseEntity<EntityModel<AirspaceAuthorityDTO>> createAirspaceAuthority(@RequestBody @Valid AirspaceAuthorityDTO airspaceAuthorityDTO);

    @GetMapping("/{id}")
    @Operation(summary = "Get AirspaceAuthority by ID")
    ResponseEntity<EntityModel<AirspaceAuthorityDTO>> getAirspaceAuthority(@PathVariable UUID id);

    @GetMapping
    @Operation(summary = "Get a list of all AirspaceAuthority")
    ResponseEntity<CollectionModel<EntityModel<AirspaceAuthorityDTO>>> getAllAirspaceAuthorities();

    @PutMapping("/{id}")
    @Operation(summary = "Update AirspaceAuthority by ID")
    ResponseEntity<EntityModel<AirspaceAuthorityDTO>> updateAirspaceAuthority(@PathVariable UUID id, @RequestBody @Valid AirspaceAuthorityDTO airspaceAuthorityDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete AirspaceAuthority by ID")
    ResponseEntity<Void> deleteAirspaceAuthority(@PathVariable UUID id);
}
