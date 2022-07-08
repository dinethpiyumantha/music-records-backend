package com.adl.timeschedulemanagement.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Set;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(name = "artist_album",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    private Set<Album> albums;

    public void log() {
        System.out.println(
                "\nid = " + id +
                        "\nname = " + name +
                        "\nalbums_size = " + albums.size() +
                        "\n"
        );
    }

}
