package com.hong.cookhub.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by hong2 on 2018. 10. 2.
 * Time : AM 12:00
 */

@Getter
@Setter

public class BookResource implements Serializable {

    private String bookId;
    private String name;
    private String author;
    /*@JsonFormat(pattern = "yyyy/mm/dd")
    private LocalDate localDate;*/
    private BookPublisher publisher;

}
