package com.android.tottenham;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MyViewHolder> {


    //------------------Click Event------------------
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
   }

   private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }
    //------------------Click Event------------------



    private ArrayList<Member> mDataset;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mName;
        public TextView mNumber;
        public ImageView mPicture;

        MyViewHolder(View v) {
            super(v);
            mName = v.findViewById(R.id.tv_name);
            mPicture = v.findViewById(R.id.iv_picture);
            mNumber = v.findViewById(R.id.tv_number);

         //--------------------Click Event--------------------
            // 뷰홀더에서만 리스트 포지션값을 불러올 수 있음.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   
                    int position=getAdapterPosition();//어뎁터 포지션값
                   // 뷰홀더에서 사라지면 NO_POSITION 을 리턴
                    if(position!=RecyclerView.NO_POSITION){
                        if(mListener !=null){
                            mListener.onItemClick(view,position);
                        }
                    }
                }
            });
         //---------------------Click Event---------------------

        }
    }

    // 메인 액티비티에서 받은 myDataset을 가져오
    public MemberAdapter(MainActivity mainActivity, int member, ArrayList<Member> myDataset) {
        mDataset = myDataset;
//
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MemberAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member, parent, false);
                    //     반복할 xml 파일
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // 표시하는 메소드
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //데이터를 받은걸 올리기
        holder.mName.setText(mDataset.get(position).getMember());
        holder.mPicture.setImageResource(mDataset.get(position).getIcon());
        holder.mNumber.setText(mDataset.get(position).getNumber());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
