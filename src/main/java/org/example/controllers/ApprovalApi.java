package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.dtos.ApprovalDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Schema(name = "Approval API", description = "API for managing approval statuses")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successful operation",content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApprovalDTO.class))),
        @ApiResponse(responseCode = "201", description = "A new resource has been created",content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApprovalDTO.class))),
        @ApiResponse(responseCode = "204", description = "The resource was successfully deleted",content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApprovalDTO.class))),
        @ApiResponse(responseCode = "400", description = "Validation error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApprovalDTO.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found",content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApprovalDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error",content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApprovalDTO.class)))
})
public interface ApprovalApi {

    @PostMapping
    @Operation(summary = "Create a new Approval")
    ResponseEntity<EntityModel<ApprovalDTO>> createApproval(@RequestBody ApprovalDTO approvalDTO);

    @GetMapping
    @Operation(summary = "Get a list of all Approval")
    ResponseEntity<CollectionModel<EntityModel<ApprovalDTO>>> getAllApprovals();

    @GetMapping("/{id}")
    @Operation(summary = "Get Approval by ID")
    ResponseEntity<EntityModel<ApprovalDTO>> getApproval(@PathVariable UUID id);

    @PutMapping("/{id}")
    @Operation(summary = "Update Approval by ID")
    ResponseEntity<EntityModel<ApprovalDTO>> updateApproval(@PathVariable UUID id, @RequestBody ApprovalDTO approvalDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Approval by ID")
    ResponseEntity<Void> deleteApproval(@PathVariable UUID id);
}
