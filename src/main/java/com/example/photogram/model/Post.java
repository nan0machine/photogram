package com.example.photogram.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private String description;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Photo> photos;
}
