package kr.legossol.contents;

import kr.legossol.contents.domain.photo.entity.RoomInfo;
import kr.legossol.contents.domain.photo.repository.RoomInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class ContentsApplicationTests {
	@Autowired
	private RoomInfoRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void 동시_요청_테스트() {
		RoomInfo save = new RoomInfo();
		//멀티스레드 이용 : 비동기를 단순하게 처리할 수 있도록 해주는 java api
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		for (int i = 1; i < 2; i++) {
			executorService.submit(() -> {
				System.out.println("1");
				RoomInfo save1 = repository.saveAndFlush(RoomInfo.builder()
						.eventType("STREAM")
						.gateId("gate-1")
						.server("server1")
						.build());

				System.out.println("2");
				Optional<RoomInfo> stream = repository.findByEventTypeIs("STREAM");
				System.out.println("조회된것 : " + stream.get());
			});
		}
	}
}
