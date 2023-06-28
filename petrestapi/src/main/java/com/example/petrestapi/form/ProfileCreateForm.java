package com.example.petrestapi.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ProfileCreateForm {
    @NotBlank(message = "名前は必須です")
    @Size(min = 1, max = 20, message = "名前は20文字以下で入力してください")
    private String name;
    private int age;
    private LocalDate dateOfBirth;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    // バリデーション例外処理
    public void validateName() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("名前は必須です");
        }
        if (name.length() > 20) {
            throw new IllegalArgumentException("名前は20文字以下で入力してください");
        }
    }
}
