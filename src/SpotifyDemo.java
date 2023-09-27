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
        System.out.println(SpotifyDemo.requestAccessToken());
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
}
