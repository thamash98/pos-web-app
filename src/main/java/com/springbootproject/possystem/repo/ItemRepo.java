package com.springbootproject.possystem.repo;

import com.springbootproject.possystem.dto.response.ItemResponseDTO;
import com.springbootproject.possystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    List<ItemResponseDTO> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);
}
