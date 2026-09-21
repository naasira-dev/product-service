package com.naasira.productservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@SQLRestriction("is_active=true")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name" , nullable = false)
    private String name;

    @Column(name="product_price" , nullable = false)
    private BigDecimal price;

    @Column(name = "product_desc")
    private String description;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @Column(name="sku" , unique = true , nullable = false)
    private String sku;

    @JoinColumn(name="category_id" , nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Builder.Default
    @Column(name="is_active", nullable = false , columnDefinition = "boolean default true")
    private Boolean isActive=true;

    @Column(name="created_at" , nullable=false ,updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;


}
