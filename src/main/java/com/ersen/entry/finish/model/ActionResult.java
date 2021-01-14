package com.ersen.entry.finish.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ActionResult {
    private Boolean success;
    private String message;
}
