package dev.naman.productservice.dtos;

import dev.naman.productservice.models.Category;
import dev.naman.productservice.models.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Category category;
    private Price price;
}
