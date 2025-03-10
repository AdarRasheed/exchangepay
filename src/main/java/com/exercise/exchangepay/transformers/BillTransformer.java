package com.exercise.exchangepay.transformers;

import com.exercise.exchangepay.domains.Bill;
import com.exercise.exchangepay.domains.Item;
import com.exercise.exchangepay.domains.User;
import com.exercise.exchangepay.domains.enums.UserType;
import com.exercise.exchangepay.dtos.BillDTO;
import com.exercise.exchangepay.dtos.ItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class BillTransformer implements Transformer<BillDTO, Bill> {

    private final Transformer<ItemDTO, Item> itemTransformer;

    public BillTransformer(Transformer<ItemDTO, Item> itemTransformer) {
        this.itemTransformer = itemTransformer;
    }

    @Override
    public Bill toDomain(BillDTO dto) {
        Objects.requireNonNull(dto, "Bill information can't be null");
        User user = toUser(dto);
        List<Item> items = itemTransformer.toDomains(dto.getItemDTOs());
        return Bill.builder()
                .user(user)
                .items(items)
                .currency(dto.getOriginalCurrency())
                .build();
    }

    private User toUser(BillDTO dto) {
        Objects.requireNonNull(dto.getUserId(), "User id can't be null");
        Objects.requireNonNull(dto.getUserType(), "User type can't be null");
        Objects.requireNonNull(dto.getCustomerSince(), "User customer since date can't be null");
        return User.builder()
                .userId(dto.getUserId())
                .type(UserType.valueOf(dto.getUserType().toUpperCase()))
                .customerSince(dto.getCustomerSince())
                .build();
    }

    @Override
    public BillDTO toDTO(Bill bill) {
        throw new UnsupportedOperationException("No implementation required yet");
    }

}
