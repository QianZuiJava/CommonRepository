package cn.hu.codetoname.testmodel;

import cn.hu.codetoname.annnotion.ConvertCodeToName;
import lombok.Data;

@Data
public class Student {

    @ConvertCodeToName(label = "BaseData", prefix = "Student", dependCode = "genderCode")
    private String genderName;
    private String genderCode;
    private Teacher teacher;

    public Student(){}

    public Student(String genderName, String genderCode, Teacher teacher) {
        this.genderName = genderName;
        this.genderCode = genderCode;
        this.teacher = teacher;
    }
}
