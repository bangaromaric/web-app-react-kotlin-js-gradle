@file:JsModule("react-youtube-lite")
@file:JsNonModule

import react.*

@JsName("ReactYouTubeLite")
external val reactPlayer: RClass<dynamic>

external interface ReactYouTubeProps : RProps {
    var url: String
}