package dev.naman.productservice.services;

import dev.naman.productservice.dtos.GenericProductDto;
import dev.naman.productservice.exceptions.NotFoundException;
import dev.naman.productservice.models.Product;
import dev.naman.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
        Optional<Product> product = productRepository.findById(id);
        GenericProductDto genericProductDto = new GenericProductDto();
        if(!product.isEmpty()) {
            genericProductDto.setDescription(product.get().getDescription());
            genericProductDto.setPrice(product.get().getPrice());
            genericProductDto.setCategory(product.get().getCategory());
            genericProductDto.setImage(product.get().getImage());
        }
        else {
            throw new NotFoundException("No Product found by this id " + id);
        }
        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productToGenericProductConverter(products);
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> getProductByCategories(String category) {
        return productRepository.findByCategory_Name(category);
    }

    private List<GenericProductDto> productToGenericProductConverter(List<Product> products){

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(Product productDto : products){

            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setPrice(productDto.getPrice());
            genericProductDto.setCategory(productDto.getCategory());
            genericProductDto.setTitle(productDto.getTitle());
            genericProductDto.setDescription(productDto.getDescription());
            genericProductDtos.add(genericProductDto);

        }
        return genericProductDtos;
    }
}


