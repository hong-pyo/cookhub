package com.hong.cookhub.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by hong2 on 2018. 10. 4.
 * Time : AM 1:52
 */

@Getter
@Setter
public class BookResourceQuery implements Serializable {
    private String name;
    private String author;
}
