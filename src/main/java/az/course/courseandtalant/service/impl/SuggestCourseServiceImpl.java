package az.course.courseandtalant.service.impl;

import az.course.courseandtalant.dao.courseSuggest.repository.SuggestCourseRepo;
import az.course.courseandtalant.mapper.CustomSuggestMapper;
import az.course.courseandtalant.mapper.SuggestCourseMapper;
import az.course.courseandtalant.model.suggestCourseDto.SuggestCourseDto;
import az.course.courseandtalant.service.SuggestCourseService;
import az.course.courseandtalant.util.SuggestCourseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class SuggestCourseServiceImpl implements SuggestCourseService {
    private final SuggestCourseRepo suggestCourseRepo;
    private final SuggestCourseMapper suggestCourseMapper;
    private final SuggestCourseUtil suggestCourseUtil;

    @Override
    public SuggestCourseDto createSuggestCourse(SuggestCourseDto suggestCourseDto) {
        log.info("createSuggestCourse started with course id :{}", suggestCourseDto.getId());

        suggestCourseDto.setSearchKeys(makeSearchKey(suggestCourseDto));
        return suggestCourseMapper.toSuggestCourseDto(suggestCourseRepo
                .save(CustomSuggestMapper.toSuggestCourseEntity(suggestCourseDto)));
    }

    private String makeSearchKey(SuggestCourseDto suggestCourseDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(suggestCourseDto.getName().toLowerCase(Locale.ROOT));
        suggestCourseDto.getSteps().forEach(steps -> {
            sb.append(" ");
            sb.append(steps.getStepName());
        });

        return sb.toString();
    }

    @Override
    public SuggestCourseDto editSuggestCourse(SuggestCourseDto suggestCourseDto) {
        log.info("editSuggestCourse started with course id :{}", suggestCourseDto.getId());
        suggestCourseUtil.findById(suggestCourseDto.getId());
        suggestCourseDto.setSearchKeys(makeSearchKey(suggestCourseDto));
        return suggestCourseMapper.toSuggestCourseDto(suggestCourseRepo.save(
                CustomSuggestMapper.toSuggestCourseEntity(suggestCourseDto)));
    }

    @Override
    public List<SuggestCourseDto> getSuggestCourse() {
        log.info("getSuggestCourse started");
        return suggestCourseMapper
                .toSuggestCourseDtoList(suggestCourseRepo.findAll());
    }

    @Override
    public SuggestCourseDto getSuggestCourseByName(String courseName) {
        log.info("getSuggestCourseByName started");
        return suggestCourseMapper.toSuggestCourseDto(
                suggestCourseUtil.findByName(courseName));
    }

    @Override
    public SuggestCourseDto getSuggestCourseById(Long id) {
        log.info("getSuggestCourseById started");
        return suggestCourseMapper.toSuggestCourseDto(
                suggestCourseUtil.findById(id));
    }


    @Override
    public List<SuggestCourseDto> getSuggestCourseByNameContains(String searchKey) {
        log.info("getSuggestCourseByNameContains started search key : {}", searchKey);
        String search = searchKey.toLowerCase(Locale.ROOT);
        return suggestCourseMapper.toSuggestCourseDtoList(
                suggestCourseUtil.findBySearchKeysContains(searchKey));
    }
}
