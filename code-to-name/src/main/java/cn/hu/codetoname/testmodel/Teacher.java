package cn.hu.codetoname.testmodel;

import cn.hu.codetoname.annnotion.ConvertCodeToName;
import lombok.Data;

@Data
public class Teacher {
    // 课程名称
    @ConvertCodeToName(label = "GlobalBaseData", prefix = "cn_hu*course", dependCode = "courseCode")
    private String courseName;
    // 课程编码
    private String courseCode;

    public Teacher(){}

    public Teacher(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }
}
