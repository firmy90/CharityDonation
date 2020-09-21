package pl.firmy90.services.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.firmy90.dtos.InstitutionDTO;
import pl.firmy90.model.domain.entity.Institution;
import pl.firmy90.model.repositories.InstitutionRepository;
import pl.firmy90.services.interfaces.InstitutionService;

import javax.transaction.Transactional;
import java.sql.Struct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultInstitutionService implements InstitutionService {
    private final ModelMapper modelMapper;
    private final InstitutionRepository institutionRepository;

    @Override
    public List<InstitutionDTO> showInstitutions() {
//        List<Institution> institutions = institutionRepository.findAll();
        List<Institution> institutions = institutionRepository.findVisibleInstitutionsByVisibleEquals(Boolean.TRUE);
        log.debug("Institutions list: {}", institutions.toString());
        return institutions.stream().map(institution -> modelMapper.map(institution, InstitutionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public InstitutionDTO findById(Long id) {
        Optional<Institution> byId = institutionRepository.findById(id);
        InstitutionDTO map = modelMapper.map(byId.get(), InstitutionDTO.class);
        log.debug("Institutions from id: {}", map.toString());
        return map;
    }

    @Override
    public void saveInstitution(InstitutionDTO institutionDTO) {
        Institution institution = new Institution();
        log.debug("InstitutionDTO before mapping: {}", institutionDTO);
        modelMapper.map(institutionDTO, institution);
        log.debug("Institution after mapping: {}", institution);
        institutionRepository.save(institution);

    }

    @Override
    public boolean deleteInstitution(Long id) {
        Optional<Institution> institutionOptional = institutionRepository.findById(id);
        if (institutionOptional.isPresent()) {
            institutionRepository.delete(institutionOptional.get());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean archiveInstitution(Long id) {
        Optional<Institution> institutionOptional = institutionRepository.findById(id);
        if (institutionOptional.isPresent()) {
            institutionRepository.archiveInstitutionById(institutionOptional.get().getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateInstitution(Long id, InstitutionDTO institutionDTO) {
        Optional<Institution> institutionOptional = institutionRepository.findById(id);
        if (institutionOptional.isPresent()) {
            Institution institution = institutionOptional.get();
            log.debug("InstitutionDTO before mapping: {}", institutionDTO);
            modelMapper.map(institutionDTO, institution);
            institution.setId(id);
            log.debug("Institution after mapping: {}", institution);
            institutionRepository.save(institution);
            return true;
        }
        return false;
    }
}
