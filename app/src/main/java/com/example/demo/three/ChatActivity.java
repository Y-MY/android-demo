package com.example.demo.three;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.VO.Msg;
import com.example.adapter.MsgRecyclerAdapter;
import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView recyclerView;
    private MsgRecyclerAdapter msgRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_chat);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        initMsgs();

        inputText = (EditText) findViewById(R.id.inputText);
        send = (Button) findViewById(R.id.sendButton);
        recyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        msgRecyclerAdapter = new MsgRecyclerAdapter(msgList);
        recyclerView.setAdapter(msgRecyclerAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String content  = inputText.getText().toString();
                if (!"".equals(content)){
                    Msg msg = new Msg(content ,Msg.TYPE_SEND);
                    msgList.add(msg);
                    //当有新消息时，刷新ListView中的显示
                    msgRecyclerAdapter.notifyItemInserted(msgList.size()-1);
                    //将ListView定位到最后一行
                    recyclerView.scrollToPosition(msgList.size()-1);
                    //清空输入框中的内容
                    inputText.setText("");

                }
            }
        });



    }

    private void initMsgs() {
        for (int i = 0; i < 2; i++) {
            Msg msg1 = new Msg("hello guy", Msg.TYPE_RECEIVED);
            msgList.add(msg1);
            Msg msg2 = new Msg("hello ,what is that?", Msg.TYPE_SEND);
            msgList.add(msg2);
            Msg msg3 = new Msg("this is tom,nice talking to you", Msg.TYPE_RECEIVED);
            msgList.add(msg3);
        }
    }
}
