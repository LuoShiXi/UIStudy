package com.example.test1;

import com.example.test1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	String[] strs = { "地球战士", "反贪风暴", "危城", "使徒行者", "寒战2", "大话西游3", "绝地反击",
			"世纪战争", "东方主战场", "暗夜归来", "孤独的使者", "探案唐人街", "国家事业", "凛冬", "寒战2", "大话西游3",
			"反贪风暴", "危城", "使徒行者", "寒战2", "大话西游3", "反贪风暴", "危城", "使徒行者", "寒战2" };

	ListView lv;

	ArrayAdapter<String> adapter;

	// MVC
	//
	// model view controller
	// 数据模型 视图 控制器
	// 数据的集合或者数组 ListView 适配器 Adapter

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		//自定义标题
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.listview_test1);
        //设置标题为某个layout
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);

		lv = (ListView) findViewById(R.id.lv);

		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1, strs);

		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(MainActivity.this);
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				return false;
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub

		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);

		Toast.makeText(MainActivity.this,
				"当前点击的是第" + position + "项:" + strs[position],
				Toast.LENGTH_SHORT).show();

	}
}
