package com.sprinbootcourse.Pos.repo;

import com.sprinbootcourse.Pos.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepo extends JpaRepository<Item,Integer> {

    Page<Item> findAllByStatusEquals(boolean status, Pageable pageable);

    long countAllByStatusEquals (boolean status);

    boolean existsByItemIdEquals (int id);
}
