package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TagsModel {

    int id;
    @JsonProperty("feed_id")
    int feedId;
    String name;
}
