package com.example.videos;

import com.example.drawerlayout.R;
import com.example.drawerlayout.R.id;
import com.example.drawerlayout.R.layout;
import com.example.drawerlayout.R.menu;
import com.example.util.DeveloperKey;
import com.example.widget.YouTubeFailureRecoveryActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ActivityVideosReutilizar extends YouTubeFailureRecoveryActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videos_reutilizar);
		
		YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
	    youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
	}

	@Override
	public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
		if (!wasRestored) {
			player.cueVideo("3ixfbOYt4es");
		}
	}

	@Override
	protected YouTubePlayer.Provider getYouTubePlayerProvider() {
		return (YouTubePlayerView) findViewById(R.id.youtube_view);
	}
}
