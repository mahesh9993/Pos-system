package com.sprinbootcourse.Pos.services;

import com.sprinbootcourse.Pos.dto.ItemDTO;
import com.sprinbootcourse.Pos.dto.pagination.PaginatedItemDTO;
import com.sprinbootcourse.Pos.dto.request.UpdateItemRQ;


public interface ItemService {
    String saveItem(ItemDTO itemDTO);

    PaginatedItemDTO getAllByActiveStatus(boolean status,int page,int size);

    PaginatedItemDTO getAllItems(int page, int size);

    String updateItem(UpdateItemRQ updateItemRQ);

    String deleteItem(int id);

    ItemDTO getItemById(int id);
}
