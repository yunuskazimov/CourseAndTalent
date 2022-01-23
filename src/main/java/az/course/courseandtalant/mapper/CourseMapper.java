package az.course.courseandtalant.mapper;

import az.course.courseandtalant.dao.course.entity.CourseEntity;
import az.course.courseandtalant.model.courseDto.CourseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lesson.course", ignore = true)
    @Mapping(target = "price.course", ignore = true)
    @Mapping(target = "location.course", ignore = true)
    @Mapping(target = "certificate.course", ignore = true)
    @Mapping(target = "address.course", ignore = true)
    CourseEntity toCourseEntity(CourseDto dto);

    CourseDto toCourseDto(CourseEntity entity);

    List<CourseDto> toCourseDtoList(List<CourseEntity> entityList);
}
