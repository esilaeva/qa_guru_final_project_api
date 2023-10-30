package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TagsBodyModel {

    @JsonProperty("feed_id")
    int feedId;
    String name;
}
