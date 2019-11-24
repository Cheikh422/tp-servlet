package fr.dta.poei.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import fr.dta.poei.entities.User;

public class UserController {
	private static final String PATH_USER = "/api/user";

	private static User toEntity(String jsonString) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonString, User.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Collection<User> toCollOfEntity(String jsonString) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(jsonString,
					mapper.getTypeFactory().constructCollectionType(Collection.class, User.class));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String toJson(User user) {
		String result = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			result = mapper.writeValueAsString(user);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static User getUserById(Integer id, String cntxPath) {
		return getOrDelete(id, cntxPath + PATH_USER + "/" + id.toString(), "GET");
	}

	public static User deleteUserById(Integer id, String cntxPath) {
		return getOrDelete(id, cntxPath + PATH_USER + "/" + id.toString(), "DELETE");
	}

	public static Collection<User> getAll(String cntxPath) {
		Collection<User> result = null;
		StringBuilder strBuf = new StringBuilder();
		HttpURLConnection cnx = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(cntxPath + PATH_USER + "/all");
			cnx = (HttpURLConnection) url.openConnection();
			cnx.setRequestMethod("GET");
			cnx.setRequestProperty("Accept", "application/json");

			if (cnx.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(cnx.getInputStream(), "utf-8"));
				String output = null;
				while ((output = reader.readLine()) != null) {
					strBuf.append(output);
				}
				result = toCollOfEntity(strBuf.toString());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static User getOrDelete(Integer id, String path, String method) {
		User result = null;
		StringBuilder strBuf = new StringBuilder();
		HttpURLConnection cnx = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(path);
			cnx = (HttpURLConnection) url.openConnection();
			cnx.setRequestMethod(method);
			cnx.setRequestProperty("Accept", "application/json");

			if (cnx.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(cnx.getInputStream(), "utf-8"));
				String output = null;
				while ((output = reader.readLine()) != null) {
					strBuf.append(output);
				}
				result = toEntity(strBuf.toString());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static User createUser(User user, String cntxPath) {
		return createOrUpdate(user, cntxPath + PATH_USER + "/create", "POST");
	}

	public static User updateUser(User user, String cntxPath) {
		return createOrUpdate(user, cntxPath + PATH_USER + "/update", "PUT");
	}

	private static User createOrUpdate(User user, String path, String method) {
		User result = null;
		StringBuilder strBuf = new StringBuilder();
		HttpURLConnection cnx = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(path);
			cnx = (HttpURLConnection) url.openConnection();
			cnx.setRequestMethod(method);
			cnx.addRequestProperty("content-type", "application/json");
			cnx.setDoOutput(true);
			OutputStream stream = cnx.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(stream);
			writer.write(toJson(user));
			writer.close();
			cnx.connect();
			if (cnx.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(cnx.getInputStream(), "utf-8"));
				String output = null;
				while ((output = reader.readLine()) != null) {
					strBuf.append(output);
				}
				result = toEntity(strBuf.toString());

			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
