package ru.gen.prtime.service;

import io.micrometer.observation.ObservationFilter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.repository.InMemoryReceptionRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceptionService {

    private final InMemoryReceptionRepository receptionRepository;
    public List<Reception> findAllReceptions() {
        return receptionRepository.findAll();
    }

    public void save(ReceptionDTO receptionDTO) {
        Reception reception = new Reception();
        reception.setIdSpecialist(receptionDTO.getIdSpecialist());
        reception.setIdVisitor(receptionDTO.getIdVisitor());
        reception.setReceptionDate(LocalDate.parse(receptionDTO.getReceptionDate()));
        reception.setReceptionTime(LocalTime.parse(receptionDTO.getReceptionTime()));
        //TODO сделать из этого класс маппера
        //TODO отображение времени без секунд
        receptionRepository.save(reception);
    }
}


//    ModelMapper modelMapper = new ModelMapper();
//
//    Converter<String, LocalDate> dateConverter = context -> {
//        if (context.getSource() == null) {
//            return null;
//        }
//        return LocalDate.parse(context.getSource());
//    };
//modelMapper.addConverter(dateConverter);
//
//        Converter<String, LocalTime> timeConverter = context -> {
//        if (context.getSource() == null) {
//        return null;
//        }
//        return LocalTime.parse(context.getSource());
//        };
//        modelMapper.addConverter(timeConverter);
//
//        Reception reception = modelMapper.map(receptionDTO, Reception.class);



//    public ReceptionService() {
//        this.modelMapper = new ModelMapper();
//        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//        this.modelMapper.addMappings(new PropertyMap<ReceptionDTO, Reception>(){
//            @Override
//            protected void configure() {
//                map().setReceptionDate(source.getReceptionDate());
//                map().setReceptionTime(source.getReceptionTime());
//            }
//        });
//    }


//    public ReceptionService() {
//        this.modelMapper = new ModelMapper();
//        this.modelMapper.addMappings(new PropertyMap<ReceptionDTO, Reception>() {
//            @Override
//            protected void configure() {
//                skip(destination.getId());
//            }
//        });
//    }



//    public ReceptionService() {
//        this.modelMapper = new ModelMapper();
//        this.modelMapper.addMappings(new PropertyMap<ReceptionDTO, Reception>() {
//            @Override
//            protected void configure() {
//                skip(destination.getId());
//            }
//        });
//    }