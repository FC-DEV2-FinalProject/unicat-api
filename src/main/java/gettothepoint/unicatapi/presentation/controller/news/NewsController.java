package gettothepoint.unicatapi.presentation.controller.news;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "News", description = "뉴스 관련 API")
@RestController
@RequestMapping("/news")
public class NewsController {

    @Operation(
            summary = "뉴스 생성",
            description = "주어진 뉴스 내용과 첨부된 파일 URL 목록을 기반으로 새 뉴스를 생성합니다. 생성 요청이 접수되면, 결과는 비동기적으로 푸시 알림을 통해 전달됩니다."
    )
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createNews(@RequestBody NewsRequest request) {
        // TODO: 뉴스 생성 로직 추가
        // 뉴스 생성 프로세스가 완료되면, 결과를 비동기적으로 푸시 알림을 통해 사용자에게 전달합니다.
    }

    public record NewsRequest(
            @Schema(description = "뉴스의 전체적 흐름을 나타내는 내용", example = "세포 분열을 지속적으로 하지 못하는 이유에 대한 연구 결과")
            String context,
            @Schema(description = "업로드 된 이미지 경로", example = "[\"https://api.unicat.day/storage/file1.jpg\", \"https://api.unicat.day/storage/file2.jpg\"]")
            List<String> fileUrls
    ) {}
}