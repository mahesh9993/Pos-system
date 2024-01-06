package com.sprinbootcourse.Pos.services.impl;

import com.sprinbootcourse.Pos.dto.ItemDTO;
import com.sprinbootcourse.Pos.dto.pagination.PaginatedItemDTO;
import com.sprinbootcourse.Pos.dto.request.UpdateItemRQ;
import com.sprinbootcourse.Pos.exception.NotFoundException;
import com.sprinbootcourse.Pos.model.Item;
import com.sprinbootcourse.Pos.repo.ItemRepo;
import com.sprinbootcourse.Pos.services.ItemService;
import com.sprinbootcourse.Pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemDTO itemDTO) {
        Item item = this.modelMapper.map(itemDTO,Item.class);
        this.itemRepo.save(item);
        return item.getItemName()+" saved";
    }

    @Override
    public PaginatedItemDTO getAllByActiveStatus(boolean status,int page,int size) {
        Page<Item> items = this.itemRepo.findAllByStatusEquals(status,PageRequest.of(page, size));
        if (items.getTotalElements()>0){
            return new PaginatedItemDTO(
                    this.itemMapper.pageToItemDtoList(items),
                    this.itemRepo.countAllByStatusEquals(status)
            );
        }else {
            throw new NotFoundException("data not found");
        }

    }

    @Override
    public PaginatedItemDTO getAllItems(int page, int size) {

        Page<Item> items = this.itemRepo.findAll(PageRequest.of(page, size));

        return new PaginatedItemDTO(
                this.itemMapper.pageToItemDtoList(items),
                this.itemRepo.count()
        );
    }

    @Override
    public String updateItem(UpdateItemRQ updateItemRQ) {

        if (this.itemRepo.existsByItemIdEquals(updateItemRQ.getItemId())){
            Item item = this.itemRepo.getReferenceById(updateItemRQ.getItemId());
            item.setBalanceQty(updateItemRQ.getBalanceQty());
            item.setCost(updateItemRQ.getCost());
            item.setSellingPrice(updateItemRQ.getSellingPrice());
;
            this.itemRepo.saveAndFlush(item);

            return item.getItemName() + "updated";
        }else{
            throw new NotFoundException("item not found for update");
        }

    }

    @Override
    public String deleteItem(int id) {
        if (this.itemRepo.existsByItemIdEquals(id)) {
            Item item = this.itemRepo.getReferenceById(id);
            this.itemRepo.deleteById(id);
            return item.getItemName()+ "has succesfully deleted from database";
        }else {
            throw new NotFoundException("item not found for delete");
        }
    }

    @Override
    public ItemDTO getItemById(int id) {
        Item item = this.itemRepo.getReferenceById(id);
        if (item.getItemId() != 0){
            ItemDTO itemDTO = this.modelMapper.map(item,ItemDTO.class);
            return itemDTO;
        }else {
            throw new NotFoundException("item not found");
        }

    }
}
