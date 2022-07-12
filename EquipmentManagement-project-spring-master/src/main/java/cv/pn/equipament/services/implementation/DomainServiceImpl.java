package cv.pn.equipament.services.implementation;


import cv.pn.equipament.dtos.DomainDTO;

import cv.pn.equipament.models.Domain;
import cv.pn.equipament.repositories.DomainRepository;
import cv.pn.equipament.services.DomainService;
import cv.pn.equipament.utilities.APIResponse;
import cv.pn.equipament.utilities.MessageState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class DomainServiceImpl implements DomainService {

   private final DomainRepository domainRepository;

    @Override
    public APIResponse insertDomain(DomainDTO domainDTO) {

        Optional<Domain> optionalDomain = domainRepository.findByCode(domainDTO.getCode());
        if(!optionalDomain.isEmpty()){
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList("Dominio ")).build();

        }

        Domain domain = new Domain();

        try {
            domain.setName(domainDTO.getName());
            domain.setCode(domainDTO.getCode());
            domain.setDomain(domainDTO.getDomain());
            domain.setOrder(domainDTO.getOrder());
            domain.setSelfId(domainDTO.getSelfId());

            domainRepository.save(domain);

            return APIResponse.builder().status(true).statusText(MessageState.INSERIDO_COM_SUCESSO).build();

        }
        catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_DE_INSERCAO).details(Arrays.asList(e.getMessage())).build();

        }

    }

    @Override
    public APIResponse updateDomain(String id, DomainDTO domainDTO) {
        Optional<Domain> optionalDomain = domainRepository.findById(id);
        if (optionalDomain.isEmpty()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList("Dominio "+MessageState.ID_NAO_EXISTE)).build();
        }
        Domain domain = optionalDomain.get();


        try {
            domain.setName(domainDTO.getName());
            domain.setCode(domainDTO.getCode());
            domain.setDomain(domainDTO.getDomain());
            domain.setOrder(domainDTO.getOrder());
            domain.setSelfId(domainDTO.getSelfId());

            domainRepository.save(domain);
            return APIResponse.builder().status(true).statusText(MessageState.ATUALIZADO_COM_SUCESSO).build();


        } catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO_AO_ATUALIZAR).details(Arrays.asList(e.getMessage())).build();

        }

    }


    @Override
    public APIResponse getDomain(String id) {
        Optional<Domain> optionalDomain = domainRepository.findById(id);
        if (!optionalDomain.isPresent()) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList("Dominio " + MessageState.ID_NAO_EXISTE)).build();

        }
        Domain domain = optionalDomain.get();

        DomainDTO domainDTO = new DomainDTO();
        try {
            domainDTO.setName(domain.getName());
            domainDTO.setCode(domain.getCode());
            domainDTO.setDomain(domain.getDomain());
            domainDTO.setOrder(domain.getOrder());
            domainDTO.setSelfId(domain.getSelfId());
            domainDTO.setId(domain.getId());


            return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(Arrays.asList(domainDTO)).build();


        } catch (Exception e) {
            return APIResponse.builder().status(false).statusText(MessageState.ERRO).details(Arrays.asList(e.getMessage())).build();
        }

    }


  @Override
    public APIResponse getAllDomain(String selfId) {
        List<Domain> domains = domainRepository.findBySelfId(selfId);

        List<Object> domainsDTOS = domains.stream()
                .map(domain -> new DomainDTO(domain.getId(),domain.getName(),domain.getCode(),domain.getDomain(),domain.getOrder(),domain.getSelfId())
                ).collect(Collectors.toList());
        return APIResponse.builder().status(true).statusText(MessageState.SUCESSO).details(domainsDTOS).build();


    }
}

