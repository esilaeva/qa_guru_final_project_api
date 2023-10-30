package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TagsResponseModel {

    int id;
    @JsonProperty("feed_id")
    int feedId;
    String name;
}
