package az.course.courseandtalant.service.impl;

import az.course.courseandtalant.dao.course.entity.CourseEntity;
import az.course.courseandtalant.dao.course.repository.CourseRepo;
import az.course.courseandtalant.error.exception.CourseNotFoundException;
import az.course.courseandtalant.mapper.CourseMapper;
import az.course.courseandtalant.model.courseDto.CourseDto;
import az.course.courseandtalant.service.CourseService;
import az.course.courseandtalant.util.CourseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static az.course.courseandtalant.error.exception.ErrorCodes.NOT_FOUND;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;
    private final CourseUtil courseUtil;

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        log.info("createCourse started with course id :{}", courseDto.getId());
        courseDto.setSearchKeys(makeSearchKey(courseDto));
        return courseMapper.toCourseDto(
                courseRepo.save(courseMapper.toCourseEntity(courseDto)));
    }

    private String makeSearchKey(CourseDto courseDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(courseDto.getCourseName().toLowerCase(Locale.ROOT));
        sb.append(" ");
        sb.append(courseDto.getCategory().toLowerCase(Locale.ROOT));
        sb.append(" ");
        sb.append(courseDto.getCompanyName().toLowerCase(Locale.ROOT));
        sb.append(" ");
        sb.append(courseDto.getAddress().getDistrict().toLowerCase(Locale.ROOT));
        sb.append(" ");
        sb.append(courseDto.getCourseTypeEnum().name().toLowerCase(Locale.ROOT));
        return sb.toString();
    }

    @Override
    public CourseDto editCourse(CourseDto courseDto) {
        log.info("editCourse started with course id :{}", courseDto.getId());
        courseUtil.findById(courseDto.getId());
        courseDto.setSearchKeys(makeSearchKey(courseDto));
        return courseMapper.toCourseDto(
                courseRepo.save(courseMapper.toCourseEntity(courseDto)));
    }

    @Override
    public List<CourseDto> getCourse() {
        log.info("getCourse started");
        return courseMapper.toCourseDtoList(courseRepo.findAll());
    }

    @Override
    public CourseDto getByName(String courseName) {
        log.info("getByName started course name : {}", courseName);
        return courseMapper.toCourseDto(
                courseUtil.findByCourseName(courseName));
    }

    @Override
    public List<CourseDto> getByNameContains(String searchKey) {

        log.info("getByNameContains started search key : {}", searchKey);
        String search = searchKey.toLowerCase(Locale.ROOT);
        return courseMapper.toCourseDtoList(
                courseUtil.findBySearchKeysContains(search));
    }

    @Override
    public List<CourseDto> getByCountryIsGlobal(boolean check) {

        log.info("getByCountryIsGlobal started check key : {}", check);
            return courseMapper.toCourseDtoList(
                    courseUtil.findByCountry(check));
    }

    @Override
    public List<CourseDto> getByPrice(long minPrice, long maxPrice) {
        log.info("getByNameContains started min Price: {}, .max Price : {}", minPrice, maxPrice);
        List<CourseEntity> courseEntityList = courseRepo.findAll();
        List<CourseEntity> newList = courseEntityList
                .stream()
                .filter(courseEntity ->
                        courseEntity.getPrice().getTotalPrice() >= minPrice &&
                                courseEntity.getPrice().getTotalPrice() <= maxPrice)
                .collect(Collectors.toList());

        if (newList.isEmpty()) {
            throw new CourseNotFoundException(NOT_FOUND);
        } else {
            return courseMapper.toCourseDtoList(newList);
        }

    }
}
