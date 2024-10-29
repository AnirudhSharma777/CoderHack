package com.example.coderHack.Enitities;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User {

    @Id
    private Integer userId;
    private String username;
    private int score = 0;
    private List<String> badges = new ArrayList();

    public void updateBadges() {
        badges.clear();
        if (score >= 1 && score < 30) {
            badges.add("Code Ninja");
        } else if (score >= 30 && score < 60) {
            badges.add("Code Champ");
        } else if (score >= 60) {
            badges.add("Code Master");
        }
    }

}
