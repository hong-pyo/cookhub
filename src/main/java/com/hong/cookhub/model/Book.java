package com.hong.cookhub.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


/**
 * Created by hong2 on 2018. 10. 2.
 * Time : AM 12:05
 */

@Getter
@Setter
public class Book {

    private String bookId;
    private String name;
    private String author;
    /*@JsonFormat(pattern = "yyyy/mm/dd")
    private LocalDate localDate;*/
    private BookPublisher publisher;
}
