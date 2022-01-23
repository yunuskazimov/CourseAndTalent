package az.course.courseandtalant.model.courseDto;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Locale;

public enum CourseTypeEnum {
    OFFLINE, ONLINE, BOTH;

    @JsonValue
    public String toLower() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
