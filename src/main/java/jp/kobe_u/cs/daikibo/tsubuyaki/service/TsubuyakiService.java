package jp.kobe_u.cs.daikibo.tsubuyaki.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobe_u.cs.daikibo.tsubuyaki.entity.Tsubuyaki;
import jp.kobe_u.cs.daikibo.tsubuyaki.repository.TsubuyakiRepository;

@Service
public class TsubuyakiService {
    @Autowired
    TsubuyakiRepository repo;

    // つぶやきを投稿
    public Tsubuyaki postTsubuyaki(Tsubuyaki t) {
        String name = t.getName();
        if (name == null || name.length() == 0) {
            t.setName("名無しさん");
        }
        t.setCreatedAt(LocalDateTime.now());
        return repo.save(t);
    }

    // 全つぶやきを取得
    public List<Tsubuyaki> getAllTsubuyaki() {
        return (List<Tsubuyaki>) repo.findAll();
    }

    /**
     * ★追加: つぶやきをキーワードで検索する
     * @param keyword 検索キーワード
     * @return 見つかったつぶやきのリスト
     */
    public List<Tsubuyaki> searchTsubuyaki(String keyword) {
        return repo.findByCommentContaining(keyword);
    }
}