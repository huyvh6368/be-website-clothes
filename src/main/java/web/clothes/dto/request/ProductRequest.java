package web.clothes.dto.request;
import lombok.Getter;

@Getter
public class ProductRequest {
    private String code;
    private String name;
    private Double price;
    private String describes;
    private Long categoriesId;
    private Long brandId;
    private String image;
}
