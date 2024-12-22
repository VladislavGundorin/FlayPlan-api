package org.example.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;
@Schema(description = "PilotDTO")
public class PilotDTO {
    private UUID id;
    @NotBlank
    @NotNull(message = "Имя не может быть пустым")
    @Size(min = 1, max = 100, message = "Длина имени должна составлять от 1 до 100 символов")
    private String name;
    @NotNull(message = "Номер лицензии не может быть пустым")
    @Size(min = 1, max = 20, message = "Номер лицензии должен содержать от 1 до 20 символов")
    private String licenseNumber;
    @NotNull(message = "Контактная информация не может быть пустой")
    @Email(message = "Контактной информацией должен быть действительный адрес электронной почты")
    private String contactInfo;

    public PilotDTO(UUID id, String name, String licenseNumber, String contactInfo) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactInfo = contactInfo;
    }

    public PilotDTO() {
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
