package kr.legossol.contents.controller;

import kr.legossol.contents.domain.photo.dto.ContentsDTOV1;
import kr.legossol.contents.domain.photo.entity.Photo;
import kr.legossol.contents.domain.photo.entity.RoomInfo;
import kr.legossol.contents.domain.photo.repository.RoomInfoRepository;
import kr.legossol.contents.domain.photo.service.PhotoServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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
    @GetMapping("/search")
    public Page<Photo> getPhotoContentPage(
            @RequestParam(value = "name")String name,
            @PageableDefault(page=0,size = 5, sort = "name",direction = Sort.Direction.ASC)Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(0, 5);
        return photoService.findAllPhoto(name,pageRequest);
    }
}