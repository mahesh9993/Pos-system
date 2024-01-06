package com.sprinbootcourse.Pos.util.mappers;

import com.sprinbootcourse.Pos.dto.ItemDTO;
import com.sprinbootcourse.Pos.model.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ItemMapper {

    List<ItemDTO> pageToItemDtoList(Page<Item> items);
}
