package dev.naman.productservice.thirdpartyclients.productsservice.fakestore;

import dev.naman.productservice.models.Category;
import dev.naman.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Price price;
    private Category category;
    private String description;
    private String image;
}

// Break till 10:35