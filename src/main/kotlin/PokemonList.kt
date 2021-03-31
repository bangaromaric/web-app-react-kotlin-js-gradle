import models.Video
import models.poke.Pokemon
import react.*
import react.dom.*

@JsExport
class PokemonList: RComponent<PokemonListProps, RState>() {
    override fun RBuilder.render() {
        for (pokemon in props.pokemon) {
            div(classes = "col s2") {
                div(classes = "card"){
                    div(classes = "card-image"){
                        img(src = "${pokemon.sprites.front_default}"){}
                        span(classes = "card-title blue-text"){
                            +"${pokemon.name}"
                        }
                    }
                    div(classes = "card-content"){
                        p{
                            +" I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively."
                        }
                    }
                }
//                div(classes = "card-panel teal") {
//                    p {
//                        key = pokemon.id.toString()
//                        attrs {
//                            onClickFunction = {
//                                props.onselectedPokemon(pokemon)
//                            }
//                        }
//                        if (pokemon == props.selectedPokemon) {
//                            +"▶ "
//                        }
//                        +"${pokemon.name}: "
//                    }
//                }
            }


        }
    }
}

external interface PokemonListProps: RProps {
    var pokemon: List<Pokemon>
    var selectedPokemon: Pokemon?
    var onselectedPokemon: (Pokemon) -> Unit
}
external interface PokemonListState: RState {
    var selectedVideo: Video?
}

fun RBuilder.pokemonList(handler: PokemonListProps.() -> Unit): ReactElement {
    return child(PokemonList::class) {
        this.attrs(handler)
    }
}