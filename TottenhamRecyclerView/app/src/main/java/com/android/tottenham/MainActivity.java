package com.android.tottenham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Member> data = null;
    private MemberAdapter adapter = null;
    private ListView listView = null;
    private RecyclerView recyclerView = null;
  //  private RecyclerView.Adapter mAdapter = null;
    private RecyclerView.LayoutManager layoutManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<Member>();
//데이터 어레이리스트에 넣어버리기 (이름,사진,등번호)

        data.add(new Member("Hugo Lloris", R.drawable.firstteam_hugolloris, "1"));
        data.add(new Member("Matt Doherty", R.drawable.firstteam_mattdoherty, "2"));
        data.add(new Member("Sergio Reguilon", R.drawable.firstteam_sergioreguilon, "3"));
        data.add(new Member("Toby Alderweireld", R.drawable.firstteam_tobyalderweireld, "4"));
        data.add(new Member("Pierre-emile Hojbjerg", R.drawable.firstteam_pierreemilehojbjerg, "5"));
        data.add(new Member("Davinson Sanchez", R.drawable.firstteam_davinsonsanchez, "6"));
        data.add(new Member("Heung Min Son", R.drawable.firstteam_heungminson, "7"));
        data.add(new Member("Harry Winks", R.drawable.firstteam_harrywinks, "8"));
        data.add(new Member("Gareth Bale", R.drawable.firstteam_garethbale_new, "9"));
        data.add(new Member("Harry Kane", R.drawable.firstteam_harrykane, "10"));
        data.add(new Member("Eric Lamela", R.drawable.firstteam_eriklamela, "11"));
        data.add(new Member("Joe Hart", R.drawable.firstteam_joehart, "12"));
        data.add(new Member("Joe Rodon", R.drawable.firstteam_joerodon, "13"));
        data.add(new Member("Eric Dier", R.drawable.firstteam_ericdier, "14"));
        data.add(new Member("Moussa Sissoko", R.drawable.firstteam_moussasissoko, "17"));
        data.add(new Member("Giovani Lo Celso", R.drawable.firstteam_giovanilocelso, "18"));
        data.add(new Member("Dele Ali", R.drawable.firstteam_delealli, "20"));
        data.add(new Member("Paulo Gazzaniga", R.drawable.firstteam_paulogazzaniga, "22"));
        data.add(new Member("Steven Bergwijn", R.drawable.firstteam_stevenbergwijn, "23"));
        data.add(new Member("Serge Aurier", R.drawable.firstteam_sergeaurier, "24"));
        data.add(new Member("Japhet Tanganga", R.drawable.firstteam_japhettanganga, "25"));
        data.add(new Member("Lucas Moura", R.drawable.firstteam_lucasmoura, "27"));
        data.add(new Member("Tanguy Ndombele", R.drawable.firstteam_tanguyndombele, "28"));
        data.add(new Member("Ben Davis", R.drawable.firstteam_bendavies, "33"));
        data.add(new Member("Carlos Vinicius", R.drawable.firstteam_carlosvinicius, "45"));


//        adapter = new MemberAdapter(MainActivity.this, R.layout.member, data);

        //리사이클러뷰에 있는 아이디를 찾기
        recyclerView = (RecyclerView) findViewById(R.id.lv_member);
                //리사이클러뷰 규격 만들기
        recyclerView.setHasFixedSize(true);




        //레이아웃 매니저 만들기
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //리사이클러뷰 어댑터를 넣기
        adapter = new MemberAdapter(MainActivity.this, R.layout.member, data);
        //어댑터에게 보내기
        recyclerView.setAdapter(adapter);


        //------------------------------Click Event------------------------------
        adapter.setOnItemClickListener(new MemberAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this,"Hugo Lloris",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"Matt Doherty",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"Sergio Reguilon",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this,"Toby Alderweireld",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this,"Pierre-emile Hojbjerg",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //------------------------------Click Event------------------------------


//        recyclerView.setOnContextClickListener(mClickListener);






    }




    //    AdapterView.OnItemClickListener mClickListener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//
//            switch (position){
//                case 0:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 1:intent.setData(Uri.parse("https://www.youtube.com/watch?v=vHuX3xM0Mbc"));
//                case 2:intent.setData(Uri.parse("https://www.youtube.com/watch?v=pafK2yk36Bs"));
//                case 3:intent.setData(Uri.parse("https://www.youtube.com/watch?v=XlLRGqTMCGQ"));
//                case 4:intent.setData(Uri.parse("https://www.youtube.com/watch?v=pG-o5OX1vds"));
//                case 5:intent.setData(Uri.parse("https://www.youtube.com/watch?v=ltu17rgahI8"));
//                case 6:intent.setData(Uri.parse("https://www.youtube.com/watch?v=c_vRVVAOY0U"));
//                case 7:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 8:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 9:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 10:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 11:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 12:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 13:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 14:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 15:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//                case 16:intent.setData(Uri.parse("https://www.youtube.com/watch?v=IKypp2_UDLM"));
//            }
//
//        }
//    };

}

