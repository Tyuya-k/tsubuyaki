package jp.kobe_u.cs.daikibo.tsubuyaki.controller;

import lombok.Data;

@Data
public class TsubuyakiForm {
    String name; //投稿者
    
    String comment; //つぶやき（省略不可）

    public Object getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public Object getComment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComment'");
    }
}