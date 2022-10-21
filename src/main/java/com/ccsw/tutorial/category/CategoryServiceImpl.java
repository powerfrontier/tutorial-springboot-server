package com.ccsw.tutorial.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.category.model.Category;
import com.ccsw.tutorial.category.model.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Category get(Long id) {

        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {

        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void save(Long id, CategoryDto dto) {
        Category categoria;

        if (id == null) {
            categoria = new Category();
        } else {
            categoria = this.get(id);
        }

        categoria.setName(dto.getName());

        categoryRepository.save(categoria);
    }

    @Override
    public void delete(Long id) {
        this.categoryRepository.deleteById(id);
    }

}
