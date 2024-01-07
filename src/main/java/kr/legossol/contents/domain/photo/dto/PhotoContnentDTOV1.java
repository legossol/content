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
public class PhotoContnentDTOV1 implements ContentsDTOV1{
    private long id;
    private int locate;
    private ContentType contentType;

    @Override
    public Object getName() {
        return this.locate;
    }

    @Override
    public String getThis() {
        return String.valueOf(this.locate);
    }

    public void setContentType() {
        this.contentType = ContentType.getTypeByTypeNum(locate);
    }
}
