

import kotlinx.browser.document
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


        jq("document").ready(fun(){
            jq(".materialboxed").materialbox()
        })
        


        document.addEventListener("DOMContentLoaded",{
            val elems = document.querySelectorAll(".materialboxed")
            println("button clicked: $elems" )
//            val instances = M.Materialbox.init(elems)
//            val instances = Mat.Materialbox.init(elems)
        })

//val mm = Mat()
//        mm.materialbox()
//        amaterialbox()





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


//       materialbox()

//        jq("document").ready(fun(){
//            jq(".materialboxed").materialbox()
//        })



//        val xyz: dynamic = js("window.xyz")
//        println("xyz: $xyz")

//        document.addEventListener("DOMContentLoaded",{
//            val elems = document.querySelectorAll(".materialboxed")
//            println("button clicked: $elems" )
////            val instances = M.Materialbox.init(elems)
//        })





//        jq(".materialboxed").materialbox()
//        jq(".materialboxed").materializeComp().materialbox()

       /*
        jq("button").click {
            it.preventDefault()
            console.log(it)
        }
        */




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