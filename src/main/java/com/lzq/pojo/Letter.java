package com.lzq.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Letter {
    @NonNull
    private int letterId;

    private String letterTheme;

    private int letterUid;

    private String letterContent;

    private int replyUid;

    private Timestamp letterTime;

    private int sendRead;

    private int replyRead;

    private int tag;

}
