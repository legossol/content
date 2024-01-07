package kr.legossol.contents.domain.photo.dto;

import kr.legossol.contents.domain.photo.Code.ContentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoContentDTOV1 implements ContentsDTOV1{
    private long id;
    private String locate;
    private ContentType contentType;
    @Override
    public Object getName() {
        return this.locate;
    }

    @Override
    public String getThis() {
        return this.locate;
    }

}
