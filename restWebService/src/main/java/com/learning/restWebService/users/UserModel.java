package com.learning.restWebService.users;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class UserModel {
    public int id;
    @Size(min = 2, message = "Name should have minimum 2 characters")
    public String name;
    @Past(message = "Date of birth should be in past")
    public LocalDate dob;
}
