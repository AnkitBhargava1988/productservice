package dev.naman.productservice.services;

import dev.naman.productservice.models.Category;
import dev.naman.productservice.models.Product;

import java.util.List;

public interface CategoryService {
    Category getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);
    List<String> getCategories();

}
