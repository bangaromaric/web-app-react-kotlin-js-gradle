

import kotlinx.browser.document
import lib.M
import models.Video
import models.poke.Pokemon
import react.*
import react.dom.*

@JsName("$")
@JsNonModule
@JsModule("jquery")
external fun jq(id: String): dynamic

//@JsModule("librairy.materialize-css")
//@JsNonModule
//external val librairy.materialize: dynamic





@JsExport
class PokemonList: RComponent<PokemonListProps, RState>() {
    override fun componentDidMount() {
        println("monté: " )

        document.addEventListener("load",{
            val elems = document.querySelectorAll(".materialboxed")
            val instances = M.Materialbox.init(elems){ }
            instances.open()
//          val instance = M.Materialbox.getInstance(elems)


        })

//
//        val elems = document.querySelectorAll(".materialboxed")
//        val instances = M.Materialbox.init(elems) {}






    }



    override fun RBuilder.render() {
        println("rendered" )

        for (pokemon in props.pokemon) {
            div(classes = "col s3") {
                div(classes = "card"){
                    div(classes = "card-image"){
                        img(src = "${pokemon.sprites.other.dream_world.front_default}", classes = "materialboxed"){

                            attrs {
                                height="180"
//                                onClickFunction = {
//                                    println("button clicked: 8" )
//                                }
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