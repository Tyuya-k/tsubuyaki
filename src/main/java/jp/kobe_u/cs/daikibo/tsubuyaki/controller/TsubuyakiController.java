package jp.kobe_u.cs.daikibo.tsubuyaki.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam; // ★追加

import jp.kobe_u.cs.daikibo.tsubuyaki.entity.Tsubuyaki;
import jp.kobe_u.cs.daikibo.tsubuyaki.service.TsubuyakiService;

@Controller
public class TsubuyakiController {
    @Autowired
    TsubuyakiService ts;

    // タイトル画面を表示
    @GetMapping("/")
    String showIndex() {
        return "index";
    }

    /**
     * ★修正: メイン画面の表示。検索機能を追加
     * @param keyword (オプショナル) 検索キーワード
     * @param model
     * @return
     */
    @GetMapping("/read")
    String showTsubuyakiList(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Tsubuyaki> list;
        // keywordが指定されていれば検索、なければ全件取得
        if (keyword != null && !keyword.isEmpty()) {
            list = ts.searchTsubuyaki(keyword);
            model.addAttribute("keyword", keyword); // 検索キーワードをモデルに追加
        } else {
            list = ts.getAllTsubuyaki();
        }

        model.addAttribute("tsubuyakiList", list);
        model.addAttribute("tsubuyakiForm", new Tsubuyaki());
        return "tsubuyaki_list";
    }

    //つぶやきを投稿
    @PostMapping("/read")
    String postTsubuyaki(@ModelAttribute("tsubuyakiForm") Tsubuyaki form, Model model) {
        // TsubuyakiFormからTsubuyakiエンティティへの移し替えは不要になりました
        // ※TsubuyakiFormが不要なため
        ts.postTsubuyaki(form);
        return "redirect:/read";
    }
}