package com.hong.cookhub.model;


import lombok.Getter;
import lombok.Setter;



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
