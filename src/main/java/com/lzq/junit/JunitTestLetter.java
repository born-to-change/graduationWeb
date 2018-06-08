package com.lzq.junit;

import com.lzq.mapper.LetterMapper;
import com.lzq.pojo.Letter;
import com.lzq.utils.IDUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class JunitTestLetter {
    @Test
    public void testCreateLetter() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        LetterMapper mapper = ac.getBean(LetterMapper.class);
        Letter letter = new Letter();
        letter.setLetterTheme("怎么学编程");
        letter.setLetterContent("刚来工大的工科大一新生，两个月后，刚步入大学的新鲜感就不复存在了，" +
                "感觉舍友都在打游戏，瞎整些没用的，我完全跟他们走不到一块。我想努力干出点成绩，但不知到该怎么做，" +
                "眼看就要大二了，充满了对未来走向社会的担忧，我不算很出类拔萃的学生，但是我敢想敢做，只是不想虚度青春，" +
                "请学长传授点经验，教训也行，大学如果让你从头来过，你会做什么，怎么度过自己的大学？");
        letter.setLetterUid(8);
        letter.setLetterTime(new Timestamp(System.currentTimeMillis()));
        letter.setReplyRead(0);
        mapper.createLetter(letter);

    }


}
