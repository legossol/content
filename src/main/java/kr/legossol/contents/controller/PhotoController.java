package kr.legossol.contents.controller;

import kr.legossol.contents.domain.photo.dto.ContentsDTOV1;
import kr.legossol.contents.domain.photo.entity.RoomInfo;
import kr.legossol.contents.domain.photo.repository.RoomInfoRepository;
import kr.legossol.contents.domain.photo.service.PhotoServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/photo")
@Slf4j
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoServiceImpl photoService;

    @PostMapping
    public List<ContentsDTOV1> doSome() {
        return photoService.doSome();
    }


}