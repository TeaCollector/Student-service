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

    @Mapping(source = "lastname", target = "lastName")
    Person personDtoToPerson(PersonDto personDto);

    default PersonDto fromFileToPersonDto(String[] personArray) {
        return new PersonDto(personArray[1], personArray[0],
                Integer.parseInt(personArray[2]),
                Integer.parseInt(personArray[3]),
                Integer.parseInt(personArray[4]),
                Integer.parseInt(personArray[5]),
                Integer.parseInt(personArray[6]),
                Integer.parseInt(personArray[7]),
                Integer.parseInt(personArray[8]),
                Integer.parseInt(personArray[9]));
    }
}
