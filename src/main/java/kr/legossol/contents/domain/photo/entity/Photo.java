package kr.legossol.contents.domain.photo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;

    @Column(name = "locate")
    private String locate;

    @Column(name = "size")
    private String size;

}
