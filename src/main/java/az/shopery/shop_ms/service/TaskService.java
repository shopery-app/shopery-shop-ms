package az.shopery.shop_ms.service;

import az.shopery.shop_ms.model.dto.request.ShopCreateRequestDto;
import az.shopery.shop_ms.model.entity.UserEntity;

public interface TaskService {
    void createShopCreationRequest(UserEntity createdBy, ShopCreateRequestDto shopCreateRequestDto);
}
