import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SpotifyDemo {
    // load CLIENT_ID and CLIENT_SECRET from env variable.
    private static final String CLIENT_ID = System.getenv("CLIENT_ID");
    private static final String CLIENT_SECRET = System.getenv("CLIENT_SECRET");

    public static void main(String[] args) {
        String accessToken = SpotifyDemo.requestAccessToken();
        System.out.println(accessToken);

        JSONObject artistData = SpotifyDemo.requestArtistData(accessToken, "3ICflSq6ZgYAIrm2CTkfVP");
        System.out.println(artistData.toString(4));
        // https://open.spotify.com/track/3CnUGF7phvydXWBJUBDDP6?si=15b4460d739f45c9
        JSONObject trackData = SpotifyDemo.requestTrackData(accessToken, "3CnUGF7phvydXWBJUBDDP6");
        System.out.println(trackData.toString(4));

    }

    public static String requestAccessToken() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .add("client_id", CLIENT_ID)
                .add("client_secret", CLIENT_SECRET)
                .build();

        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .post(formBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());

            return responseBody.getString("access_token");
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject requestArtistData(String accessToken, String artistURI) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/artists/".concat(artistURI))
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject requestTrackData(String accessToken, String trackURI) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/tracks/".concat(trackURI))
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        }
        catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
