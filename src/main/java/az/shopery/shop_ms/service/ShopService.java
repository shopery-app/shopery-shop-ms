package az.shopery.shop_ms.service;

import az.shopery.shop_ms.model.dto.request.ShopCreateRequestDto;
import az.shopery.shop_ms.model.dto.response.ShopResponseDto;
import az.shopery.shop_ms.model.dto.shared.SuccessResponse;
import az.shopery.shop_ms.model.dto.response.UserShopResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShopService {
    SuccessResponse<UserShopResponseDto> getMyShop(String userEmail);
    SuccessResponse<Page<ShopResponseDto>> getAllShops(Pageable pageable);
    SuccessResponse<ShopResponseDto> getShopById(String shopId);
    SuccessResponse<ShopResponseDto> getShopByShopName(String shopName);
    SuccessResponse<Void> createMyShop(String userEmail, ShopCreateRequestDto shopCreateRequestDto);
}
