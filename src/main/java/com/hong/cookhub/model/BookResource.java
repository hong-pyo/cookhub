package com.hong.cookhub.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
