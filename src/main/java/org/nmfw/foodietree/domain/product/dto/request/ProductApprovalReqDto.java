package org.nmfw.foodietree.domain.product.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.nmfw.foodietree.domain.product.Util.FileUtil;
import org.nmfw.foodietree.domain.product.entity.ProductApproval;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

// 상품 등록 요청 DTO
public class ProductApprovalReqDto {

    @Value("${file.upload.root-path}")
    private String rootPath;

    @NotNull
    private int price;

    @NotNull
    @Range(min=1, max=50)
    private int productCnt;

    @NotNull
    private MultipartFile productImage;

    @Setter
    private String storeId;

    public ProductApproval toEntity() {
        // entity 이미지 파일 경로 저장
        String profilePath = null;
        if (!productImage.isEmpty()) {
            profilePath = FileUtil.uploadFile(rootPath, productImage);
        }

        return ProductApproval.builder()
                .proImage(profilePath)
                .price(price)
                .productCnt(productCnt)
                .build();
    }


}
