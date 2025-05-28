package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ImageResponse {
    private Long id;
    private String url;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
