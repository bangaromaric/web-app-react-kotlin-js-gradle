import kotlinx.browser.document
import kotlinx.css.*
import models.unwatchedVideos
import react.dom.*
import styled.css
import styled.styledDiv

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}