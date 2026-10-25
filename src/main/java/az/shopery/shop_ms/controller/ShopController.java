package az.shopery.shop_ms.controller;

import az.shopery.shop_ms.model.dto.request.ShopCreateRequestDto;
import az.shopery.shop_ms.model.dto.shared.SuccessResponse;
import az.shopery.shop_ms.model.dto.response.UserShopResponseDto;
import az.shopery.shop_ms.service.ShopRatingService;
import az.shopery.shop_ms.service.ShopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/me/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;
    private final ShopRatingService shopRatingService;

    @PostMapping
    public ResponseEntity<SuccessResponse<Void>> createMyShop(@RequestParam String email, @Valid @RequestBody ShopCreateRequestDto shopCreateRequestDto) {
        return ResponseEntity.ok(shopService.createMyShop(email, shopCreateRequestDto));
    }

    @PostMapping("/{shopId}/rating")
    public ResponseEntity<SuccessResponse<Void>> rateShop(@RequestParam String email, @PathVariable String shopId, @RequestParam int rating) {
        return ResponseEntity.ok(shopRatingService.rateShop(email, shopId, rating));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<SuccessResponse<UserShopResponseDto>> getMyShop(@RequestParam String email) {
        return ResponseEntity.ok(shopService.getMyShop(email));
    }
}
