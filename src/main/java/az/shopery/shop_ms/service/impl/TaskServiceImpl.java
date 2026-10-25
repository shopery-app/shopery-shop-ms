package az.shopery.shop_ms.service.impl;

import az.shopery.shop_ms.handler.exception.ApplicationException;
import az.shopery.shop_ms.model.dto.request.ShopCreateRequestDto;
import az.shopery.shop_ms.model.entity.UserEntity;
import az.shopery.shop_ms.model.entity.task.ShopCreationRequestEntity;
import az.shopery.shop_ms.repository.TaskRepository;
import az.shopery.shop_ms.repository.UserRepository;
import az.shopery.shop_ms.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createShopCreationRequest(UserEntity createdBy, ShopCreateRequestDto shopCreateRequestDto) {
        UserEntity assignedAdmin = userRepository.findRandomActiveAdmin()
                .orElseThrow(() -> new ApplicationException("No admin available!"));

        ShopCreationRequestEntity request = ShopCreationRequestEntity.builder()
                .createdBy(createdBy)
                .assignedAdmin(assignedAdmin)
                .shopName(shopCreateRequestDto.getShopName())
                .description(shopCreateRequestDto.getDescription())
                .subscriptionTier(shopCreateRequestDto.getSubscriptionTier())
                .build();

        taskRepository.save(request);
    }
}
