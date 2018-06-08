package com.lzq.mapper;

import com.lzq.pojo.Letter;

import java.util.List;

public interface LetterMapper {
    int createLetter(Letter letter);

    List<Letter> getLettersByUserId(int userId);

    List<Letter> getLettersByReplyUserId(int userId);

    List<Letter> getRandomNewLettersFilterUser(int userId);

    Letter getLetterByLetterId(int letterId);

    int updateLetter(Letter letter);

    int deleteLetter(int letterId);
}
