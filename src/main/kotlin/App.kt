import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.css.*
import models.Video
import models.poke.Pokemon
import react.*
import react.dom.*

external interface AppState : RState {
    var currentVideo: Video?
    var currentPokemon: Pokemon?
    var unwatchedVideos: List<Video>
    var watchedVideos: List<Video>
    var pokemonListe: List<Pokemon>
}



suspend fun fetchPokemon(id: Int): Pokemon {
    val response = window
        .fetch("https://pokeapi.co/api/v2/pokemon/$id")
        .await()
        .json()
        .await()
    return response as Pokemon
}

suspend fun fetchPokemons(): List<Pokemon> = coroutineScope {
    (1..25).map { id ->
        async {
            fetchPokemon(id)
        }
    }.awaitAll()
}


@JsExport
class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        unwatchedVideos = listOf()
        watchedVideos = listOf()
        pokemonListe = listOf()

        val mainScope = MainScope()
        mainScope.launch {

            val pokemon = fetchPokemons()
            setState {
                pokemonListe = pokemon

            }
        }
    }




    override fun RBuilder.render() {
        // typesafe HTML goes here!
        h1 {
            +"Pokemon List"
        }
        div( classes = "row"   ) {
            pokemonList {
                pokemon = state.pokemonListe
                selectedPokemon = state.currentPokemon
                onselectedPokemon = { pokemon ->
                    setState {
                        currentPokemon = pokemon
                    }
                }
            }
        }
        h1 {
            +"KotlinConf Explorer"
        }
        div {
            h3 {
                +"Pokemons"
            }


            h3 {
                +"Videos to watch"
            }
            videoList {
                videos = state.unwatchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }
            h3 {
                +"Videos watched"
            }
            videoList {
                videos = state.watchedVideos
                selectedVideo = state.currentVideo
                onSelectVideo = { video ->
                    setState {
                        currentVideo = video
                    }
                }
            }
        }
        state.currentVideo?.let { currentVideo ->
            videoPlayer {
                video = currentVideo
                unwatchedVideo = currentVideo in state.unwatchedVideos
                onWatchedButtonPressed = {
                    if (video in state.unwatchedVideos) {
                        setState {
                            unwatchedVideos -= video
                            watchedVideos += video
                        }
                    } else {
                        setState {
                            watchedVideos -= video
                            unwatchedVideos += video
                        }
                    }
                }
            }
        }
    }


}

