package com.naasira.productservice.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
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
@Table(name="inventories" , uniqueConstraints = {@UniqueConstraint(columnNames = {"product_id","warehouse_id"})})
public class Inventory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="stock_id")
  private Long stockId;

  @ManyToOne
  @JoinColumn(name="product_id")
  private Product product;

  @ManyToOne
  @JoinColumn(name="warehouse_id")
  private Warehouse warehouse;

  @Column(name="quantity_available" , nullable = false)
  private Integer quantityAvailable;

  @Column(name="reorder_level",  nullable = false)
  private Integer reorderLevel;

  @Builder.Default
  @Column(name="is_active", nullable = false)
  private Boolean isActive=true;

  @CreatedDate
  @Column(name="created_at")
  private LocalDateTime createdAt;


  @LastModifiedDate
  @Column(name="updated_at")
  private LocalDateTime updatedAt;












}
