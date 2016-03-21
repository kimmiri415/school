package com.movie.web.global;

public class ActionForward {
	public boolean redirect;
	private String path = null;
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private String url;
	@Override
	public String toString() {
		return "ActionForward [redirect=" + redirect + ", path=" + path + ", url=" + url + "]";
	}
	
}
