package com.exercise.reposcanms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "branches")
public class Branch {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "repo_id")
    private Repo repo;

    @OneToMany(mappedBy = "branch")
    private List<Scan> scans;
}
