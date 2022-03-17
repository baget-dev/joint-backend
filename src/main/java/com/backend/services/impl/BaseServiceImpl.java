package com.backend.services.impl;

import com.backend.model.BaseEntity;
import com.backend.repository.LongKeyRepository;
import com.backend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public abstract class BaseServiceImpl<E extends BaseEntity,
        R extends LongKeyRepository<E>> implements BaseService<E, R> {

    protected final R repo;
    private int pageSize;

    @Autowired
    public BaseServiceImpl(R repo, int pageSize) {
        this.repo = repo;
        this.pageSize = pageSize;
    }

    @Override
    public E create(E entity) {
        return repo.save(entity);
    }

    @Override
    public Iterable<E> saveAll(Iterable<E> entityList) {
        return repo.saveAll(entityList);
    }

    @Override
    public Optional<E> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<E> findAll(int page) {
        Pageable firstPage = PageRequest.of(page, pageSize);
        return repo.findAll(firstPage);
    }

    @Override
    public Iterable<E> findByIds(Iterable<Long> idList) {
        return repo.findAllById(idList);
    }

    @Override
    public boolean delete(E entity) {
        repo.delete(entity);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public Iterable<E> findAll() {
        return repo.findAll();
    }
}
