package com.naasira.productservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@SQLRestriction("is_active=true")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "warehouse_name", nullable = false, unique = true)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="warehouse_code" , nullable = false , unique = true)
    private String code;


    @Builder.Default
    @Column(name="is_active" , nullable = false )
    private Boolean isActive=true;

    @CreatedDate
    @Column(name="created_at" , updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at" , nullable = false)
    private LocalDateTime updatedAt;




}
