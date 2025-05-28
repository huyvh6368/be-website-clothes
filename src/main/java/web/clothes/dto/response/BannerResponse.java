package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BannerResponse {
    private Long id;
    private String url;
    private Boolean defaulted;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
