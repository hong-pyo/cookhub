package com.hong.cookhub.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by hong2 on 2018. 10. 6.
 * Time : PM 5:32
 */

@Getter
@Setter
public class BookPublisher implements Serializable {
    private String name;
    private String tel;
}
