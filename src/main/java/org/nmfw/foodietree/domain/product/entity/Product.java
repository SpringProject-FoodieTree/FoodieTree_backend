package org.nmfw.foodietree.domain.product.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.nmfw.foodietree.domain.store.entity.Store;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString(exclude = "store")
@EqualsAndHashCode(of = "productId")
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="tbl_product")
public class Product {

    @Id // auto increment
    @GenericGenerator(strategy = "uuid2", name = "uuid-generator")
    @GeneratedValue(generator = "uuid-generator")
    private String productId;

    private LocalDateTime pickupTime; // 마감시간

    @CreationTimestamp
    private LocalDateTime productUploadDate; // 상품 등록 시간
    private String proImage;

    private LocalDateTime canceledByStoreAt; // 가게에서 취소한 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;


}
