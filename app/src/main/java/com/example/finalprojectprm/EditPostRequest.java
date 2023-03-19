package com.example.finalprojectprm;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import Model.Category;
import Model.Tag;
import Model.User;
import Model.Wish;

public class EditPostRequest {
    private UUID id;
    private String name;
    private String image;
    private String description;
    private BigDecimal price;
}
