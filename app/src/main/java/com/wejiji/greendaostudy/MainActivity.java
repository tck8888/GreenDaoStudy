package com.wejiji.greendaostudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wejiji.greendaostudy.entity.UserInfo;
import com.wejiji.greendaostudy.gen.UserInfoDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private UserInfoDao mUserInfoDao;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.textView2);

        mUserInfoDao = App.getInstances().getDaoSession().getUserInfoDao();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                addData();
                break;
            case R.id.button2:
                deleteData();
                break;
            case R.id.button3:
                updateData();
                break;
            case R.id.button4:
                findData();
                break;
        }
    }

    private void findData() {
        String userNames = "";
        List<UserInfo> userInfos = mUserInfoDao.loadAll();
        for (int i = 0; i < userInfos.size(); i++) {
            userNames += userInfos.get(i).getNickname();
        }
        mTextView.setText(userNames);
    }

    private void updateData() {
        UserInfo userInfo = new UserInfo((long) 1, "我喜欢你");
        mUserInfoDao.update(userInfo);
    }

    /**
     * 删除数据
     */
    private void deleteData() {
        mUserInfoDao.deleteByKey((long) 2);
    }

    /**
     * 增加一条数据
     */
    private void addData() {
        UserInfo tck = new UserInfo((long) 2, "tzl");
        mUserInfoDao.insert(tck);
    }
}
