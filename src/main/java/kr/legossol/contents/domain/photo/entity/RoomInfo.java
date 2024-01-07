package kr.legossol.contents.domain.photo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"gate_id","event_type"}
                )
        }
)
public class RoomInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "gate_id")
    private String gateId;

    @Column(name = "server")
    private String server;

    @Override
    public String toString() {
        return "RoomInfo{" +
                "roomId=" + roomId +
                ", eventType='" + eventType + '\'' +
                ", gateId='" + gateId + '\'' +
                ", server='" + server + '\'' +
                '}';
    }
}
