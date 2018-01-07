package com.example.room.viewmodel;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.room.R;

/**
 * ViewModel作为UI的辅助类，负责管理UI相关的数据
 *  当配置更改时，ViewHold将会自动保存，
 */
public class ViewModelActivity extends AppCompatActivity {
    private TextView tvUsername, tvAddress;

    private DemoViewHolder mDemoViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        tvUsername = findViewById(R.id.tv_username);
        tvAddress = findViewById(R.id.tv_address);

        mDemoViewHolder.getUserInfo().observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(@Nullable UserEntity userEntity) {
                if (userEntity == null) {
                    return;
                }
                tvUsername.setText(userEntity.getUsername());
                tvAddress.setText(userEntity.getAddress());
            }
        });


    }

    public void onClick(View view) {
        mDemoViewHolder.requestUserInfo();
    }


}
