package az.course.courseandtalant.mapper;

import az.course.courseandtalant.dao.courseSuggest.entity.SuggestCourseEntity;
import az.course.courseandtalant.model.suggestCourseDto.SuggestCourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SuggestCourseMapper {
    SuggestCourseMapper INSTANCE = Mappers.getMapper(SuggestCourseMapper.class);

//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "updatedAt", ignore = true)
//
//    SuggestCourseEntity toSuggestCourseEntity(SuggestCourseDto dto);

    SuggestCourseDto toSuggestCourseDto(SuggestCourseEntity entity);

    List<SuggestCourseDto> toSuggestCourseDtoList(List<SuggestCourseEntity> entityList);
}
