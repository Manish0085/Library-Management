package com.example.ELibrary.Model;

import lombok.*;

import javax.persistence.*;

@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;



}
