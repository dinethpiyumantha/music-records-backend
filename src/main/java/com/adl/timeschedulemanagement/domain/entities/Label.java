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
@Table(name = "labels")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_label_id", referencedColumnName = "id")
    Set<Album> albums;

    public void log() {
        System.out.println(
                "\nid = " + id +
                        "\nname = " + name +
                        "\nalbums_size = " + albums.size() +
                        "\n"
        );
    }

}
