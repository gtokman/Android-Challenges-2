package com.garytokman.tokmangary_ce06;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.garytokman.tokmangary_ce06.Database.ArticleDatabase;
import com.garytokman.tokmangary_ce06.Database.DatabaseSchema;
import com.garytokman.tokmangary_ce06.Fragments.BookListFragment;
import com.garytokman.tokmangary_ce06.Model.Article;
import com.garytokman.tokmangary_ce06.Model.Articles;

import java.util.List;

// Gary Tokman
// JAV2 - 1609
// MainActivity

public class MainActivity extends AppCompatActivity {

    private static final String LIST_FRAG = "List_Fragment";
    private static final String TAG = "log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add list fragment
        FragmentManager fragmentManager = getFragmentManager();
        Fragment listFragment = fragmentManager.findFragmentByTag(LIST_FRAG);

        if (listFragment == null) {
            listFragment = new BookListFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.list_container, listFragment, LIST_FRAG)
                    .commit();
        }

        // Remove analyze code error "Class not instantiated"
        Log.d(TAG, "onCreate: " + DatabaseSchema.ArticleTable.NAME);


        // Add articles to db
        ArticleDatabase articleDatabase = ArticleDatabase.newInstance(this);
        List<Article> articles = Articles.sArticles();
        for (Article article : articles) {
            articleDatabase.addArticles(article);
        }
    }
}
