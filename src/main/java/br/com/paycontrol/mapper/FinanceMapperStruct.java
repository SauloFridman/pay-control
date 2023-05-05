package br.com.paycontrol.mapper;

import br.com.paycontrol.data.vo.v1.V1_FinanceDepartment;
import br.com.paycontrol.model.FinanceDepartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FinanceMapperStruct {

    public static  FinanceMapperStruct  mapperFinace = Mappers.getMapper(FinanceMapperStruct.class);
@Mapping(target = "datePayment", dateFormat = ("yyyy-MM-dd"))
    public abstract FinanceDepartment finceDTO(V1_FinanceDepartment v1FinanceDepartment);
    @Mapping(target = "datePayment", dateFormat = ("yyyy-MM-dd"))
    public abstract V1_FinanceDepartment V1_finceDTO(FinanceDepartment FinanceDepartment);
    @Mapping(target = "datePayment", dateFormat = ("yyyy-MM-dd"))
    public abstract List<FinanceDepartment> finceDTOList(List<V1_FinanceDepartment> v1_financeDepartmentList);
    @Mapping(target = "datePayment", dateFormat = ("yyyy-MM-dd"))
    public abstract List<V1_FinanceDepartment> V1_finceDTOList(List<FinanceDepartment> FinanceDepartmentList);


}
