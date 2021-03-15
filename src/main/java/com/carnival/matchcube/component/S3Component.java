package com.carnival.matchcube.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "cloud.aws.s3")
@Component
public class S3Component {

//    @ConfigurationProperties(prefix="cloud.aws.s3")을 통해 프로퍼티의 값을 불러오기
//    @Setter 필요, 또한 S3Service에서 빈 주입 받기 위해 빈으로 등록
    private String bucket;
}
