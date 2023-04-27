package cart.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

public class ProductPostRequest {

    @NotBlank(message = "상품 명을 입력해주세요.")
    private String name;

    @NotNull
    @Min(value = 0, message = "{value} 이상의 가격을 입력해주세요")
    private int price;

    @NotBlank
    @URL(message = "유효한 URL 형식을 입력해주세요")
    private String imageUrl;

    private ProductPostRequest() {
    }

    public ProductPostRequest(final String name, final int price, final String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
