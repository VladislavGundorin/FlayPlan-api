package org.example.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Schema(description = "AirspaceAuthorityDTO")
public class AirspaceAuthorityDTO {
    private UUID id;

    @NotNull(message = "Имя не может быть пустым")
    @Size(min = 1, max = 100, message = "Длина имени должна составлять от 1 до 100 символов")
    private String name;

    @NotNull(message = "Область не может быть нулевой")
    @Size(min = 2, max = 3, message = "Регион должен содержать от 2 до 3 символов")
    private String region;

    @NotNull(message = "Контактная информация не может быть пустой")
    @Email(message = "Контактной информацией должен быть действительный адрес электронной почты")
    private String contactInfo;

    public AirspaceAuthorityDTO(UUID id, String name, String region, String contactInfo) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.contactInfo = contactInfo;
    }

    public AirspaceAuthorityDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
