package com.QuizTime.QuizTime.model.entity;

import com.QuizTime.QuizTime.model.entity.Chat.conversation.ChatConversation;
import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "teachers")
public class Teacher extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String speciality;
    @OneToMany(mappedBy = "teacher",fetch = FetchType.LAZY)
    private List<Quiz> quizList;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<ChatConversation> conversations;

    /*

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

     */

}
