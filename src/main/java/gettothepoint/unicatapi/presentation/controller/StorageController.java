package gettothepoint.unicatapi.presentation.controller;

import gettothepoint.unicatapi.common.propertie.AppProperties;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {

    private final AppProperties appProperties;

    @Operation(
            summary = "정적 파일 업로드",
            description = "정적 파일을 서버에 업로드하고 접근 가능한 URL을 반환합니다."
    )
    @PostMapping(consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadStaticFile(@RequestParam("file") MultipartFile file) {
        // TODO: 파일 저장 로직 추가
        // 예시: 저장된 파일 URL 생성
        return appProperties.api().protocol() + "://" + appProperties.api().domain() + "/storage/" + file.getOriginalFilename();
    }
}