package com.quinnox.model;


public class Movie {
		
	private String dash_url;
    private String video_bitrate;
    private String audio_bitrate;
    private int video_width;
    private int video_height;
    private long file_size;
    
    public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String dash_url, String video_bitrate, String audio_bitrate, int video_width, int video_height,
			long file_size) {
		super();
		this.dash_url = dash_url;
		this.video_bitrate = video_bitrate;
		this.audio_bitrate = audio_bitrate;
		this.video_width = video_width;
		this.video_height = video_height;
		this.file_size = file_size;
	}

	@Override
	public String toString() {
		return "Movie [dash_url=" + dash_url + ", video_bitrate=" + video_bitrate + ", audio_bitrate=" + audio_bitrate
				+ ", video_width=" + video_width + ", video_height=" + video_height + ", file_size=" + file_size + "]";
	}

	public String getDash_url() {
		return dash_url;
	}

	public void setDash_url(String dash_url) {
		this.dash_url = dash_url;
	}

	public String getVideo_bitrate() {
		return video_bitrate;
	}

	public void setVideo_bitrate(String video_bitrate) {
		this.video_bitrate = video_bitrate;
	}

	public String getAudio_bitrate() {
		return audio_bitrate;
	}

	public void setAudio_bitrate(String audio_bitrate) {
		this.audio_bitrate = audio_bitrate;
	}

	public int getVideo_width() {
		return video_width;
	}

	public void setVideo_width(int video_width) {
		this.video_width = video_width;
	}

	public int getVideo_height() {
		return video_height;
	}

	public void setVideo_height(int video_height) {
		this.video_height = video_height;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
    
    
}
