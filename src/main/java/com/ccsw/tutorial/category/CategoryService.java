package com.ccsw.tutorial.category;

import java.util.List;

import com.ccsw.tutorial.category.model.Category;
import com.ccsw.tutorial.category.model.CategoryDto;

public interface CategoryService {

    /**
     * Recupera una {@link com.ccsw.tutorial.category.model.Category} a partir de su
     * ID
     * 
     * @param id
     * @return
     */
    Category get(Long id);

    List<Category> findAll();

    void save(Long id, CategoryDto dto);

    void delete(Long id);

}
