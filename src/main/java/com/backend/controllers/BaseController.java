package com.backend.controllers;

import com.backend.dto.RequestDTO;
import com.backend.dto.ResponseDTO;
import com.backend.mapper.BaseMapper;
import com.backend.model.BaseEntity;
import com.backend.repository.LongKeyRepository;
import com.backend.services.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Optional;

/**
* Абстрактный контроллер
* для обработки обработки запросов
* @author Krll
*/
@MappedSuperclass
public abstract class BaseController<E extends BaseEntity,
        Q extends RequestDTO,
        S extends ResponseDTO,
        A extends BaseService<E, R>,
        M extends BaseMapper<E, Q, S>,
        R extends LongKeyRepository<E>> {

    protected final A service;
    protected final M mapper;

    @Autowired
    public BaseController(A service, M mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(
            summary = "Тестовый запрос",
            description = "Возвращает класс контроллера"
    )
    @GetMapping("/test")
    public String test(){
        return this.getClass().toGenericString();
    }

    @Operation(
            summary = "Создание/Изменение сущности",
            description = "Возвращает созданную сущность или null"
    )
    @PostMapping
    public S create(@RequestBody Q requestDTO) {
        return mapper.toDto(service.create(mapper.toEntity(requestDTO)));
    }

    @Operation(
            summary = "Поиск по Id",
            description = "Возвращает созданную сущность или null"
    )
    @GetMapping("/{id}")
    public S findById(@PathVariable("id") Long id) {
        Optional<E> result = service.findById(id);
        return result.map(mapper::toDto).orElse(null);
    }

    @Operation(
            summary = "Вернуть всё (с пагинацией)",
            description = "В параметрах указать номер страницы"
    )
    @GetMapping("/all/{id}")
    public Iterable<S> findAll(@PathVariable int id){
        return mapper.toDtoList(service.findAll(id));
    }

    @Operation(
            summary = "Вернуть всё (без пагинации)",
            description = "Возвращает все элементы таблицы"
    )
    @GetMapping("/all")
    public Iterable<S> findAll(){
        return mapper.toDtoList(service.findAll());
    }

    @Operation(
            summary = "Вернуть всё (без пагинации)",
            description = "Возвращает все элементы таблицы"
    )
    @GetMapping("/ids")
    public Iterable<S> findByIds(@RequestBody List<Long> idList) {
        return mapper.toDtoList(service.findByIds(idList));
    }

    @Operation(
            summary = "Удаление по объекту",
            description = "Удаляет переданную запись из БД"
    )
    @DeleteMapping
    public boolean delete(E entity) {
        return service.delete(entity);
    }

    @Operation(
            summary = "Удаление по Id",
            description = "Удаляет запись по переданому Id"
    )
    @DeleteMapping("/id")
    public boolean deleteById(Long id) {
        return service.deleteById(id);
    }
}
