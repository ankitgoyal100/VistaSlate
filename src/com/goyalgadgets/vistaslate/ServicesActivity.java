package com.goyalgadgets.vistaslate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ServicesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView queue = (TextView) findViewById(R.id.queue);
		queue.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {

				}

				ServicesActivity.this.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						queue.setText(((int) (Math.random() * 5) + 10) + " in queue");
					}
				});
			}
		}).start();

		EditText searchBar = (EditText) findViewById(R.id.editText1);
		searchBar.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ViewAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				if (position == 0) {
					Intent intent = new Intent(ServicesActivity.this, NewAccountActivity.class);
					startActivity(intent);
				}
				if (position == 3) {
					Intent intent = new Intent(ServicesActivity.this, JoinTripActivity.class);
					startActivity(intent);
				}
				if (position == 5) {
					Intent intent = new Intent(ServicesActivity.this, ESPNActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
			LinearLayout layout;
			TextView textView;
			TextView detailView;
			if (convertView == null) { // if it's not recycled, initialize some
										// attributes
				layout = new LinearLayout(context);
				layout.setLayoutParams(new GridView.LayoutParams(750, 750));
				layout.setOrientation(LinearLayout.VERTICAL);

				layout.setBackgroundColor(Color.rgb(156, 0, 14));

				textView = new TextView(context);
				textView.setTag(3);
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				params.setMargins(40, 40, 0, 0);
				textView.setLayoutParams(params);
				textView.setTextSize(60);
				textView.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Bold.otf"));
				textView.setTextColor(Color.rgb(255, 255, 255));
				layout.addView(textView);

				detailView = new TextView(context);
				detailView.setTag(4);
				params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				params.setMargins(40, 10, 0, 0);
				detailView.setLayoutParams(params);
				detailView.setTextSize(40);
				detailView.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));
				detailView.setTextColor(Color.rgb(255, 255, 255));
				layout.addView(detailView);
			} else {
				layout = (LinearLayout) convertView;
				textView = (TextView) layout.findViewWithTag(3);
				detailView = (TextView) layout.findViewWithTag(4);
			}

			if (position == 0) {
				textView.setText("Resolve");
				detailView.setText("An Account Issue");
			} else if (position == 1) {
				textView.setText("Open");
				detailView.setText("A New Account");
			} else if (position == 2) {
				textView.setText("Acquire");
				detailView.setText("A New Credit Card");
			} else if (position == 3) {
				textView.setText("Secure");
				detailView.setText("A New Loan");
			} else if (position == 4) {
				textView.setText("Other");
				detailView.setText("Branch Services");
			} else if (position == 5) {
				textView.setText("Escape");
				detailView.setText("to News & Entertainment");
			}

			return layout;
		}
	}

}
