package com.ccsw.tutorial.author;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.author.model.Author;
import com.ccsw.tutorial.author.model.AuthorDto;
import com.ccsw.tutorial.author.model.AuthorSearchDto;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Author get(Long id) {

        return this.authorRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Author> findPage(AuthorSearchDto dto) {

        return (Page<Author>) authorRepository.findAll(dto.getPageable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Author> findAll() {

        return (List<Author>) this.authorRepository.findAll();
    }

    @Override
    public void save(Long id, AuthorDto data) {

        Author author = null;
        if (id != null) {
            author = this.get(id);
        } else {
            author = new Author();
        }
        BeanUtils.copyProperties(data, author, "id");

        authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {

        authorRepository.deleteById(id);
    }

}
