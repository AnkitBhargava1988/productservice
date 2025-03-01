package dev.naman.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category extends BaseModel {
    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    // this is the same relation being mapped by category attribute in the other (Product) class
}
// class Group {
//   m:m
//   List<User> members;
//   m:m
//   List<User> admins;
//
//   1----> 1
//   m<---- 1
//   m   :  1
//   User creator;
// }