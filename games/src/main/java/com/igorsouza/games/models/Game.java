package com.igorsouza.games.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Size(min = 2, max = 50, message = "O nome deve conter pelo menos 2 e no máximo 50 caracteres")
    @NotBlank()
    @Column(name = "name", nullable = false)
    private String name;

    @Size(min = 10, max = 500, message = "A descrição deve conter pelo menos 10 e no máximo 500 caracteres")
    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;
}
