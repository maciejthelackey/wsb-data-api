package com.maciej.wsbdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WsbResponse {
    @JsonProperty("no_of_comments")
    int noOfComments;

    String sentiment;

    @JsonProperty("sentiment_score")
    double sentimentScore;

    String ticker;
}
