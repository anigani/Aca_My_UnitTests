package aca;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.meterware.httpunit.DeleteMethodWebRequest;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpNotFoundException;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.PutMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

import aca.data.Post;
import aca.data.Todo;

public class SampleHTTPUnitTest {

	private Todo id;

	@Test
	public void getPostsTest() throws IOException, SAXException {
		// This class manages cookies used to maintain session context, computes
		// relative URLs, and generally emulates the browser behavior needed to build an
		// automated test of a web site.
		WebConversation wc = new WebConversation();

		// Obtain the main page on the meterware web site
		String url = "http://jsonplaceholder.typicode.com/posts";
		WebRequest request = new GetMethodWebRequest(url);
		request.setHeaderField("Accept", "application/json");

		WebResponse response = wc.getResponse(request);

		int responseCode = response.getResponseCode();

		// assert the response code was 200
		Assert.assertEquals(responseCode, 200);
	}

	@Test
	public void getPostsTest3() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		String url = "http://jsonplaceholder.typicode.com/posts";
		WebRequest request = new GetMethodWebRequest(url);
		WebResponse response = wc.getResponse(request);

		String responseType = response.getContentType();

		Assert.assertEquals(responseType, "application/json");
	}

	@Test
	public void getProfileWrongURI() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		String url = "http://jsonplaceholder.typicode.com/profile";
		try {
			WebRequest request = new GetMethodWebRequest(url);

			WebResponse response = wc.getResponse(request);

		} catch (HttpNotFoundException ex) {
			Assert.assertEquals(ex.getResponseCode(), 404);
		}
	}

	@Test
	public void getPostsTest1() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		String url = "http://jsonplaceholder.typicode.com/posts/1";
		WebRequest request = new GetMethodWebRequest(url);
		WebResponse response = wc.getResponse(request);

		Assert.assertTrue(response.getText()
				.contains("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));

		int responseCode = response.getResponseCode();
		// assert the response code was 200
		Assert.assertEquals(responseCode, 200);
	}

	@Test
	public void postComment() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		// Obtain the main page on the meterware web site
		String url = "http://my-json-server.typicode.com/typicode/demo/profile";
		WebRequest request = new PostMethodWebRequest(url);
		WebResponse response = wc.getResponse(request);

		if (response.getResponseCode() != 201 || response.getText().contains("name")) {
			throw new RuntimeException("Failed to create new profile");
		}
	}

	@Test
	public void getComments() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		// Obtain the main page on the meterware web site
		String url = "http://my-json-server.typicode.com/typicode/demo/comments";
		WebRequest request = new GetMethodWebRequest(url);
		// request.setParameter("title", "3");
		WebResponse response = wc.getResponse(request);

		// System.out.println(response.getText());
		// TODO

	}

	@Test
	public void getPostTitleTest() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		String url = "http://jsonplaceholder.typicode.com/posts/1";

		WebRequest request = new GetMethodWebRequest(url);

		WebResponse response = wc.getResponse(request);

		String json = response.getText();

		// Jackson
		// ObjectMapper objectMapper = new ObjectMapper();
		// Post post = objectMapper.readValue(json, Post.class);

		// Gson
		Gson gson = new Gson();
		Post post = gson.fromJson(json, Post.class);

		Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
				post.getTitle());
		Assert.assertEquals(1, post.getUserId());
	}

	@Test
	public void getPosts2Test() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		String url = "http://jsonplaceholder.typicode.com/posts";

		WebRequest request = new GetMethodWebRequest(url);

		WebResponse response = wc.getResponse(request);

		String json = response.getText();

		// Gson
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Post>>() {}.getType();
		List<Post> posts = gson.fromJson(json, listType);

		Assert.assertEquals(100, posts.size());
		Post p1 = posts.get(0);
		Assert.assertNotNull(p1.getTitle());
		Assert.assertNotNull(p1.getTitle());
	}

	@Test
	public void getTodosTest() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		String url = "http://jsonplaceholder.typicode.com/todos/1";

		WebRequest request = new DeleteMethodWebRequest(url);

		WebResponse response = wc.getResponse(request);

		Assert.assertEquals(200, response.getResponseCode());

	}

	@Test
	public void postTodosTest() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		String url = "http://jsonplaceholder.typicode.com/todos";

		Gson gson = new Gson();
		Todo todo = new Todo(1, null, "delectus aut autem", false);
		String json = gson.toJson(todo);

		WebRequest request = new PostMethodWebRequest(url, new ByteArrayInputStream(json.getBytes()), "application/json");

		WebResponse response = wc.getResponse(request);

		Assert.assertEquals(200, response.getResponseCode());

	}
	
	@Test
	public void putTodosTest() throws IOException, SAXException {
		WebConversation wc = new WebConversation();

		String url = "http://jsonplaceholder.typicode.com/todos";

		Gson gson = new Gson();
		Todo todo = new Todo(1, null, "delectus aut autem", false);
		String json = gson.toJson(todo);

		WebRequest request = new PutMethodWebRequest(url, new ByteArrayInputStream(json.getBytes()), "application/json");

		WebResponse response = wc.getResponse(request);

		Assert.assertEquals(200, response.getResponseCode());

	}
}
