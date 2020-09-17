package io.github.joaoroche.rest.controller;


import io.github.joaoroche.domain.entity.Cliente;
import io.github.joaoroche.domain.repository.Clientes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/clientes")
@Api("Api Clientes")
public class ClienteController {

    @Autowired
    private Clientes clientes;

    @GetMapping("{id}")
    public Cliente getClienteById(@PathVariable Integer id){
        return clientes.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@Valid @RequestBody Cliente cliente){
        return clientes.save(cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        clientes.findById(id)
            .map(cliente -> {
            clientes.delete(cliente);
            return cliente;
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @PathVariable Integer id, @RequestBody Cliente cliente){
        clientes.findById(id).map(clieteExistente -> {
            cliente.setId(clieteExistente.getId());
            clientes.save(cliente);
            return clieteExistente;

        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }


    @GetMapping
    public List<Cliente> find( Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }
}
