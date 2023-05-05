package br.com.paycontrol.mapper;

import br.com.paycontrol.data.vo.v1.V1_People;
import br.com.paycontrol.model.People;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PayMapperStruct {

    public static PayMapperStruct mapper = Mappers.getMapper(PayMapperStruct.class);
    @Mapping(source = "key",target = "id")
    @Mapping(target = "nasc", dateFormat = "yyyy-MM-dd")
    public abstract People peopleDTO(V1_People v1People);
    @Mapping(target = "nasc", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "id",target = "key")
    public abstract V1_People V1peopleDTO(People people);
    @Mapping(target = "nasc", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "key",target = "id")
    public abstract List<People> peopleDTOList(List<V1_People> v1PeopleList);
    @Mapping(target = "nasc", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "id",target = "key")
    public abstract List<V1_People> V1peopleDTOList(List<People> peopleList);

}
