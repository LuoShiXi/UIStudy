package com.example.test1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends Activity {

	ListView lv;
	
	String[] names = {"成龙", "李连杰" , "胡歌"};
	int[] imgs = {R.drawable.item1, R.drawable.item2, R.drawable.item4};
	int[] icons = {R.drawable.touxiang003,R.drawable.touxiang005, R.drawable.touxiang006};
	String[] contents = {"今天谢谢大家，感谢你们的到来！！！", "今天我吃的水煮肉片！！！" ,"今天的天很冷，我还没来得及买棉服穿！！！"};
	
	List<Message> list = new ArrayList<Message>();
	
//	M     V      C
	
	MyAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		//自定义标题
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_second);
        //设置标题为某个layout
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);

		
		lv = (ListView) findViewById(R.id.lv);
		
		addData();
		
		adapter = new MyAdapter();
		
		lv.setAdapter(adapter);
	}
	
	public void addData(){
		
		int x = 0;
		
		for(int i = 0; i < 100; i++){
			
			x = i % 3;
			
			Message m = new Message();
			m.img = imgs[x];
			m.name = names[x];
			m.icon = icons[x];
			m.content = contents[x];
			m.time = "19:25";
			list.add(m);
		}
	}
	
	
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
//			LayoutInflater inflater = getLayoutInflater();
			LayoutInflater inflater = LayoutInflater.from(SecondActivity.this);		
			View v = inflater.inflate(R.layout.item, null);
			
			ImageView iv1 = (ImageView) v.findViewById(R.id.iv1);
			TextView name = (TextView) v.findViewById(R.id.name);
			TextView content = (TextView) v.findViewById(R.id.content);
			ImageView iv2 = (ImageView) v.findViewById(R.id.iv2);
			TextView time = (TextView) v.findViewById(R.id.time);
					
			Message m = (Message) getItem(position);
			iv1.setImageResource(m.img);
			name.setText(m.name);
			content.setText(m.content);
			iv2.setImageResource(m.icon);
			time.setText(m.time);
			
			return v;
		}
		
	}
	
}
