package br.com.paycontrol.service;

import br.com.paycontrol.controller.PeopleController;
import br.com.paycontrol.data.vo.v1.V1_People;
import br.com.paycontrol.exceptions.ResourceNotFoundExceptions;
import br.com.paycontrol.model.People;
import br.com.paycontrol.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.paycontrol.mapper.PayMapperStruct.mapper;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PeopleService {
    @Autowired
    PeopleRepository peopleRepository;

public V1_People findById(long id){
  People people = peopleRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundExceptions("No recordes found for this ID!"));
  V1_People v1People = mapper.V1peopleDTO(people);
  v1People.add(linkTo((methodOn(PeopleController.class).findById(v1People.getKey()))).withSelfRel());
  return v1People;
}

    public List<V1_People> findByAll() {
    List<People> peopleList = peopleRepository.findAll();
    List<V1_People> v1People = mapper.V1peopleDTOList(peopleList);
        v1People.stream().forEach(p -> p.add(linkTo((methodOn(PeopleController.class).findById(p.getKey()))).withSelfRel()));
    return v1People;
    }

    public V1_People create(V1_People v1People) {
    People people = mapper.peopleDTO(v1People);
    peopleRepository.save(people);
    V1_People v1People1 = mapper.V1peopleDTO(people);
        v1People1.add(linkTo((methodOn(PeopleController.class).findById(v1People1.getKey()))).withSelfRel());
    return v1People1;

    }

    public V1_People upDate(V1_People v1People) {
        People people = mapper.peopleDTO(v1People);
        people.setCategory(v1People.getCategory());
        people.setContact(v1People.getContact());
        people.setNasc(v1People.getNasc());
        people.setNome(v1People.getNome());
        people.setId(v1People.getKey());
        peopleRepository.save(people);
        v1People = mapper.V1peopleDTO(people);
        v1People.add(linkTo((methodOn(PeopleController.class).findById(v1People.getKey()))).withSelfRel());
        return v1People;
    }


    public void delete(Long id) {
    peopleRepository.deleteById(id);
    }
}
