package kr.legossol.contents.domain.photo.Code;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ContentType {

    VIDEO(1,"비디오",Arrays.asList("mp4","vlc"))
    ,PHOTO(2,"사진",Arrays.asList("jpeg","jpg"))
    ,EMPTY(0,"없음", Collections.emptyList())
    ;
    private int typeNum;
    private String typeName;
    private List<String> typeExtention;
    public static ContentType getTypeByExtention(String extention) {
        return Arrays.stream(ContentType.values()).filter(ext -> ext.hasExtention(extention))
                .findAny().orElse(EMPTY);
    }
    public static ContentType getTypeByTypeNum(int typeNum) {
        for (ContentType contentType : ContentType.values()) {
            if (contentType.getTypeNum() == typeNum) {
                return contentType;
            }
        }
        return null;
    }
    public boolean hasExtention(String extention) {
        return typeExtention.stream().anyMatch(ext -> ext.equals(extention));
    }
}

