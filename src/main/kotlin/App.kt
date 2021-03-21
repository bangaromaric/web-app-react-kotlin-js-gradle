import kotlinx.css.*
import models.unwatchedVideos
import models.watchedVideos
import react.*
import react.dom.*
import styled.css
import styled.styledDiv

@JsExport
class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        // typesafe HTML goes here!
        h1 {
            +"KotlinConf Explorer"
        }
        div {
            h3 {
                +"Videos to watch"
            }
            videoList {
                videos = unwatchedVideos
            }
            h3 {
                +"Videos watched"
            }
            videoList {
                videos = watchedVideos
            }
            p {
                +"Tom Jerry: Mouseless development"
            }
        }

        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 {
                +"John Doe: Building and breaking things"
            }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
    }
}