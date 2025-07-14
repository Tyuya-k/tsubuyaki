package jp.kobe_u.cs.daikibo.tsubuyaki.repository;

import java.util.List; // Listをインポート
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobe_u.cs.daikibo.tsubuyaki.entity.Tsubuyaki;

@Repository
public interface TsubuyakiRepository extends CrudRepository<Tsubuyaki, Long> {
    /**
     * ★追加: コメントに指定したキーワードが含まれるつぶやきを検索する
     * @param comment 検索キーワード
     * @return 見つかったつぶやきのリスト
     */
    List<Tsubuyaki> findByCommentContaining(String comment);
}