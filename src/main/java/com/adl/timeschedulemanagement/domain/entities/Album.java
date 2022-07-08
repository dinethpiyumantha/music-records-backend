package com.adl.timeschedulemanagement.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private String date;
    @ManyToOne
    @JoinColumn(name = "fk_genre_id")
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "fk_label_id")
    private Label label;

    public void log() {
        System.out.println(
                "\nid = " + id +
                        "\nname = " + name +
                        "\ndate = " + date +
                        "\nalbums = " + genre +
                        "\nlabel = " + label +
                        "\n"
        );
    }
}
