package jp.kobe_u.cs.daikibo.tsubuyaki.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Tsubuyaki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String comment;
    LocalDateTime createdAt;

    // setCreatedAtメソッドは書かない。@Dataが自動で作ってくれる。
}