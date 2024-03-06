package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.time.LocalDate;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {
    private String reviewerName;
    private LocalDate reviewDate;
    private String reviewContent;
    private int rating;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Movie movie;
}

