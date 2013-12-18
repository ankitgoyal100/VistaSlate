package com.goyalgadgets.vistaslate;

import com.goyalgadgets.vistaslate.ServicesActivity.ViewAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class NewsActivity extends Activity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.news);

		final TextView queue = (TextView) findViewById(R.id.queue);
		queue.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {

				}

				NewsActivity.this.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						queue.setText(((int) (Math.random() * 5) + 10) + " in queue");
					}
				});
			}
		}).start();

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ViewAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				if (position == 0) {
					Intent intent = new Intent(NewsActivity.this, ESPNActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	public class ViewAdapter extends BaseAdapter {
		private Context context;

		public ViewAdapter(Context c) {
			context = c;
		}

		public int getCount() {
			return 6;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		// create a new ImageView for each item referenced by the Adapter
		public View getView(int position, View convertView, ViewGroup parent) {
			RelativeLayout layout;
			TextView textView;
			ImageView imageView;
			if (convertView == null) { // if it's not recycled, initialize some
										// attributes
				layout = new RelativeLayout(context);
				layout.setLayoutParams(new GridView.LayoutParams(750, 750));

				layout.setBackgroundColor(Color.rgb(215, 31, 39));

				imageView = new ImageView(context);
				imageView.setTag(4);
				imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
				layout.addView(imageView);

				textView = new TextView(context);
				textView.setTag(3);
				textView.setVisibility(View.GONE);
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(670, 670);
				params.setMargins(40, 40, 40, 40);
				textView.setLayoutParams(params);
				textView.setTextSize(20);
				textView.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Bold.otf"));
				textView.setTextColor(Color.rgb(255, 255, 255));
				layout.addView(textView);
			} else {
				layout = (RelativeLayout) convertView;
				textView = (TextView) layout.findViewWithTag(3);
				imageView = (ImageView) layout.findViewWithTag(4);
			}

			if (position == 0) {
				textView.setText("ESPN");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.jrsmith));
			}
			if (position == 1) {
				textView.setText("USA Today");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.suprs));
			}
			if (position == 2) {
				textView.setText("theguardian");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.seattle));
			}
			if (position == 3) {
				textView.setText("Springer");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.vangundy));
			}
			if (position == 4) {
				textView.setText("CrunchBase");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.crunchbase));

			}
			if (position == 5) {
				textView.setText("Univision.com");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.univision));

			}
			return layout;
		}
	}

}
