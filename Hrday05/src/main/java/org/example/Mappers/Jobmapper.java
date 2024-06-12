package org.example.Mappers;

import org.example.dto.JobDto;
import org.example.modle.Job;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface Jobmapper {
    Jobmapper INSTANCE = Mappers.getMapper(Jobmapper.class);



    JobDto toJob(Job j);


}
