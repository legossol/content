package kr.legossol.contents.domain.photo.service;

import kr.legossol.contents.domain.photo.dto.ContentsDTOV1;
import kr.legossol.contents.domain.photo.dto.PhotoContnentDTOV1;
import kr.legossol.contents.domain.photo.dto.VideoContentDTOV1;
import kr.legossol.contents.domain.photo.entity.RoomInfo;
import kr.legossol.contents.domain.photo.repository.RoomInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhotoServiceImpl {
    private final RoomInfoRepository repository;

    public List<ContentsDTOV1> doSome(){
        List<ContentsDTOV1> contentsDTOV1List = new ArrayList<>();
        PhotoContnentDTOV1 photoDto = PhotoContnentDTOV1.builder()
                .id(1L)
                .locate(2)
                .build();
        VideoContentDTOV1 videoDto = VideoContentDTOV1.builder()
                .id(2L)
                .locate("videoLocate")
                .build();
        photoDto.setContentType();
        contentsDTOV1List.add(photoDto);
        contentsDTOV1List.add(videoDto);

        return contentsDTOV1List;
    }

}
