package com.naasira.productservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SQLRestriction("is_active = true")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name="category_name" , unique = true , nullable = false)
    private String name;

    @Column(name="slug" ,unique = true ,nullable = false)
    private String slug;

    @Column(name="category_description")
    private String description;

    @JoinColumn(name="parent_category_id" )
    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

    @Builder.Default
    @OneToMany(mappedBy = "parentCategory" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Category> subCategories = new ArrayList<>();

    @Builder.Default
    @Column(name="is_active"  , nullable = false ,columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @Column(name="created_at" , nullable = false , updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;


    @Column(name="updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
