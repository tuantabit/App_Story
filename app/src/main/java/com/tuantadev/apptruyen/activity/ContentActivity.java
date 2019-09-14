package com.tuantadev.apptruyen.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tuantadev.apptruyen.R;
import com.tuantadev.apptruyen.UI.ContentApp;
import com.tuantadev.apptruyen.sql.ManagerSql;


public class ContentActivity extends AppCompatActivity {
    private ManagerSql managerSql;
    private ContentApp content;
    private String name;
    private String conten;
    private TextView tvName;
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        managerSql = new ManagerSql(this);
        int id = getIntent().getIntExtra("IDStory", 0);
        content = managerSql.getContent(id);
        tvName = findViewById(R.id.tv_name_story);
        tvContent = findViewById(R.id.tv_content);

        inits();
    }

    private void inits() {
        name = content.getName();
        conten = content.getContentApp();
        tvName.setText(name);
        tvContent.setText(android.text.Html.fromHtml(conten));

    }
}
