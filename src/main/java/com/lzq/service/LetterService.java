package com.lzq.service;

import com.lzq.common.ResultInfo;
import com.lzq.pojo.Letter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterService {
    ResultInfo.Result createLetter(Letter letter);

    List<Letter> getLettersByUserId(int userId);

    List<Letter> getLettersByReplyUserId(int userId);

    List<Letter> getRandomNewLettersFilterUser(int userId);

    Letter getLetterByLetterId(int letterId);

    ResultInfo.Result updateLetter(Letter letter);

    ResultInfo.Result deleteLetter(int letterId);
}
