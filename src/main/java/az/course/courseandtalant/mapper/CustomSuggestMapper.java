package az.course.courseandtalant.mapper;

import az.course.courseandtalant.dao.courseSuggest.entity.SuggestCourseEntity;
import az.course.courseandtalant.dao.courseSuggest.entity.SuggestCourseStepEntity;
import az.course.courseandtalant.model.suggestCourseDto.SuggestCourseDto;
import az.course.courseandtalant.model.suggestCourseDto.SuggestCourseStepDto;

import java.util.ArrayList;
import java.util.List;

public class CustomSuggestMapper {
    public static SuggestCourseEntity toSuggestCourseEntity(SuggestCourseDto dto) {
        SuggestCourseEntity entity = new SuggestCourseEntity();
        entity.setId(dto.getId());
        entity.setSearchKeys(dto.getSearchKeys());
        entity.setName(dto.getName());
        entity.setSteps(toCourseEntityList(dto.getSteps()));

        return entity;
    }

    public static SuggestCourseStepEntity toStepEntity(SuggestCourseStepDto dto) {
        SuggestCourseStepEntity entity = new SuggestCourseStepEntity();
        entity.setStepName(dto.getStepName());
        entity.setLevel(dto.getLevel());
        entity.setTitle(dto.getTitle());
        return entity;
    }

    public static List<SuggestCourseStepEntity> toCourseEntityList(List<SuggestCourseStepDto> dtoList) {
        if (dtoList == null) {
            return null;
        } else {
            ArrayList<SuggestCourseStepEntity> list = new ArrayList<SuggestCourseStepEntity>(dtoList.size());

            for (SuggestCourseStepDto dto : dtoList) {
                list.add(toStepEntity(dto));
            }
            return list;
        }
    }
}
