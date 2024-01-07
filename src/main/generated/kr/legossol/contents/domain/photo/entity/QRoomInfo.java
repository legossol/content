package kr.legossol.contents.domain.photo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoomInfo is a Querydsl query type for RoomInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomInfo extends EntityPathBase<RoomInfo> {

    private static final long serialVersionUID = 1730613305L;

    public static final QRoomInfo roomInfo = new QRoomInfo("roomInfo");

    public final StringPath eventType = createString("eventType");

    public final StringPath gateId = createString("gateId");

    public final NumberPath<Long> roomId = createNumber("roomId", Long.class);

    public final StringPath server = createString("server");

    public QRoomInfo(String variable) {
        super(RoomInfo.class, forVariable(variable));
    }

    public QRoomInfo(Path<? extends RoomInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoomInfo(PathMetadata metadata) {
        super(RoomInfo.class, metadata);
    }

}

