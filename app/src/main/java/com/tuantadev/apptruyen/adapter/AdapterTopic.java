package com.tuantadev.apptruyen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuantadev.apptruyen.R;
import com.tuantadev.apptruyen.Inter.ITopic;
import com.tuantadev.apptruyen.UI.Topic;


public class AdapterTopic extends RecyclerView.Adapter<AdapterTopic.TopicViewHolder>{
    private ITopic inter;
    private int [] img = {R.drawable.im_28, R.drawable.im_2, R.drawable.im_3, R.drawable.im_4, R.drawable.im_5,
            R.drawable.im_6, R.drawable.im_7, R.drawable.im_10, R.drawable.im_12, R.drawable.im_13,
            R.drawable.im_14, R.drawable.im_15, R.drawable.im_22,R.drawable.im_27, R.drawable.im_1, };

    public AdapterTopic(ITopic inter) {
        this.inter = inter;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_topic,viewGroup,false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TopicViewHolder topicViewHolder, int i) {
        Topic topic=inter.getTopic(i);
        topicViewHolder.tvTopic.setText(topic.getName());
        topicViewHolder.ivTopic.setImageResource(img[i]);
//        topicViewHolder.ivNext.setImageResource(R.drawable.home_arrow);
        topicViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inter.onClick(topicViewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return inter.getSize();
    }

    static class TopicViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTopic;
        private ImageView ivTopic;
//        private ImageView ivNext;
        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTopic=itemView.findViewById(R.id.tv_topic);
            ivTopic=itemView.findViewById(R.id.iv_topic);
//            ivNext=itemView.findViewById(R.id.iv_next);
        }
    }

}
