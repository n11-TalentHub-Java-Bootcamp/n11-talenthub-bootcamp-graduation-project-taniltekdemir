package com.taniltekdemir.n11.bootcampgraduationproject.creditmanager.mapper;

import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplyExtendedSaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.creditapply.dto.ApplySaveEntityDto;
import com.taniltekdemir.n11.bootcampgraduationproject.user.dto.UserSaveEntityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManageMapper {


    ManageMapper INSTANCE = Mappers.getMapper(ManageMapper.class);


    @Mapping(target = "password", source = "tckn")
    UserSaveEntityDto convertToAppAllInfoSaveEntityToUserSaveEntityDto(ApplyExtendedSaveEntityDto applyExtendedSaveEntityDto);

    ApplySaveEntityDto convertToAppAllInfoSaveEntityToApplicationSaveEntityDto(ApplyExtendedSaveEntityDto applyExtendedSaveEntityDto);


}
