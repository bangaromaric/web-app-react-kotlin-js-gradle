import kotlinx.browser.document
import kotlinx.css.div
import kotlinx.css.img
import models.Video
import models.poke.Pokemon
import react.*
import react.dom.*
import kotlinx.html.js.*
import kotlinx.html.onClick
import org.w3c.dom.HTMLButtonElement

//@JsModule("lodash")
//external val lodash: dynamic
//
//external interface Lodash {
//    fun <K,V> debounce(functionToDebounce: (K) -> V, debounceMillis: Int): (K) -> V
//}

@JsExport
class PokemonList: RComponent<PokemonListProps, RState>() {
    override fun RBuilder.render() {
        for (pokemon in props.pokemon) {
            div(classes = "col s3") {
                div(classes = "card"){
                    div(classes = "card-image"){
                        img(src = "${pokemon.sprites.other.dream_world.front_default}", classes = "materialboxed"){

                            attrs {
                                height="180"
                                onClickFunction = {
                                    println("button clicked: 8" )
                                }
                            }
                        }

                    }
                    div(classes = "card-content"){
                        span(classes = "card-title blue-text"){
                            +"${pokemon.name}"
                        }
                        p{
                            +" little markup to use effectively."
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

//        val xyz: dynamic = js("window.xyz")
//        println("xyz: $xyz")

        document.addEventListener("DOMContentLoaded",{
            val elems = document.querySelectorAll(".materialboxed")
            println("button clicked: $elems" )
//            val instances = M.Materialbox.init(elems)
        })



//        val button = document.getElementById("mybutton") as HTMLButtonElement
//        button.addEventListener("click", {
//            println("image clicked: " )
//            document.title = "button was clicked"
//        })
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