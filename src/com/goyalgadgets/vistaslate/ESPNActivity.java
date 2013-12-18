package com.goyalgadgets.vistaslate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ESPNActivity extends Activity {
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_layout);
		context = this;

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ViewAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				if (position == 0)
					openWebURL("http://espn.go.com/new-york/nba/story/_/id/9264714/2013-nba-playoffs-jr-smith-new-york-knicks-questionable-vs-indiana-pacers-fever?ex_cid=espnapi_public");
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
			return 4;
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
				textView.setText("J.R. Smith questionable with fever");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.one));
			}
			if (position == 1) {
				textView.setText("Tony Parker, hot first half help Spurs cool off Warriors");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.two));
			}
			if (position == 2) {
				textView.setText("Atlanta Hawks target Stan Van Gundy as coach -- report");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.three));
			}
			if (position == 3) {
				textView.setText("Seattle group raises bid for Sacramento Kings to $625 million");
				imageView.setImageDrawable(getResources().getDrawable(R.drawable.four));
			}

			return layout;
		}
	}

	public void openWebURL(String inURL) {
		Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(inURL));
		startActivity(browse);
	}

}
