package az.shopery.shop_ms.service;

import az.shopery.shop_ms.model.dto.shared.SuccessResponse;

public interface ShopRatingService {
    SuccessResponse<Void> rateShop(String userEmail, String shopId, int ratingValue);
}
