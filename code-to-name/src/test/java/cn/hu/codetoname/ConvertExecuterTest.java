package cn.hu.codetoname;

import cn.hu.codetoname.testmodel.Student;
import cn.hu.codetoname.testmodel.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertExecuterTest {

    @Autowired
    private ConvertExecuter convertExecuter;

    @Test
    public void testExecute(){
        Student student = new Student("", "MAN", new Teacher("", "JAVA"));
        convertExecuter.language("zh-cn").append(student).execute();
        System.out.println("SUCCESS");
    }
}
