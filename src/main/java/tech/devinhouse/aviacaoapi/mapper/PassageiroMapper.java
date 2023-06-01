package tech.devinhouse.aviacaoapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tech.devinhouse.aviacaoapi.dto.PassageiroListagemDTO;
import tech.devinhouse.aviacaoapi.model.Passageiro;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassageiroMapper {
    List<PassageiroListagemDTO> maptoListagemDTO(List<Passageiro> source);
}
