package pl.firmy90.services.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.firmy90.dtos.InstitutionDTO;
import pl.firmy90.model.domain.entity.Institution;
import pl.firmy90.model.repositories.InstitutionRepository;
import pl.firmy90.services.interfaces.InstitutionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultInstitutionService implements InstitutionService {
    private final ModelMapper modelMapper;
    private final InstitutionRepository institutionRepository;

    @Override
    public List<InstitutionDTO> showInstitutions() {
        List<Institution> institutions = institutionRepository.findAll();
        log.debug("Institutions list: {}", institutions.toString());
        ModelMapper mapper = new ModelMapper();
        return institutions.stream().map(institution -> mapper.map(institution,InstitutionDTO.class)).collect(Collectors.toList());
    }
}
