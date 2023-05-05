package br.com.paycontrol.service;

import br.com.paycontrol.controller.PeopleController;
import br.com.paycontrol.data.vo.v1.V1_FinanceDepartment;
import br.com.paycontrol.exceptions.ResourceNotFoundExceptions;
import br.com.paycontrol.model.FinanceDepartment;
import br.com.paycontrol.repository.FinanceDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.paycontrol.mapper.FinanceMapperStruct.mapperFinace;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class FinanceDepartmentService {
    @Autowired
    FinanceDepartmentRepository financeDepartmentRepository;

public V1_FinanceDepartment findById(long registered){
  FinanceDepartment financeDepartment = financeDepartmentRepository.findById(registered).orElseThrow(
            () -> new ResourceNotFoundExceptions("No recordes found for this ID!"));
  V1_FinanceDepartment v1FinanceDepartment = mapperFinace.V1_finceDTO(financeDepartment);
    v1FinanceDepartment.add(linkTo((methodOn(PeopleController.class).findById(v1FinanceDepartment.getRegistered()))).withSelfRel());
  return v1FinanceDepartment;
}

    public List<V1_FinanceDepartment> findByAll() {
    List<FinanceDepartment> financeDepartmentList = financeDepartmentRepository.findAll();
    List<V1_FinanceDepartment> financeDepartmentList1 = mapperFinace.V1_finceDTOList(financeDepartmentList);
        financeDepartmentList1.stream().forEach(p-> p.add(linkTo((methodOn(PeopleController.class).findById(p.getRegistered()))).withSelfRel()));
    return financeDepartmentList1;
    }

    public V1_FinanceDepartment create(V1_FinanceDepartment v1FinanceDepartment) {
    FinanceDepartment financeDepartment = mapperFinace.finceDTO(v1FinanceDepartment);
    financeDepartmentRepository.save(financeDepartment);
    V1_FinanceDepartment v1FinanceDepartment1 = mapperFinace.V1_finceDTO(financeDepartment);
        v1FinanceDepartment1.add(linkTo((methodOn(PeopleController.class).findById(v1FinanceDepartment1.getRegistered()))).withSelfRel());
    return v1FinanceDepartment1;

    }

    public V1_FinanceDepartment upDate(V1_FinanceDepartment v1FinanceDepartment) {
        FinanceDepartment financeDepartment = mapperFinace.finceDTO(v1FinanceDepartment);
        financeDepartmentRepository.save(financeDepartment);
        V1_FinanceDepartment v1FinanceDepartment1 = mapperFinace.V1_finceDTO(financeDepartment);
        v1FinanceDepartment1.add(linkTo((methodOn(PeopleController.class).findById(v1FinanceDepartment1.getRegistered()))).withSelfRel());
        return v1FinanceDepartment1;


    }

    public void delete(Long id) {
    financeDepartmentRepository.deleteById(id);

    }
}
