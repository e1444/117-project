# Spotify API demo

## API Documentation
[Spotify API](https://developer.spotify.com/documentation/web-api)

## Java Example
```
String accessToken = SpotifyDemo.requestAccessToken();
System.out.println(accessToken);

JSONObject artistData = SpotifyDemo.requestArtistData(accessToken, "3ICflSq6ZgYAIrm2CTkfVP");
System.out.println(artistData.toString(4));
```

Output:
```
BQCGQ7mWR7MJ1JBYQJikRuUINM6k4WP2UyN5rEkcWkE4Hr98oWGzi09oLrmnBam-dOQidclu5kBxQOcDyExEZG3rLxKwheoQaiFFpG4VYkZPcBntzVI
{
    "images": [
        {
            "width": 640,
            "url": "https://i.scdn.co/image/ab6761610000e5eb3ce1e2a99cffc7c662938b01",
            "height": 640
        },
        {
            "width": 320,
            "url": "https://i.scdn.co/image/ab676161000051743ce1e2a99cffc7c662938b01",
            "height": 320
        },
        {
            "width": 160,
            "url": "https://i.scdn.co/image/ab6761610000f1783ce1e2a99cffc7c662938b01",
            "height": 160
        }
    ],
    "followers": {
        "total": 2288674,
        "href": null
    },
    "genres": [
        "album rock",
        "british invasion",
        "classic rock",
        "hard rock",
        "protopunk",
        "psychedelic rock",
        "rock"
    ],
    "popularity": 64,
    "name": "The Animals",
    "href": "https://api.spotify.com/v1/artists/3ICflSq6ZgYAIrm2CTkfVP",
    "id": "3ICflSq6ZgYAIrm2CTkfVP",
    "type": "artist",
    "external_urls": {"spotify": "https://open.spotify.com/artist/3ICflSq6ZgYAIrm2CTkfVP"},
    "uri": "spotify:artist:3ICflSq6ZgYAIrm2CTkfVP"
}
```
