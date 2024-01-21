package kr.legossol.contents.domain.photo.repository;

import kr.legossol.contents.domain.photo.entity.Photo;
import kr.legossol.contents.domain.photo.entity.RoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomInfoRepository extends JpaRepository<RoomInfo,Long> {
    Optional<RoomInfo> findByEventTypeIs(String event);

}
