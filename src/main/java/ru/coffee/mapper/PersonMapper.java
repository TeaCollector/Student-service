package ru.coffee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.coffee.domain.model.Person;
import ru.coffee.domain.dto.PersonDto;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "name", target = "name")
    PersonDto personToPersonDto(Person person);

    @Mapping(source = "lastName", target = "lastName")
    Person personDtoToPerson(PersonDto personDto);

    default PersonDto stringToPersonDto(String[] personFromString) {
        return PersonDto.builder()
                .name(personFromString[1])
                .lastName(personFromString[0])
                .age(Integer.parseInt(personFromString[2]))
                .classroom(Integer.parseInt(personFromString[3]))
                .physics(Integer.parseInt(personFromString[4]))
                .mathematics(Integer.parseInt(personFromString[5]))
                .rus(Integer.parseInt(personFromString[6]))
                .literature(Integer.parseInt(personFromString[7]))
                .geometry(Integer.parseInt(personFromString[8]))
                .informatics(Integer.parseInt(personFromString[9]))
                .build();
    }
}
