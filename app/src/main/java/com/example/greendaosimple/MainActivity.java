package com.example.greendaosimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.greendaosimple.db.AppItemBeam;
import com.example.greendaosimple.db.AppItemDBHelper;
import com.example.greendaosimple.db.AppSortBean;
import com.example.greendaosimple.db.DaoManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private  int sortIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaoManager.getInstance().init(this);
//        for (int i = 0 ; i < 5; i++) {
//            AppSortBean sortBean = new AppSortBean();
//            sortBean.setAppId("111111");
//            sortBean.setName("测试");
//            sortBean.setSort(sortIndex);
//            sortIndex++ ;
//            boolean flag = DaoManager.getInstance().insertMeizi(sortBean);
//
//            Log.e("MyApplication", "flag-----"+flag);
//        }


        DaoManager.getInstance().getDaoSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 5; i++) {
                    AppSortBean sortBean = new AppSortBean();
                    sortBean.setAppId(i+"");
                    sortBean.setName("测试");
                    sortBean.setSort(sortIndex);
                    sortIndex++;
                    DaoManager.getInstance().getDaoSession().insertOrReplace(sortBean);
                }
            }
        });

        findViewById(R.id.delete_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoManager.getInstance().deleteAll();
                Toast.makeText(MainActivity.this, "删除所有", Toast.LENGTH_SHORT).show();
            }
        });


        findViewById(R.id.update_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppSortBean appSortBean = new AppSortBean();
                appSortBean.setAutoId(81l);
                appSortBean.setName("BAIDU");
                DaoManager.getInstance().updateAppSortBean(appSortBean);
                Toast.makeText(MainActivity.this, "修改数据", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.query_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<AppSortBean> appSortBeans = DaoManager.getInstance().queryAllAppSortBean();
                Log.e("MainActivity", "appSortBeans---------"+appSortBeans);
            }
        });

        findViewById(R.id.init_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean appItemBeam = AppItemDBHelper.getInstance().insertAppItemBeam(new AppItemBeam());
                Log.e("MainActivity", "appSortBeans---------"+appItemBeam);
                Toast.makeText(MainActivity.this, "创建数据库", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
