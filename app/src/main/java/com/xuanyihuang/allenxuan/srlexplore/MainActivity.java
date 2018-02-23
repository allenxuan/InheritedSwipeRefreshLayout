package com.xuanyihuang.allenxuan.srlexplore;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xuanyihuang.allenxuan.inheritedswiperefreshlayout.InheritedSwipeRefreshLayout;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private InheritedSwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new MyAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        swipeRefreshLayout = findViewById(R.id.srl);
        swipeRefreshLayout.setCustomHeaderLayout(R.layout.isrl_default_header_layout_60dp, 60);
        swipeRefreshLayout.setOnRefreshListener(new InheritedSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                CountDownTimer countDownTimer = new CountDownTimer(3000,3000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }.start();
            }
        });

        recyclerView.invalidate();
    }


    static class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        int[] data = new int[20];

        MyAdapter(){
            for(int i = 0; i < 20; i++){
                data[i] = i;
            }
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText("This is " +  data[position]);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        static class MyViewHolder extends RecyclerView.ViewHolder{
            View viewroot;
            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                viewroot = itemView;
                textView = viewroot.findViewById(R.id.tv);
            }
        }
    }
}
