package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
public class ReviewDto {
    private String reviewerName;
    private LocalDate reviewDate;
    private String reviewContent;
    private int rating;
    private String movieName;
}
