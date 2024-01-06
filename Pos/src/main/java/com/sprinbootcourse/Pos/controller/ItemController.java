package com.sprinbootcourse.Pos.controller;

import com.sprinbootcourse.Pos.dto.ItemDTO;
import com.sprinbootcourse.Pos.dto.pagination.PaginatedItemDTO;
import com.sprinbootcourse.Pos.dto.request.UpdateItemRQ;
import com.sprinbootcourse.Pos.services.ItemService;
import com.sprinbootcourse.Pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<StandardResponse> saveItem(ItemDTO itemDTO){

        String response = this.itemService.saveItem(itemDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Item Saved",response), HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/getAllItems",
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getAllItems(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){

        PaginatedItemDTO paginatedItemDTO = this.itemService.getAllItems(page,size);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Items",paginatedItemDTO), HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/getAllByActiveStatus",
            params = {"status","page","size"}
    )
    public ResponseEntity<StandardResponse> getAllByActiveStatus(
            @RequestParam(value = "status") boolean status,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        PaginatedItemDTO paginatedItemDTO = this.itemService.getAllByActiveStatus(status,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Items by active status",paginatedItemDTO),HttpStatus.OK
        );
    }

    @GetMapping("/getItemById/{id}")
    public ResponseEntity<StandardResponse> getItemById(@PathVariable(value = "id") int id){
        ItemDTO itemDTO = this.itemService.getItemById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Items by id",itemDTO),HttpStatus.OK
        );
    }

    @PutMapping("/updateItem")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody UpdateItemRQ updateItemRQ){
        String response = this.itemService.updateItem(updateItemRQ);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Item update",response),HttpStatus.OK
        );
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<StandardResponse> deleteItem(@PathVariable(value = "id") int id){
        String response = this.itemService.deleteItem(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Item delete",response),HttpStatus.OK
        );
    }
}
