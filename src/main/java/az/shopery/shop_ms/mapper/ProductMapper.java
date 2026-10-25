package az.shopery.shop_ms.mapper;

import static az.shopery.shop_ms.utils.common.DiscountCalculator.calculateDiscountFromOriginalPrice;

import az.shopery.shop_ms.model.dto.response.ProductResponseDto;
import az.shopery.shop_ms.model.entity.ProductEntity;
import az.shopery.shop_ms.utils.common.FilenetClientHelper;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final FilenetClientHelper filenetClientHelper;

    public ProductResponseDto toBriefDto(ProductEntity productEntity) {
        var productResponseDto = ProductResponseDto.builder()
                .id(productEntity.getId())
                .productName(productEntity.getProductName())
                .description(productEntity.getDescription())
                .currentPrice(productEntity.getCurrentPrice())
                .stockQuantity(productEntity.getStockQuantity())
                .discountDto(calculateDiscountFromOriginalPrice(productEntity.getCurrentPrice(), productEntity.getOriginalPrice()))
                .build();

        if (Objects.nonNull(productEntity.getImageId())) {
            productResponseDto.setImage(filenetClientHelper.getFile(productEntity.getImageId()));
        }

        return productResponseDto;
    }
}
