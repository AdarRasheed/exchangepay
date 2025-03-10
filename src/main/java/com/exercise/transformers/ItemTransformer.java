package com.exercise.transformers;

import com.exercise.domains.Item;
import com.exercise.domains.enums.ItemCategory;
import com.exercise.dtos.ItemDTO;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ItemTransformer implements Transformer<ItemDTO, Item> {

    @Override
    public Item toDomain(ItemDTO itemDTO) {
        Objects.requireNonNull(itemDTO, "Item information can't be null");
        return Item.builder()
                .id(itemDTO.getId())
                .category(toItemCategory(itemDTO.getCategory()))
                .price(itemDTO.getPrice())
                .build();
    }

    private ItemCategory toItemCategory(String category) {
        return StringUtils.isNotBlank(category) ? ItemCategory.valueOf(category.toUpperCase()) : null;
    }

    @Override
    public ItemDTO toDTO(Item item) {
        throw new UnsupportedOperationException("No implementation required yet");
    }

}
