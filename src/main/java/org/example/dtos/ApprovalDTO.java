package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.dtos.enums.ApprovalStatus;


import java.time.LocalDateTime;
import java.util.UUID;
@Schema(description = "Approval DTO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApprovalDTO {
    private UUID id;
    @NotNull(message = "Идентификатор авторизации не может быть пустым")
    private UUID authorityId;
    @NotNull(message = "Статус не может быть нулевым")
    private ApprovalStatus status;
    @NotNull(message = "Одобрено не может быть нулевым")
    @Size(min = 1, max = 100, message = "Одобрено должно содержать от 1 до 100 символов")
    private String approvedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    private LocalDateTime approvedAt;
    @Size(max = 500, message = "Объем комментариев не должен превышать 500 символов")
    private String comments;

    public ApprovalDTO(UUID id, UUID authorityId, ApprovalStatus status, String approvedBy, LocalDateTime approvedAt, String comments) {
        this.id = id;
        this.authorityId = authorityId;
        this.status = status;
        this.approvedBy = approvedBy;
        this.approvedAt = approvedAt;
        this.comments = comments;
    }

    public ApprovalDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(UUID authorityId) {
        this.authorityId = authorityId;
    }

    public ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(ApprovalStatus status) {
        this.status = status;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "ApprovalDTO{" +
                "id=" + id +
                ", authorityId=" + authorityId +
                ", status=" + status +
                ", approvedBy='" + approvedBy + '\'' +
                ", approvedAt=" + approvedAt +
                ", comments='" + comments + '\'' +
                '}';
    }
}
